# Smart Living Smart Hub

## Project Overview

The Smart_Living_Hub repository contains a Java-based hub simulation that mimics the behavior of various smart devices in a home environment. Built using the Quarkus framework, the hub simulates API interactions with these devices, allowing the mobile app to control, monitor and update the status of each device. The hub acts as an intermediary between the smart devices and the Android application, ensuring seamless communication and real-time updates in response to user actions.

## Key Features

- **Smart Device Simulation:** The hub provides simulated APIs for a wide range of smart devices, allowing users to control devices such as thermostats, air conditions and dehumidifiers from the mobile app without needing physical devices for testing.
- **API Access:** The mobile app communicates with the simulated hub through API requests. This enables device management (e.g. turning on/off, adjusting settings) and the retrieval of device statuses for monitoring purposes.
- **Real-time Device Status Updates:** The hub updates each device's status based on user requests and interactions via the mobile app. For example, if a user changes the thermostat setting or turn off a dehumidifier, the hub reflects these changes and updates the device's state accordingly in the simulated environment.
- **Quarkus Framework:** The hub leverages Quarkus for fast startup times, low memory usage, and reactive architecture, ensuring it is well-suited for cloud-native microservices. This allows the hub to handle multiple API requests efficiently while simulating real-time device control.
- **PostgreSQL Integration:** A PostgreSQL database is used to store device state data, logs and any interactions with the hub. This provides a persistent record of device operations, which can be queried by the Android app for monitoring and energy tracking purposes.

## Dependencies

The Smart_Living_Hub project relies on several essential libraries and frameworks, each serving a specific role in building the application. Below is a summary of the main dependencies used in this project:

### Core Dependencies
1. **Quarkus Framework**
    - **quarkus-rest:** Provides RESTful APIs, enabling the application to expose endpoints for device interactions.
    - **quarkus-rest-jackson:** Adds support for JSON serialization and deserialization using Jackson.
    - **quarkus-hibernate-orm-panache:** Simplifies database interactions and ORM mapping using Panache with Hibernate.
    - 
2. 


## License

This project is licensed under the MIT License - see the [LICENSE](./LICENSE) file for details.
