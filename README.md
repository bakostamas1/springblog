# Spring Blog

This is a sample blog application that I created to use as an example of how to take a Spring Boot application to production.
I deployed this application to Railway and you can check it through: https://springblog-production.up.railway.app/

## Existing Endpoints
- root : will welcome you : https://springblog-production.up.railway.app/
- api/posts : will list all of posts on the blog : https://springblog-production.up.railway.app/api/posts
- /{postId} : will list details of particliar post : https://springblog-production.up.railway.app/1

## About the Application

This is a simple web application that exposes a REST API. This application uses Maven as the build tool and the current LTS version of Java, 17. I hope to add more functionality to this application in the future but for now this project uses the following dependencies:

    Spring Web
    Spring Data JDBC
    PostgreSQL Database
