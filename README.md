# GrowthMate Auth Service
The **GrowthMate Auth Service** is a dedicated microservice responsible for managing user identity, authentication, and authorization within the GrowthMate ecosystem. It ensures secure access to resources using industry-standard protocols.

## 🚀 Features
* **User Registration & Login**: Secure onboarding and authentication flows.
* **JWT Management**: Issuance and validation of JSON Web Tokens (Access & Refresh tokens).
* **OAuth2 Integration**: (Optional) Support for social logins (Google, GitHub, etc.).
* **Role-Based Access Control (RBAC)**: Manage permissions for Users, Admins, and Mentors.
* **Password Security**: Hashing using Argon2 or BCrypt.
* **Session Management**: Handling logout and token revocation.

## 🛠 Tech Stack
* **Runtime**: Node.js / Express (or Java/Spring Boot)
* **Database**: MongoDB / PostgreSQL (User credentials and profiles)
* **Caching**: Redis (for token blacklisting/session storage)
* **Security**: Passport.js / Spring Security, JWT, Helmet

## 📋 Prerequisites
Before running this service, ensure you have the following installed:
* Node.js (v16+) or JDK 17+
* Docker & Docker Compose
* A running instance of MongoDB/PostgreSQL

## ⚙️ Installation & Setup
1. **Clone the repository:**
```bash
git clone https://github.com/prince1323/growthmate-auth-service.git
cd growthmate-auth-service
```


2. **Environment Variables:**
Create a `.env` file in the root directory and add the following:
```env
PORT=5000
DB_URI=mongodb://localhost:27017/growthmate
JWT_SECRET=your_super_secret_key
REFRESH_TOKEN_SECRET=your_refresh_token_secret
```


3. **Install dependencies:**
```bash
npm install
# or 
mvn install
```


4. **Run the application:**
```bash
npm run dev
# or
mvn spring-boot:run
```

## 🛣 API Endpoints
| Method | Endpoint | Description | Auth Required |
| --- | --- | --- | --- |
| `POST` | `/api/auth/register` | Register a new user | No |
| `POST` | `/api/auth/login` | Login and receive tokens | No |
| `POST` | `/api/auth/refresh` | Refresh an expired access token | Yes (Refresh Token) |
| `GET` | `/api/auth/me` | Get current user profile | Yes (Access Token) |
| `POST` | `/api/auth/logout` | Revoke tokens and logout | Yes |

## 🏗 Architecture
The service follows a layered architecture to ensure separation of concerns:
* **Controller**: Handles HTTP requests and routing.
* **Service Layer**: Contains the core business logic (hashing, token generation).
* **Repository/DAO**: Interacts with the database.
* **Middleware**: Validates JWTs and handles error logging.
