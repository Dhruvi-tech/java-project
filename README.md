# 📚 Student Management System

<div align="center">

![Java](https://img.shields.io/badge/Java-8%2B-orange?style=for-the-badge&logo=java)
![Swing](https://img.shields.io/badge/Swing-GUI-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Complete-success?style=for-the-badge)

```
   _____ _             _           __  __                                                   _
  / ____| |           | |         |  \/  |                                                 | |
 | (___ | |_ _   _  ___| |_ ___ _ _| \  / | __ _ _ __   __ _  __ _  ___ _ __ ___   ___ _ __ | |_
  \___ \| __| | | |/ _ \ __/ _ \ '__| |\/| |/ _` | '_ \ / _` |/ _` |/ _ \ '_ ` _ \ / _ \ '_ \| __|
  ____) | |_| |_| |  __/ ||  __/ |  | |  | | (_| | | | | (_| | (_| |  __/ | | | | |  __/ | | | |_
 |_____/ \__|\__,_|\___|\__\___|_|  |_|  |_|\__,_|_| |_|\__,_|\__, |\___|_| |_| |_|\___|_| |_|\__|
                                                             __/ |
                                                            |___/
```

**A sleek desktop application for managing student and teacher data with powerful analytics and a modern GUI!**

</div>

---

## 📋 Table of Contents

- [👥 Team Members & Responsibilities](#-team-members--responsibilities)
- [✨ Features](#-features)
- [🚀 How to Run](#-how-to-run)
- [📂 Project Structure](#-project-structure)
- [🤝 Contributing](#-contributing)

---

## 👥 Team Members & Responsibilities

This project showcases collaborative teamwork with each member owning a distinct module. Here's the breakdown:

| Member | Role | Key Contributions |
|--------|------|-------------------|
| 🥇 **Dhruvi** | Data Foundation & Analytics | Core data models (`Person`, `Student`, `Teacher`), business logic, analytics, validation, file I/O, custom exceptions |
| 🥈 **Archana** | Collections & Threading | Collections management, search functionality, lambda sorting, multithreading |
| 🥉 **Bimala** | GUI & System Integration | Swing GUI development, event handling, module integration, visual design |

---

## ✨ Features

| Feature | Description |
|---------|-------------|
| 🚀 **Splash Screen** | Professional loading experience at startup |
| 👨‍🎓 **Student Management** | Add, view, and manage student records |
| 👩‍🏫 **Teacher Management** | Handle teacher data alongside students |
| 💾 **Data Persistence** | Save/load data to/from `students.txt` |
| 🔍 **Smart Search** | Quick student lookup by name or ID |
| 📊 **Analytics Dashboard** | Comprehensive reporting with tabs for stats, top performers, and grade distribution |
| ✅ **Data Validation** | Robust input validation for age, marks, ID format |
| 🎨 **Modern UI** | Intuitive, visually appealing Swing interface |

---

## 🚀 How to Run

Get started in just a few simple steps!

### Prerequisites
- ☕ **JDK 8+** installed and in PATH

### Quick Start

```bash
# 1. Navigate to project
cd java-project

# 2. Compile (optional: create out/ first)
javac -d out src/Dhruvi/*.java src/Archana/*.java src/Bimala/*.java src/StudentApp.java

# 3. Launch the app
java -cp out StudentApp
```

> 💡 **Tip:** The splash screen appears first, followed by the main interface!

---

## 📂 Project Structure

```
java-project-1/
├── src/
│   ├── Dhruvi/         # 🔧 Core data & analytics engine
│   ├── Archana/        # 📚 Collections, search & threading
│   ├── Bimala/         # 🖥️ GUI & integration layer
│   └── StudentApp.java # 🚀 Main entry point
├── out/                # 📦 Compiled classes
├── README.md           # 📖 You're here!
└── .gitignore          # 🚫 Git ignore rules
```

---

## 🤝 Contributing

This project demonstrates the power of teamwork in Java development. Each module is independently crafted yet seamlessly integrated.

*Built with ❤️ using Java Swing*

---

<div align="center">

**Star this repo if you found it helpful! ⭐**

</div>
