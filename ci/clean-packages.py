import json
import http.client
import os
import os.path


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