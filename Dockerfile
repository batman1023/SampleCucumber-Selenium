FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

# Workspace
WORKDIR /Users/Owner/IdeaProjects/SampleCucumberSelenium


# ADD .jar under target from host
# into this image
ADD target/SampleCucumberSelenium-1.0-SNAPSHOT.jar 			SampleCucumberSelenium-1.0-SNAPSHOT.jar
ADD target/SampleCucumberSelenium-1.0-SNAPSHOT-tests.jar 	SampleCucumberSelenium-1.0-SNAPSHOT-tests.jar
ADD target/libs							libs

# in case of any other dependency like .csv / .json / .xls
# please ADD that as well

# ADD suite files
# ADD book-flight-module.xml				book-flight-module.xml
# ADD search-module.xml					search-module.xml

# ADD health check script
ADD healthcheck.sh                      healthcheck.sh

# BROWSER
# HUB_HOST
# MODULE

ENTRYPOINT sh healthcheck.sh
