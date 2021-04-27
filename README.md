#SpringBoot API Sample

This is very simple example of a REST service created in Java using spring-boot-starter-data-jpa and spring-boot-starter-web



## Database (Postgres)


Run the database with this command assuming you have docker installed:

    docker run --rm --name servicedb -p 5432:5432 -e POSTGRES_PASSWORD=secret -e POSTGRES_DB=person -d wedocode/postgres-sample:1

###Some useful  Postgres commands 

    psql -U postgres >> to get into psql 
  
    \du - show tables


#Testing

    Simple availablity test from powershell
    iwr http://localhost:8080/api/v1/person -useb

You can import Person_API_Testing.json into Postman if you are curious. 








