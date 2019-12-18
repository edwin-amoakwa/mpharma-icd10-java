FROM centos
MAINTAINER edwin.amoakwa@gmail.com

#RUN yum update
RUN yum -y install java-1.8.0-openjdk-devel
RUN yum -y install maven
ADD ./* /opt/mpharma-icd10-java/
WORKDIR  /opt/mpharma-icd10-java
RUN mvn -Dmaven.test.skip=true install
#CMD ["echo","maven build completed"]
#CMD["echo","Coping files to docker"]
EXPOSE 8080
#WORKDIR /opt/mpharma-icd10-java/target
#COPY target/mpharma-icd10-java-1.0.jar /opt/
#WORKDIR  /opt/mpharma-icd10-java
#RUN java -jar mpharma-icd10-java-1.0.jar
CMD ["java","-jar","mpharma-icd10-java-1.0.jar"]