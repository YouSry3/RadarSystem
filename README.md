# Quantum Radar

A Java-based traffic radar system that processes vehicle observations, detects traffic violations using configurable rules, and automatically generates traffic fines.

This project was implemented as a solution for a **Fawry Software Engineering Training Task**, focusing on Object-Oriented Programming (OOP), clean architecture, and extensibility.

---

## Features

- Process vehicle observations containing:
  - Plate Number
  - Date
  - Vehicle Type (Private, Truck, Bus)
  - Speed
  - Seatbelt Status
- Validate observations against configurable traffic rules.
- Generate zero or more violations for each observation.
- Automatically issue traffic fines.
- Display all generated fines.
- Display violation statistics by rule.
- Easily add new traffic rules without modifying the radar implementation.

---

## Project Structure

```
src
│
├── enums
│   └── CarType.java
│
├── model
│   ├── Observation.java
│   ├── Violation.java
│   └── Fine.java
│
├── radar
│   └── QuRadar.java
│
├── rules
│   ├── Rule.java
│   ├── SpeedRule.java
│   ├── SeatbeltRule.java
│   ├── PrivateSpeedRule.java
│   └── TruckSpeedRule.java
│
└── Main.java
```

---

## Traffic Rules

| Rule | Condition | Fine |
|------|-----------|------|
| Seatbelt Rule | Seatbelt must be fastened | 100 EGP |
| Private Speed Rule | Maximum speed is 80 km/h | 300 EGP |
| Truck Speed Rule | Maximum speed is 60 km/h | 300 EGP |

---

## Example Output

```text
Traffic for car ABC1234
Total amount: 400 EGP
Violations:
- Seatbelt not fastened : 100 EGP
- speed of 94 exceeded max allowed 80 : 300 EGP

Traffic for car XYZ5678
Total amount: 300 EGP
Violations:
- speed of 70 exceeded max allowed 60 : 300 EGP

===== All Fines =====
ABC1234 -> 400 EGP
XYZ5678 -> 300 EGP

===== Rule Statistics =====
Seatbelt Rule -> 1
Private Speed Rule -> 1
Truck Speed Rule -> 1
```

---

## Technologies

- Java
- Object-Oriented Programming (OOP)
- Java Collections Framework
- Java Time API

---

## Design Principles

- Encapsulation
- Abstraction
- Polymorphism
- Separation of Concerns
- Open/Closed Principle (SOLID)
- Rule-based architecture for easy extensibility

---

## Extending the System

Adding a new traffic rule only requires extending `SpeedRule` (for speed-based rules) or implementing the `Rule` interface directly (for other kinds of rules), then registering it in the radar.

Example — adding a new speed rule for buses:

```java
public class BusSpeedRule extends SpeedRule {

    public BusSpeedRule() {
        super(CarType.BUS, 70, 250, "Bus Speed Rule");
    }
}
```

```java
radar.addRule(new BusSpeedRule());
```

No modification to the `QuRadar` class is required.

---

## Running the Project

1. Clone the repository
```bash
git clone https://github.com/your-username/Quantum-Radar.git
```
2. Open the project in IntelliJ IDEA (or any Java IDE).
3. Run `Main.java`.

---

## Learning Objectives

This project demonstrates:

- Object-Oriented Programming in Java
- Interface-based design
- Rule Engine implementation
- Clean and maintainable code organization
- Extensible software architecture
