# EvoAl runtime image, e.g., as base image of GitLab workspaces (see README.md):
#   Java 25 (JRE), OpenBLAS (for smile) and the Linux package of EvoAl in
#   /opt/evoal. The pipeline builds it for the branch release (tags nightly and
#   nightly-<commit>) and for every tag (tags <version> and latest).
#
# Build context: a folder with the Linux package as evoal.zip (the job image:evoal
#   downloads it from the package registry).

FROM docker.io/library/eclipse-temurin:25-jre-noble

RUN apt-get update \
 && apt-get install --yes --no-install-recommends bash ca-certificates curl git libopenblas0 unzip \
 && ln -sf /usr/lib/x86_64-linux-gnu/libopenblas.so.0 /usr/lib/x86_64-linux-gnu/libopenblas.so \
 && rm -rf /var/lib/apt/lists/*

COPY evoal.zip /tmp/evoal.zip
RUN unzip -q /tmp/evoal.zip -d /opt \
 && mv /opt/evoal-linux-x86_64 /opt/evoal \
 && rm /tmp/evoal.zip \
 && chmod -R a+rX /opt/evoal

ENV EVOAL_HOME=/opt/evoal
ENV PATH=/opt/evoal/bin:$PATH

# GitLab workspaces start the container with an arbitrary non-root user (uid 5001
#   by default) in group 0, so the home folder is writable for group 0.
RUN useradd --uid 5001 --gid 0 --create-home --home-dir /home/evoal --shell /bin/bash evoal \
 && chmod -R g+rwX /home/evoal
ENV HOME=/home/evoal
USER 5001
WORKDIR /home/evoal

CMD ["bash"]
