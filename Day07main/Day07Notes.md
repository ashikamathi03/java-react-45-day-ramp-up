# Day 07: Classes, Encapsulation, and Static

A encapsulated Java banking model and transaction system.

---

## 📌 Project Overview

This project implements a secure banking system with strict data encapsulation, static tracking counters, constructor chaining, and custom statement tracking.

### Key Technical Requirements Covered
* **Strict Encapsulation**: All fields are `private`. State mutation is governed by class methods.
* **Constructor Chaining**: Clean constructor overload using `this(...)` delegation without code duplication.
* **Static Counter & Constants**: Auto-incrementing account numbers starting at `AC-1001` and enforcement of `MINIMUM_BALANCE = 500.00`.
* **Atomic Transfer Operations**: Transactions complete safely using conditional execution blocks.

---

## 🛠 Project Structure

```text
.
├── BankAccount.java    # Domain model with encapsulated fields, validation, & transaction history
├── Bank.java           # Account repository & transaction manager
├── Main.java           # Console application driver matching exact test session
└── NOTES.md            # Critical security line analysis, public field bug demo, & dynamic dispatch proof