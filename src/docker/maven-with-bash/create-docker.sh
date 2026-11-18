# Builds the image locally (the pipeline builds it on develop, see Dockerfile).
#   The build context is the root of the repository.
cd "$(dirname "$0")/../../.."
docker build --platform linux/amd64 -f src/docker/maven-with-bash/Dockerfile -t gitlab.informatik.uni-bremen.de:5005/evoal/source/evoal-core/evoal/maven-with-bash:3.9.15 .
docker push --platform linux/amd64 gitlab.informatik.uni-bremen.de:5005/evoal/source/evoal-core/evoal/maven-with-bash:3.9.15
