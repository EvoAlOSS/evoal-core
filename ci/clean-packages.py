import json
import http.client
import os
import os.path
import sys


# Script for generating a Gitlab Pages site that serves all existing EvoAl
#   Update Sites for Eclipse. 

SERVER   = os.environ.get('CI_SERVER_HOST')
PROJECT  = os.environ.get('CI_PROJECT_ID')
TOKEN    = os.environ.get('PROJECT_ACCESS_TOKEN')
BASE_URL = "/api/v4/projects/%s/" % (PROJECT,)

FIGURES = set(['0', '1', '2', '3', '4', '5', '6', '7', '8', '9'])

branches = []
tags = []

connection = http.client.HTTPSConnection(SERVER)
headers = {'PRIVATE-TOKEN' : TOKEN}

# collect list of all available branches
connection.request("GET", BASE_URL + "repository/branches", headers = headers)
response = connection.getresponse()
for branch in json.loads(response.read()):
    branches.append(branch['name'])

# collect list of all available tags
connection.request("GET", BASE_URL + "repository/tags", headers = headers)
response = connection.getresponse()
for tag in json.loads(response.read()):
    tags.append(branch['name'])

# delete all artifacts that can be deleted
connection.request("DELETE", BASE_URL + "artifacts", headers = headers)
response = connection.getresponse()
response.read()

# delete job artifacts of deleted branches
job_page=1
job_ids=[]
while True:
    print("Query page %s" % (job_page,))
    connection.request("GET", BASE_URL + "jobs?id=30380&page=%s&per_page=100" % (job_page,), headers = headers)
    response = connection.getresponse()#

    jobs = json.loads(response.read())
    job_ids += [job['id'] for job in jobs if job['ref'] not in branches and job['ref'][0].isdigit() and job['artifacts']]

    if not jobs:
        break

    job_page+=1

print("Deleting artifacts of %s jobs" % (len(job_ids),))
for job_id in job_ids:
    connection.request("DELETE", BASE_URL + "jobs/%s/artifacts" % (job_id,), headers = headers)
    response = connection.getresponse()
    response.read()


# delete packages
connection.request("GET", BASE_URL + "packages?per_page=100", headers = headers)
response = connection.getresponse()

maxPage = int(response.headers["X-Total-Pages"])
currentPage = maxPage 
response.read() #  discard response

counter = 0
while currentPage > 0:
    connection.request("GET", BASE_URL + "packages?per_page=100&page=%s" % (currentPage,), headers = headers)
    response = connection.getresponse()

    for package in json.loads(response.read()):
        if "tags" in package and package["tags"]:
            tag = package["tags"]["ref"]

            if tag not in tags:
                print ("Have to delete %s" % (package["name"], ))

        if "pipeline" in package and package["pipeline"]:
            branch = package["pipeline"]["ref"]

            if branch[0] in FIGURES and branch not in branches:
                print ("Deleting '%s' -- %s" % (package["name"], branch))

                deleteAPI = package["_links"]["delete_api_path"]
                connection.request("DELETE", deleteAPI, headers = headers)
                response = connection.getresponse()
                response.read()

                counter += 1


    currentPage -= 1

print("Deleted %s packages" % (counter,))