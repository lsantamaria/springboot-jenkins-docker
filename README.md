# springboot-jenkins-docker

Example of Springboot project for building it in Jenkins following a pipeline. 

The pipeline uses one docker image for executing the build/test/package mvn phases and another for placing the executable JAR. 

The second image can be run using the following command:

```
docker run -d -t -p <desired_port>:8080 lsantamaria/demo-spring-boot
```
