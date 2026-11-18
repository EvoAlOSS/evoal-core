# Builds the image locally (the pipeline builds it on develop, see Dockerfile).
cd "$(dirname "$0")"
docker build --platform linux/amd64 -t gitlab.informatik.uni-bremen.de:5005/evoal/source/evoal-core/evoal/alpine-with-jq:3.22 .
docker push gitlab.informatik.uni-bremen.de:5005/evoal/source/evoal-core/evoal/alpine-with-jq:3.22
