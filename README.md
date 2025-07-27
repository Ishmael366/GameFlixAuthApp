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

---

## GitHub Actions CI/CD Workflow

This project includes a GitHub Actions workflow that runs automatically on every push or pull request to the `main` branch. It builds the Node.js app and Docker image for continuous integration.

### Workflow File Location

.github/workflows/ci.yml

### Workflow Steps

- Checks out the repository
- Sets up Node.js environment
- Installs dependencies using `npm install`
- Builds the Docker image using the included `Dockerfile`

No manual steps are required beyond pushing to GitHub. On every change to the `main` branch, the workflow will automatically run and show results in the "Actions" tab on GitHub.
