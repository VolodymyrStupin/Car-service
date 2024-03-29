# Car-service

## _Car service - Spring Boot application (backend project)_

The Car Service project is a software application designed to streamline
and manage the operations of a car repair or service center.
It provides a comprehensive set of features and functionalities to efficiently handle vehicle repairs, maintenance,
and customer management.
Developed using Java and related technologies, the project aims to enhance the overall efficiency, productivity,
and customer satisfaction of a car repair service.

Key Features and Functionality:

Customer Management: The system enables the management of customer information, including registration, contact details,
and vehicle history.
It allows the creation of customer profiles, tracking of previous repairs, and recording of customer preferences.

Appointment Scheduling: Users can schedule appointments for vehicle repairs or maintenance.
The system provides a calendar-based interface to view available time slots, assign mechanics,
and manage the overall schedule.
Automated reminders can be sent to customers to reduce no-shows.

Vehicle Diagnosis and Repair Tracking: The project facilitates the diagnosis of vehicle issues
and tracks the progress of repairs.
Mechanics can log diagnostic findings, update repair status, and record the parts and labor required for each job.
This allows for efficient tracking of repair history and accurate billing.

Billing and Invoicing: The project incorporates a billing module to generate invoices for completed repairs.
It calculates costs based on labor, parts, and any additional services.
The system also supports various payment methods and tracks payment status.

Reporting and Analytics: Comprehensive reports and analytics provide insights into business performance, repair trends,
customer satisfaction, and revenue generation.
These reports help identify opportunities for process improvement and strategic decision-making.

Mechanic and Staff Management: The project includes features to manage mechanics' schedules, track their performance,
and assign tasks based on their expertise and availability.
It also facilitates staff management, including employee profiles, attendance tracking, and performance evaluation.

Integration with External Systems: The application may integrate with external systems such as diagnostic tools,
payment gateways,
or vehicle databases to enhance functionality and streamline data exchange.

User Authentication and Access Control: To ensure data security and privacy, the project includes user authentication
and authorization mechanisms.
It restricts access to sensitive information and functionality based on user roles and permissions.

The Car Service project offers a comprehensive solution for car repair and service centers,
allowing them to effectively manage their operations, improve customer satisfaction, and optimize resource utilization.
It provides a user-friendly interface, automates repetitive tasks,
and facilitates efficient communication between customers, mechanics, and management.
With its robust features, the project aims to enhance the overall service quality
and profitability of a car repair business.

> VERSION: 1.0.0 <br>
> AUTHOR: Volodymyr Stupin <br>
> LINKEDIN: https://www.linkedin.com/in/volodymyr-stupin-6a5526252/ <br>

## Specification

- Spring Boot, web application
- With two module extracted as microservices
- Facade design pattern
- NoSQL databases (MongoDB) and relational databases (MYSQL)
- Good coverage with unit tests, including integration tests
- Controllers tested via mockMvc
- Full containerization in DOCKER (all modules)
- Application deployed on AWS Linux EC2 server
- Netflix-Eureka server used as discovery service
- NGINX Server used as reverse proxy

## Tech

Car Service is developed using following technologies: <br>

Core: <br>
![image](https://img.shields.io/badge/17-Java-orange?style=for-the-badge) &nbsp;
![image](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring) &nbsp;
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white) &nbsp;

![image](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white) &nbsp;
![image](https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white) &nbsp;
![image](https://img.shields.io/badge/redis-%23DD0031.svg?&style=for-the-badge&logo=redis&logoColor=white) &nbsp;
![image](https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white) &nbsp;

Testing:<br>
![image](https://img.shields.io/badge/Junit5-25A162?style=for-the-badge&logo=junit5&logoColor=white) &nbsp;
![image](https://img.shields.io/badge/Mockito-78A641?style=for-the-badge) &nbsp;
![image](https://img.shields.io/badge/Testcontainers-9B489A?style=for-the-badge) &nbsp;

Front:<br>
![Angular](https://img.shields.io/badge/angular-%23DD0031.svg?style=for-the-badge&logo=angular&logoColor=white) &nbsp;
![image](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white) &nbsp;
![image](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white) &nbsp;
![image](https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=whitee) &nbsp;

Deployed on:<br>
![image](https://img.shields.io/badge/Amazon_AWS-FF9900?style=for-the-badge&logo=amazonaws&logoColor=white) &nbsp;

## C4 diagram

The C4 diagram blow presents main application components and module dependencies. <br>
Click on image below to review it more readable size.

#add diagram here..#

## Installation and run

[//]: # (Car Service requires [Docker]&#40;https://www.docker.com/products/docker-desktop/&#41; to run.)

[//]: # (Both car-service-backend and car-service-frontend are pushed as an images into the Docker Hub.)

[//]: # (To deploy and run application, just copy anywhere following files:<br>)

[//]: # (a&#41; Docker-compose file: **[compose-prod.yml]** <br>)

[//]: # (b&#41; Mongo-db admin role initialization: **[init-mongo.js]** <br>)

[//]: # (c&#41; NGINX server configuration file: **[car-service.conf]** <br>)

[//]: # ()
[//]: # (All three files must be in the same folder. After that, just run following command, and wait for)

[//]: # (containers to be pulled up and started.)

[//]: # ()
[//]: # (``)

[//]: # (docker-compose -f compose-prod.yml up)
``

After everything builds and ready, you can test the application using [Postman](https://www.postman.com/)
or use a UI version wrote using Angular.<br>

## Rest-API Endpoints

Application provides many endpoints. Please follow the specification below to see some of them:


|         ENDPOINT          | METHOD |          REQUEST          | RESPONSE |                                 FUNCTION                                  |
|:-------------------------:|:------:|:-------------------------:|:--------:|:-------------------------------------------------------------------------:|
|      api/v1/register      |  POST  |    RequestBody (user)     |   JSON   |                         registration of new user                          |
|       api/v1/login        |  POST  | RequestBody (authRequest) |   JSON   |                  login and generate authentication token                  |
|       api/v1/users        |  GET   |             -             |   JSON   |                  get all registered users with role USER                  |
|     api/v1/send-email     |  POST  |    RequestBody (email)    |   JSON   |                      send mail to the service center                      |
| api/v1/users/{id}/garage  |  GET   |  Path variable (user id)  |   JSON   | get all cars in user garage (there are cars what user has in car service) |
| api/v1/users/{id}/invoice |        |                           |          |                                                                           |
|            ...            |  ...   |            ...            |   ...    |                                    ...                                    |

## Acknowledgments

* [Shields.io](https://img.shields.io)
* [Badges 4 README.md](https://github.com/alexandresanlim/Badges4-README.md-Profile)