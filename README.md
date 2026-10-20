# Assignment 5: Strategy Pattern — Hospital Admission System

## Project Overview
This project implements the Strategy Design Pattern for a Hospital Admission Domain. The system dynamically selects and changes algorithms at runtime for patient triage prioritization and hospital bed allocation.

---

## Class Responsibilities Table (SRP)

| Class / Interface | Responsibility |
| :--- | :--- |
| `Patient` | Encapsulates patient details including health parameters and arrival time. |
| `Bed` | Holds attributes defining bed location and availability status. |
| `HospitalResourceMonitor` | Declares contracts retrieving current hospital capacity and state. |
| `FakeHospitalResourceMonitor` | Provides hardcoded environmental data isolating unit tests from external dependencies. |
| `TriageStrategy` | Declares execution contracts computing numerical priority scores for incoming patients. |
| `EmergencySeverityTriage` | Calculates patient priority based on vital signs and pain levels. |
| `FirstComeFirstServedTriage` | Assigns priority scores proportional to patient waiting duration. |
| `VipOrInsuranceTriage` | Evaluates priority strictly matching patient membership status. |
| `BedAllocationStrategy` | Declares operational contracts assigning available beds to registered patients. |
| `SeverityBasedAllocation` | Matches critical condition patients to intensive care unit beds. |
| `NearestDepartmentAllocation` | Assigns patients to available emergency room beds. |
| `OptimalOccupancyAllocation` | Distributes general ward beds ensuring efficient hospital space usage. |
| `TriageContext` | Executes priority calculations by delegating tasks to current triage strategies. |
| `BedAllocationContext` | Executes bed assignments by delegating tasks to active allocation strategies. |
| `TriageSelector` | Instantiates appropriate triage strategies evaluating external environmental parameters. |

---

## Pattern Justification: Why Strategy (Not State or Template Method)?

This implementation strictly adheres to the **Strategy Pattern** for the following architectural reasons:

1. **Strategy vs. State Pattern:**
   In the State pattern, state transitions are typically managed internally by the state objects themselves, and the context transitions through a defined lifecycle. In our Hospital Admission domain, the `TriageContext` does not switch logic automatically as a state machine. Instead, concrete algorithms (`EmergencySeverityTriage`, `VipOrInsuranceTriage`, `FirstComeFirstServedTriage`) are independent, interchangeable algorithms injected externally by a `TriageSelector` or a system operator.

2. **Strategy vs. Template Method Pattern:**
   The Template Method pattern relies on class inheritance, defining an algorithm skeleton in an abstract base class and deferring specific steps to subclasses. In contrast, our solution utilizes object composition. Each triage and bed allocation family relies on interface contracts (`TriageStrategy` and `BedAllocationStrategy`). This decoupled composition allows swapping entire algorithmic behaviors dynamically at runtime without subclassing or modifying context structures.

---

## Git Commit History (Refactoring Links)

- **Before Refactoring (Monolithic implementation with `if-else`/`switch`):** https://github.com/ashimbaykaisar00-ui/hospital_admission_sdp5/commit/0788c50
- **After Refactoring (Clean Strategy Pattern implementation):** https://github.com/ashimbaykaisar00-ui/hospital_admission_sdp5/commit/4d0d068