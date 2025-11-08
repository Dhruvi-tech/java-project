# Basic Classes & Data Module
**Author:** Dhruvi  
**Last edited:** November 2025

## Module Coverage
- Module 1: Classes, Inheritance
- Module 2: Packages, Exception Handling

## Files Included
1. **Person.java** - Base person class with name, age
2. **Student.java** - Extends Person, adds student ID, marks, pass/fail status
3. **Teacher.java** - Extends Person, adds subject
4. **CustomException.java** - Simple custom exception with timestamps
5. **DataValidator.java** - Validates student ID format
6. **StudentData.java** - Save/load student data to file
7. **Main.java** - Demo program with 30 students and 10 teachers

## How to Run
```bash
cd basic-classes-data
javac Person.java Student.java Teacher.java CustomException.java DataValidator.java StudentData.java Main.java
java Main
```

## Features
- ✅ Classes and Inheritance (Person → Student/Teacher)
- ✅ Exception Handling (CustomException)
- ✅ File I/O Operations (StudentData)
- ✅ Data Validation (DataValidator)
- ✅ Age validation (18-21 for students)
- ✅ Pass/Fail functionality (50+ marks = Pass)
- ✅ Beautiful table output format