FROM openjdk:8u191-jre-alpine3.8
WORKDIR /usr/share/automation
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs
ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -Dbrowser=$BROWSER -DhubMachine=$hubMachine org.testng.TestNG -testclass cucumberOptions.TestNGTestRunnerClass