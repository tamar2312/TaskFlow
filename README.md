
creates a container with PostgreSQL running on port 5432.

docker run --name my-postgres \
-e POSTGRES_USER=myuser \
-e POSTGRES_PASSWORD=mypassword \
-e POSTGRES_DB=mydb \
-p 5432:5432 -d postgres:16
