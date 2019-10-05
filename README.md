# MyAutomation

A Framework which contains mvn structure , Cucumber  using TestNG, Selenium implementation with Extent Report capabilites 


# Docker sartup 

Prerequisite : Docker should be installed with Zalenium 

##To start the Docker instance :
docker run --rm -ti --name zalenium -p 4444:4444 \
      -v /var/run/docker.sock:/var/run/docker.sock \
      -v /tmp/videos:/home/seluser/videos \
      --privileged dosel/zalenium start --desiredContainers 5
 