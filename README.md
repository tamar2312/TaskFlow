
# TaskFlow – RESTful Task Manager
# Tamar Flato

## Getting Started
Running PostgreSQL with Docker
creates a container with PostgreSQL running on port 5432.

docker run --name my-postgres \
    -e POSTGRES_USER=myuser \
    -e POSTGRES_PASSWORD=mypassword \
    -e POSTGRES_DB=mydb \
    -p 5432:5432 -d postgres:16

# Running the Application
Run from IntelliJ IDEA- Run 'TaskFlowApplication'
Once the server starts, the application will be available at:
http://localhost:8080

# Testing the API with curl: testing and interacting with your REST API without needing a frontend or browser

1. Create a new user
curl -X POST -H "Content-Type: application/json" \
-d '{"name":"Tamar"}' \
http://localhost:8080/users

2. Create a new task for a user
curl -X POST -H "Content-Type: application/json" \
-d '{"title":"Homework","description": "math", "status":"TODO", "ownerId":1}' \
http://localhost:8080/tasks

3. Get all tasks
curl http://localhost:8080/tasks

4. Get tasks by user
curl http://localhost:8080/tasks/user/1

5. Update task's status
curl -X PUT -H "Content-Type: application/jso" \
--data 'IN_PROGRESS' \
http://localhost:8080/tasks/2/status

6. Delete a task
curl -X DELETE http://localhost:8080/tasks/1

7. Database Verification
docker exec -it my-postgres psql -U myuser -d mydb
Useful psql Commands
   - \dt  - Show all tables in the database
   - SELECT * FROM tasks;  - View all tasks stored in the database
   - SELECT * FROM users;  -View all users stored in the database
   - \q  - Exit the PostgreSQL shell