## Setup and Installation

1. Clone the repository.
2. Navigate to the project directory.
3. Build the project:
    bash
    mvn clean install
    
4. Run the application:
    bash
    mvn spring-boot:run
    
5. Access the API documentation at `http://localhost:8080/swagger-ui.html`.

## API Endpoints

### User Endpoints
- `POST /api/users/`: Create a new user.
- `GET /api/users/`: Retrieve all users.
- `GET /api/users/{id}`: Retrieve user details by ID.

### Expense Endpoints
- `POST /api/expenses/`: Add a new expense.
- `GET /api/expenses/user/{userId}`: Retrieve expenses for a user.
