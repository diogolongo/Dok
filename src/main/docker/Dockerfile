FROM java:8-jre-alpine

ENV JHIPSTER_SLEEP 0
    
#ENV TZ=America/Sao_Paulo

#RUN echo "America/Sao_Paulo" > /etc/timezone
#RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

#ENV http_proxy 'http://172.16.160.150:8080'
#ENV https_proxy 'http://172.16.160.150:8080'

RUN apk --update add tzdata
RUN echo "America/Sao_Paulo" >  /etc/timezone
RUN ln -snf /usr/share/zoneinfo/America/Sao_Paulo /etc/localtime

# add directly the war
ADD *.jar /app.jar

RUN sh -c 'touch /app.jar'
VOLUME /tmp
EXPOSE 8080
CMD echo "The application will start in ${JHIPSTER_SLEEP}s..." && \
    sleep ${JHIPSTER_SLEEP} && \
    java -Djava.security.egd=file:/dev/./urandom -jar /app.jar
