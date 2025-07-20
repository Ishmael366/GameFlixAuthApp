# GameFlixAuthApp

This is a simple Node.js backend service for authentication using JWT. It supports `/register` and `/login` endpoints.

To build and run the Docker container:

Open your terminal in the project root and run:

docker build -t gameflix-backend .

Then start the container using:

docker run -p 8080:8080 gameflix-backend

Once the server is running, test the API using Postman.

To register a user:

POST http://localhost:8080/register  
Body (JSON):  
{  
  "username": "testuser",  
  "password": "testpassword"  
}

To log in:

POST http://localhost:8080/login  
Body (JSON):  
{  
  "username": "testuser",  
  "password": "testpassword"  
}
