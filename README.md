# TaskMind - User Service

## 📝 Overview
The **User Service** is a core microservice within the TaskMind platform, responsible for identity management, user registration, and secure authentication flows. It serves as the **Identity Provider (IdP)** and the source of truth for user data across the distributed system.

## 🚀 Key Responsibilities
* **Identity Management:** Seamlessly managing user profiles and sensitive credentials.
* **Authentication & Authorization:** Handling login/registration flows and issuing secure **JWT (JSON Web Tokens)** for stateless session management.
* **Internal Verification:** Providing high-performance identity verification endpoints for the Gateway and Task services.

## 🛠 Tech Stack
* **Language:** Java (OpenJDK 17+)
* **Framework:** Spring Boot / Maven
* **Security:** Spring Security & JWT
* **Containerization:** Docker & Docker Compose
* **Database:** PostgreSQL (or your chosen DB)

## 🏗 Architecture Context
Within the TaskMind ecosystem, the User Service acts as the security backbone:
1.  **Login:** User authenticates via UI.
2.  **Token Issuance:** User Service validates credentials and returns a signed JWT.
3.  **Validation:** The **Gateway Service** intercepts incoming requests to the *Task Service* or *AI Agent Service*, validating the token against the User Service logic.

## 🛣 API Endpoints (Quick Look)
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/api/users/register` | Create a new user account |
| `POST` | `/api/users/login` | Authenticate and receive JWT |
| `GET` | `/api/users/me` | Retrieve current user profile (Protected) |

## 📦 Getting Started
To run this service locally using Docker:

```bash
# Build the image
docker build -t taskmind-user-service .

# Run the container
docker run -p 8081:8081 taskmind-user-service
