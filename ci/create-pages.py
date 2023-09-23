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

SERVER=os.environ.get('CI_SERVER_HOST')
PROJECT=os.environ.get('CI_PROJECT_ID')
TOKEN=os.environ.get('CI_JOB_TOKEN')

BASE_URL="/api/v4/projects/%s/repository/" % (PROJECT,)

connection = http.client.HTTPSConnection(SERVER)
headers = {'JOB_TOKEN': TOKEN}



if not os.path.exists("public"):
    os.makedirs("public")

branches = []
# print branches
connection.request("GET", BASE_URL + "branches", headers = headers)
response = connection.getresponse()
for branch in json.loads(response.read()):
    branches.append(branch['name'])

tags = []
# print tags
connection.request("GET", BASE_URL + "tags", headers = headers)
response = connection.getresponse()
for tag in json.loads(response.read()):
    tags.append(branch['name'])

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

            zip_response = urllib.request.urlopen(url)
            zip = zipfile.ZipFile(io.BytesIO(zip_response.read()))
            zip.extractall(path)

    except urllib.error.HTTPError:
        print ("Failed to download release %s" % (release,))
        continue

f = open("public/index.html", "w")
f.write("<html><head><title>EvoAl Update Sites</title></head><body><h1>Available Update Sites</h1>")
f.write("<h2>Official Releases</h2><ul>")
for release in tags:
    f.write("""<li><a href="https://evoal.glpages.informatik.uni-bremen.de/source/evoal-core/%s">%s</a></li>""" % (release, release))

f.write("</ul><h2>Development Versions</h2><ul>")
for release in branches:
    f.write("""<li><a href="https://evoal.glpages.informatik.uni-bremen.de/source/evoal-core/%s">%s</a></li>""" % (release, release))
f.write("</ul></body></html>")
f.close()
