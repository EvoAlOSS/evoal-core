import io
import json
import http.client
import os
import os.path
import urllib.request
import xml.dom.minidom 
import zipfile

# Script for generating a Gitlab Pages site that serves all existing EvoAl
#   Update Sites for Eclipse. 

SERVER   = os.environ.get('CI_SERVER_HOST')
PROJECT  = os.environ.get('CI_PROJECT_ID')
TOKEN    = os.environ.get('CI_JOB_TOKEN')
BASE_URL = "/api/v4/projects/%s/repository/" % (PROJECT,)

branches = []
tags = []

SECTIONS = [
    { "name" : "Official Releases",  "matches" : lambda x : x in tags },
    { "name" : "Rolling Release",    "matches" : lambda x : x == "release" },
    { "name" : "Nightly Build",      "matches" : lambda x : x == "develop" },
    { "name" : "Developer Versions", "matches" : lambda x : x not in ["develop", "release"] and x in branches }
]

connection = http.client.HTTPSConnection(SERVER)
headers = {'JOB_TOKEN': TOKEN}

if not os.path.exists("public"):
    os.makedirs("public")

# collect list of all available branches
connection.request("GET", BASE_URL + "branches", headers = headers)
response = connection.getresponse()
for branch in json.loads(response.read()):
    branches.append(branch['name'])

# collect list of all available tags
connection.request("GET", BASE_URL + "tags", headers = headers)
response = connection.getresponse()
for tag in json.loads(response.read()):
    tags.append(branch['name'])

# start download update sites and generate index.html for Update Site
releases = branches + tags
for release in releases:
    path = os.path.join("public", release)
    if not os.path.exists(path):
        os.makedirs(path)

    f = open(path + "/index.html", "w")
    f.write("""<html><head><title>Update Site of %s</title></head><body><h1>Remark</h1><p>This is an Eclipse Update Site and there is nothing so see here. Please add this URL to Eclipse as an Update Site.</p></body>""" % (release,))
    f.close

    try:
        meta_url="https://gitlab.informatik.uni-bremen.de/api/v4/projects/30380/packages/maven/%s/de/evoal/languages/de.evoal.languages.releng.site/" % (release,)

        # read last artifact version
        meta_version_content = urllib.request.urlopen(meta_url + "maven-metadata.xml").read()
        tree = xml.dom.minidom.parseString(meta_version_content)
        mvn_version = tree.getElementsByTagName("version")[0].childNodes[0].nodeValue
 
        # read last upload version
        meta_content = urllib.request.urlopen(meta_url + mvn_version + "/maven-metadata.xml").read()
        tree = xml.dom.minidom.parseString(meta_content)
        version = tree.getElementsByTagName("lastUpdated")[0].childNodes[0].nodeValue

        for snapshotVersion in tree.getElementsByTagName("snapshotVersion"):
            if snapshotVersion.getElementsByTagName("extension")[0].childNodes[0].nodeValue != "zip":
                continue
            
            if snapshotVersion.getElementsByTagName("updated")[0].childNodes[0].nodeValue != version:
                continue
            
            artifactId = tree.getElementsByTagName("artifactId")[0].childNodes[0].nodeValue
            value = snapshotVersion.getElementsByTagName("value")[0].childNodes[0].nodeValue

            url = meta_url + mvn_version + "/" +  artifactId + "-" + value + ".zip"
            print("  loading %s" % (url,))

            zip_response = urllib.request.urlopen(url)
            zip = zipfile.ZipFile(io.BytesIO(zip_response.read()))
            zip.extractall(path)
    except urllib.error.HTTPError:
        print ("Failed to download release %s from" % (release,))
        continue

# Generate landing paage
f = open("public/index.html", "w")
f.write("""
<html>
    <head>
        <title>EvoAl Releases</title>
    </head>
    <body>
        <h1>Available EvoAl Releases, Nightly Builds, and CI Builds</h1>
        <p>
          In the following, we provide update sites, releases and Eclipse update sites for different EvoAl builds.
          The most safe version is to use an official release version. If you need some of the more recent changes in EvoAl, you can use the Nightly build.
        </p>
""")

for section in SECTIONS:
    f.write(f"""
        <h2>{section["name"]}</h2>
        <ul>
""") 

    for release in releases:
        if not section["matches"](release):
            continue

        f.write(f"""
            <li>
                <a href="https://evoal.glpages.informatik.uni-bremen.de/source/evoal-core/{release}">Upate Site of {release}</a>
            </li>""")

    f.write(f"""
        </ul>
""")
f.write("""
    </body>
</html>""")
f.close()