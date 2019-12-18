FROM centos
MAINTAINER edwin.amoakwa@gmail.com

RUN sudo yum update
RUN sudo yum install java-1.8.0-openjdk-devel
RUN sudo yum install maven
RUN sudo mvn -Dmaven.test.skip=true install
CMD ["echo","maven build completed"]
CMD ["echo","Coping files to docker"]
EXPOSE 8080
COPY target/mpharma-icd10-java-1.0.jar /opt/
WORKDIR  /opt/
RUN java -jar mpharma-icd10-java-1.0.jar