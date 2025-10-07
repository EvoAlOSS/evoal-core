import json
import http.client
import os
import os.path

# Script for cleaning up the GitLab packages. Otherwise, we generate to many packages
#   and have problems with the quota.
# We want to delete all packages that
#   a) belong to deleted branches/tags
#   b) are not the latest build of the branch 

SERVER   = os.environ.get('CI_SERVER_HOST')
PROJECT  = os.environ.get('CI_PROJECT_ID')
TOKEN    = os.environ.get('PROJECT_ACCESS_TOKEN')
BASE_URL = "/api/v4/projects/%s/" % (PROJECT,)

FIGURES = set(['0', '1', '2', '3', '4', '5', '6', '7', '8', '9'])

# list of all existing branches
branches = []
# list of all existing tags
tags = []

connection = http.client.HTTPSConnection(SERVER)

if "CI_JOB_TOKEN" in os.environ.keys():
    headers = {'JOB-TOKEN' : os.environ.get('CI_JOB_TOKEN')}
else:
    headers = {'PRIVATE-TOKEN' : TOKEN}

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

# delete all artifacts that can be deleted
#connection.request("DELETE", BASE_URL + "artifacts", headers = headers)
#response = connection.getresponse()
#response.read()


###########
###########
# delete job artifacts of deleted branches
job_page=1
jobs_to_delete=[]

existing = set() # collect already existing jobs 

# collect all job ids to delete
print("Collecting jobs for deletion:")
while True:
    connection.request("GET", BASE_URL + "jobs?id=30380&page=%s&per_page=100" % (job_page,), headers = headers)
    response = connection.getresponse() 
    jobs = json.loads(response.read())

    # terminate the loop if there are no jobs in a result 
    if not jobs:
        break

    jobs = [job for job in jobs if not job['tag']] # ignore tags
    jobs = [job for job in jobs if job['ref'][0].isdigit()]  # keep feature branches
    jobs = [job for job in jobs if job['artifacts']] # keep only jobs with artifacts

    tmp = jobs
    jobs = []
    for job in tmp:
        if job['ref'] not in branches:
             print("  '%s' -- tag '%s' is already deleted", (job['id'], job['ref'])) 
             jobs.append(job)
        elif (job['ref'], job['name']) not in existing:
            # keep newest jobs by  
            existing.add((job['ref'], job['name']))
        else:
            print("  '%s' -- '%s/%s' is present in a newer build", (job['id'], job['ref'], job['name'])) 
            jobs.append(job)

    jobs_to_delete += jobs
    job_page+=1

print("Found %s jobs to delete" % (len(jobs_to_delete),))
for job in jobs_to_delete:
    print("  deleting artifacts of job %s" % (job['id'],))
    connection.request("DELETE", BASE_URL + "jobs/%s/artifacts" % (job['id'],), headers = headers)
    connection.getresponse() \
               .read()

# delete packages
connection.request("GET", BASE_URL + "packages?per_page=100", headers = headers)
response = connection.getresponse()

maxPage = int(response.headers["X-Total-Pages"])
currentPage = maxPage 
response.read() #  discard response

print("Deleting packages ...")
counter = 0
while currentPage > 0:
    connection.request("GET", BASE_URL + "packages?per_page=100&page=%s" % (currentPage,), headers = headers)
    response = connection.getresponse()

    for package in json.loads(response.read()):
        if "tags" in package and package["tags"]:
            tag = package["tags"]["ref"]
            continue

        if "pipeline" in package and package["pipeline"]:
            branch = package["pipeline"]["ref"]

            if branch[0] in FIGURES and not (branch in branches or branch in tags):
                print ("  '%s' -- %s" % (package["name"], branch))

                deleteAPI = package["_links"]["delete_api_path"]
                connection.request("DELETE", deleteAPI, headers = headers)
                response = connection.getresponse()
                response.read()

                counter += 1


    currentPage -= 1

print("Deleted %s packages" % (counter,))