#!/bin/sh

SOURCE_BRANCH=$1
TARGET_BRANCH=$2

#TOKEN    = os.environ.get('PROJECT_ACCESS_TOKEN')
BASE_URL="${CI_SERVER_PROTOCOL}://$CI_SERVER_HOST/api/v4/projects/$CI_PROJECT_ID/"


echo "Creating a merge request to merge '$SOURCE_BRANCH' into '$TARGET_BRANCH'"

##
## Check for diff
##
echo "  Checking '$SOURCE_BRANCH' into '$TARGET_BRANCH' for differences."

SOURCE_COMMIT=`curl -s -X GET "$BASE_URL/repository/branches/${SOURCE_BRANCH}" \
                    --header "PRIVATE-TOKEN:${PROJECT_ACCESS_TOKEN}" | jq .commit.id`
TARGET_COMMIT=`curl -s -X GET "$BASE_URL/repository/branches/${TARGET_BRANCH}" \
                    --header "PRIVATE-TOKEN:${PROJECT_ACCESS_TOKEN}" | jq .commit.id`

if [ "$SOURCE_COMMIT" = "$TARGET_COMMIT" ]; then
  echo "    No difference found. Quitting."
fi
echo  "    Commits are $SOURCE_COMMIT and $TARGET_COMMIT. Continuing."

##
## Check for existing but maybe failed merge request
##
echo "  Checking if merge request already exists ..."
LISTMR=`curl --silent "${BASE_URL}merge_requests?state=opened" --header "PRIVATE-TOKEN:${PROJECT_ACCESS_TOKEN}"`;
COUNTBRANCHES=`echo ${LISTMR} | grep -o "\"source_branch\":\"${CI_COMMIT_REF_NAME}\"" | wc -l`;

if [ ! ${COUNTBRANCHES} -eq "0" ]; then
  echo "    Merge request already exists. Quitting."
fi
echo "    no merge request found. Continuing"

##
## Create a new merge request
##
echo "  Creating a new merge request ..."

# User 24 is berber
USER_ID=24
BODY="{
    \"id\": ${CI_PROJECT_ID},
    \"source_branch\": \"${SOURCE_BRANCH}\",
    \"target_branch\": \"${TARGET_BRANCH}\",
    \"remove_source_branch\": false,
    \"title\": \"Auto: Merge '${SOURCE_BRANCH}' into '${TARGET_BRANCH}'\",
    \"assignee_id\":\"24\"
}";

# No MR found, let's create a new one
MR=`curl -s -X POST "$BASE_URL/merge_requests" \
         --header "PRIVATE-TOKEN:${PROJECT_ACCESS_TOKEN}" \
         --header "Content-Type: application/json" \
         --data "${BODY}";`

IID=`echo $MR | jq ".iid"`
#IID=81

##
## Wait for Gitlab to process last request
##
echo "  Sleeping for 10s to wait for Gitlab ..."
sleep 10s

##
## Create a new merge request
##
echo "  Turn on auto merge ..."

BODY="{
    \"merge_commit_message\": \"Automatically merged ${SOURCE_BRANCH} to ${TARGET_BRANCH}\",
    \"should_remove_source_branch\": false,
    \"merge_when_pipeline_succeeds\": true,
    \"squash\": false
}";

OUT=`curl -s -X PUT "$BASE_URL/merge_requests/$IID/merge?merge_when_pipeline_succeeds=true" \
         --header "PRIVATE-TOKEN:${PROJECT_ACCESS_TOKEN}" \
         --header "Content-Type: application/json" #\
         --data "${BODY}"`

echo "  Created merge request"
