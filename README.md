# Veterinary Management System

Veterinary Management System is a RESTful API that helps manage the operations of a veterinary clinic. This API provides endpoints to manage various resources, including veterinary doctors, customers, animals, vaccines, and appointments.

## Main Features
* Managing veterinarians.
* Managing the available days of doctors. 
* Managing customers.
* Managing animals belonging to customers.
* Managing vaccines applied to animals.
* Creating appointments for animals to veterinarians.

## CRUD Constraints
*CREATED
The data has been successfully saved in the system.

*VALIDATE_ERROR
There was an error in the data validation process.

*OK
The process has been successfully executed without any issues.

*NOT_FOUND
The requested data could not be found in the system.

*DATE_ERROR
The protection finish date for this vaccine has already expired.

*VACCINE_ERROR
A vaccine with the same code and name has been recently administered.

*DOCTOR_ERROR
The selected doctor is not available on the specified date.

*APPOINTMENT_ERROR
There should be at least a one-hour gap between two appointments.

*NOT_AVAILABLE_ERROR
There are no appointments available at the requested time.

*VACCINE_NULL
No vaccines were found for the specified date range.

*RECORD_ALREADY_EXISTS
A record with this ID already exists in the system.

*APPOINTMENT_ALREADY_EXISTS
An appointment is already scheduled for that day and time.

*RECORD_NOT_FOUND_WITH_ID
No record was found in the system with the specified ID.

## Images
*Entity Relationship Diagram*
![uml diagram vet](https://github.com/user-attachments/assets/a7e04ee0-4560-4dd2-bad4-ff88d7aafc95)


![postman1](https://github.com/user-attachments/assets/4eae8b9e-00d9-4757-8289-c2be6dc84a0a)


![postman2](https://github.com/user-attachments/assets/669e561c-1c4b-4af8-8af7-63c38e384fc9)



## API Endpoints

| Endpoint                                          | HTTP Method | Description                                                                 |
|---------------------------------------------------|:------------|-----------------------------------------------------------------------------|
| **customers**                                     |             |                                                                             |
| `/api/customers/id/{id}`                          | GET         | Retrieves a customer with a specific ID.                                    |
| `/api/customers/{id}`                             | PUT         | Updates a customer with a specific ID.                                      |
| `/api/customers/delete/{id}`                      | DELETE      | Deletes a customer with a specific ID.                                      |
| `/api/customers`                                  | POST        | Creates a new customer.                                                     |
| `/api/customers/name/{name}`                      | GET         | Filters customers by their names.                                           |
|                                                   |             |                                                                             |
| **animals**                                       |             |                                                                             |
| `/api/animals/id/{id}`                            | GET         | Retrieves an animal with a specific ID.                                     |
| `/api/animals/{id}`                               | PUT         | Updates an animal with a specific ID.                                       |
| `/api/animals/delete/{id}`                        | DELETE      | Deletes an animal with a specific ID.                                       |
| `/api/animals/all`                                | GET         | Retrieves all animals.                                                      |
| `/api/animals`                                    | POST        | Creates a new animal.                                                       |
| `/api/animals/name/{name}`                        | GET         | Filters animals by their names.                                             |
| `/api/animals/customerName/{name}`                | GET         | Retrieves animals of a customer with a specific ID.                         |
| **vaccines**                                      |             |                                                                             |
| `/api/vaccines/{id}`                              | GET         | Retrieves a vaccine with a specific ID.                                     |
| `/api/vaccines/`                                  | PUT         | Updates a vaccine with a specific ID.                                       |
| `/api/vaccines/delete/{id}`                       | DELETE      | Deletes a vaccine with a specific ID.                                       |
| `/api/vaccines/animal/{animalId}`                 | GET         | Retrieves vaccines by animal ID.                                            |
| `/api/vaccines`                                   | POST        | Creates a new vaccine.                                                      |
| `/api/vaccines/validity`                          | GET         | Retrieves vaccine protection dates within a specified date range.           |
|                                                   |             |                                                                             |
| **doctors**                                       |             |                                                                             |
| `/api/doctors/{id}`                               | GET         | Retrieves a doctor with a specific ID.                                      |
| `/api/doctors/`                                   | PUT         | Updates a doctor with a specific ID.                                        |
| `/api/doctors/delete/{id}`                        | DELETE      | Deletes a doctor with a specific ID.                                        |
| `/api/doctors/name/{name}`                        | GET         | Retrieves doctors by name.                                                  |
| `/api/doctors`                                    | POST        | Creates a new doctor.                                                       |
| **available_dates**                               |             |                                                                             |
| `/api/available_dates/{id}`                       | GET         | Retrieves an available date with a specific ID.                             |
| `/api/available_dates/{id}`                       | PUT         | Updates an available date with a specific ID.                               |
| `/api/available_dates/delete/{id}`                | DELETE      | Deletes an available date with a specific ID.                               |
| `/api/available_dates`                           | POST        | Creates a new available date.                                               |
|                                                   |             |                                                                             |
| **appointments**                                  |             |                                                                             |
| `/api/appointments/{id}`                          | GET         | Retrieves an appointment with a specific ID.                                |
| `/api/appointments/    `                          | PUT         | Updates an appointment with a specific ID.                                  |
| `/api/appointments/delete/{id}`                   | DELETE      | Deletes an appointment with a specific ID.                                  |
| `/api/appointments/filterDate`                    | GET         | Retrieves appointments by date range and animal name.                       |
|                                                   |             |                                                                             |
|                                                   |             |                                                                             |
|                                                   |             |                                                                             |
