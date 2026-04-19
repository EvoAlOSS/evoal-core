import json
import http.client
import os
import os.path

from functools import reduce

# Script for cleaning up the GitLab packages. Otherwise, we generate to many packages
#   and have problems with the quota.
# We want to delete all packages that
#   a) belong to deleted branches/tags
#   b) are not the latest build of the branch 

SERVER   = os.environ.get('CI_SERVER_HOST')
PROJECT  = os.environ.get('CI_PROJECT_ID')
TOKEN    = os.environ.get('PROJECT_ACCESS_TOKEN')
BASE_URL = "/api/v4/projects/%s/" % (PROJECT,)

connection = http.client.HTTPSConnection(SERVER)

if "CI_JOB_TOKEN" in os.environ.keys():
    headers = {'JOB-TOKEN' : os.environ.get('CI_JOB_TOKEN')}
else:
    headers = {'PRIVATE-TOKEN' : TOKEN}


def fetch_paginated_data(url):
    page = 1
    result = []
    while True:
        connection.request("GET", url + "?page=%s&per_page=100" % (page,), headers = headers)
        response = connection.getresponse()
        data = json.loads(response.read())

        # terminate the loop if there are no jobs in a result 
        if not data:
            break

        result += data
        page = page + 1

    return result


# list of all existing branches
branches = []
# list of all existing tags
tags = []

# collect list of all available branches in variable branches
print("Searching existing branches:")
connection.request("GET", BASE_URL + "repository/branches", headers = headers)
response = connection.getresponse()
for branch in json.loads(response.read()):
    name = branch['name']
    print("  found branch: ", name)
    branches.append(name)

# collect list of all available tags in variable tags
print("Searching existing tags:")
connection.request("GET", BASE_URL + "repository/tags", headers = headers)
response = connection.getresponse()
for tag in json.loads(response.read()):
    name = tag['name']
    print("  found tag: ", name)
    tags.append(name)


# load pipeline information
print("Loading packages ...")
packages = fetch_paginated_data(BASE_URL + "packages")
print("  found %s packages" % (len(packages,)))

print("Filtering tags ...")
is_tag_path = lambda path: reduce(lambda a,b: a or b, [path.startswith(tag + "/") for tag in tags])
is_evoal_release = lambda path: path == "evoal-release"
is_custom_xtext = lambda path: path.startswith("custom-xtext/")

keep_path = lambda path: is_tag_path(path) or is_evoal_release(path) or is_custom_xtext(path)

packages = [p for p in packages if not keep_path(p['name'])]

bases = set()
for package in packages:
    bases.add(package['name'].split('/')[0])


print("Mapping packages to groups")
mapped_packages = {}
for base in bases:
    package_wise = {}
    mapped_packages[base] = package_wise

    for p in packages:
        if not p['name'].startswith(base + "/"):
            continue
        
        package_wise.setdefault(p['name'], list()).append(p)

    for key, value in package_wise.items(): 
        value.sort(key = lambda e : "%s@%s" % (e['name'], e['version']))


print("Marking all packages for deletion that do not belong to a branch")
to_delete=[]
for key1, value1 in list(mapped_packages.items()):
    if key1 not in branches:
        print("Deleting %s" % (key1, ))
        for key2, value2 in value1.items():
            to_delete += value2

        mapped_packages.pop(key1)

to_keep=5
print("Filtering top %s packages" % (to_keep, ))
for key1, value1 in mapped_packages.items():
    for key2, value2 in list(value1.items()):
        to_delete += value2[:-to_keep]



for package in to_delete:
    print(package['_links']['delete_api_path'])







sys.exit(1)
# sort by ref
print("Sorting pipelines by ref ...")
sorted_pipelines = {}
for pipeline in pipelines:
    ref = pipeline['ref']
    sorted_pipelines.setdefault(ref, list()).append(pipeline)


print("Removing entries of (release) tags. We want to keep release information forever")
for tag in tags:
    pi = sorted_pipelines.pop(tag)
    print("  release %s has %s builds" % (tag, len(pi) if pi else 0))

print("Removing entries of merge branches. We want to keep release information forever (for now).")
for key in list(sorted_pipelines.keys()):
    if key.startswith("refs/"):
        print("  removing merge pipeline %s." % (key,))
        sorted_pipelines.pop(key)

to_delete=[]

print("There are %s branches to handle." % (len(sorted_pipelines.keys()), ))
for key, value in list(sorted_pipelines.items()):
    exists = key in branches
    print("  branch %s %s" % (key, "exists" if exists else "does not exist"))

    if not exists:
        print("    removing all %s pipelines related to %s" % (len(value), key))
        sorted_pipelines.pop(key)
        to_delete+=value
    else:
        print("    %s pipelines related to %s" % (len(value), key))
        keep = 10
        for pipeline in value:
            if keep > 0:
                # we keep all broken builds up to the first "keep" that worked
                if pipeline['status'] == 'success':
                    keep -= 1
            else:
                to_delete.append(pipeline)

print("Remaining pipelines:")
for key, value in list(sorted_pipelines.items()):
    print("  ", key)
    for pipeline in value:
        if pipeline in to_delete:
            continue
        print("    ", pipeline['id'])

#'id': 437903, 'iid': 1971

print("Pipelines to delete: %s" % (len(to_delete),))

for pipeline in to_delete:
    deleteUrl="%spipelines/%s" % (BASE_URL, pipeline['id'])

    print("  Deleting pipeline %s using URL %s" % (pipeline['id'], deleteUrl))

    connection.request("DELETE", deleteUrl, headers = headers)
    response = connection.getresponse() \
                         .read()
