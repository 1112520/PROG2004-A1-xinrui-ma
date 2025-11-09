# PROG2004 - Assignment 1
### Student: Xinrui Ma (24832562)
### Email: 3541816510@qq.com
### Repository: [PROG2004-A1-xinrui-ma](https://github.com/1112520/PROG2004-A1-xinrui-ma)

---

Project Overview
This project is developed for **PROG2004 – Object-Oriented Programming**.  
It demonstrates key OOP principles and collection manipulation in Java through a health appointment management system.

The system manages **Health Professionals** and **Appointments**, showcasing **encapsulation**, **inheritance**, **polymorphism**, **composition**, and **collection usage** (`ArrayList`).  
It also includes an **HD-level enhancement** — *appointment time-slot conflict detection*.

---

Key Features

| Feature | Description |
|----------|--------------|
| Encapsulation| Each class (e.g., `HealthProfessional`, `Appointment`) uses private fields with public getters/setters. |
| Inheritance| `GeneralPractitioner` and `Dietitian` inherit from `HealthProfessional`. |
| Polymorphism| Both subclasses override the `printDetails()` method to show specific information. |
| Composition| The `Appointment` class contains a `HealthProfessional` object. |
| Collections| Uses `ArrayList` to manage multiple appointments in the main class (`AssignmentOne`). |
|Validation & Error Handling| Rejects invalid inputs (e.g., empty fields). |
| HD Enhancement – Time Conflict Detection| Prevents creation of new appointments when the same time slot is already taken. |

---

Class Structure
src/
├── AssignmentOne.java // Main driver class (Part 3 & Part 5)
├── HealthProfessional.java // Base class (encapsulation)
├── GeneralPractitioner.java // Subclass (inheritance)
├── Dietitian.java // Subclass (inheritance + override)
└── Appointment.java // Composition class (object within object)
Program Flow Summary

Part 3 – Using Classes and Objects
- Creates multiple `GeneralPractitioner` and `Dietitian` instances.
- Demonstrates inheritance and polymorphism via `printDetails()`.

Part 5 – Collection of Appointments
- Uses an `ArrayList` to store multiple `Appointment` objects.
- Allows user-like simulation of:
  - Creating appointments
  - Printing existing appointments
  - Canceling an appointment

Enhancement
- Adds time-slot conflict validation before appointment creation:
  ```java
  for (Appointment a : appointments) {
      if (a.getTimeSlot().equalsIgnoreCase(timeSlot)) {
          System.out.println("Time slot " + timeSlot + " is already booked. Please choose another time.");
          return;
      }
  }
<img width="554" height="250" alt="image" src="https://github.com/user-attachments/assets/7336f8b1-cbf3-43a8-9d1c-a4d051a73cdf" />
<img width="485" height="251" alt="image" src="https://github.com/user-attachments/assets/60006b28-99bf-4cf9-a359-641f37b2d963" />
<img width="440" height="245" alt="image" src="https://github.com/user-attachments/assets/34937f57-c7cb-4b17-9643-560d1850f673" />


