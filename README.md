# Library

![Library Logo](download.png)

## Table of Contents

- [Introduction](#introduction)
- [ProjectStructure](#projectStructure)
- [EnvironmentSetup](#environmentSetup)
- [Running](#running)
- [Features](#features)
- [CollectionCategories](#collectionCategories)
- [Resources](#resources)
- [Author](#author)


## Introduction

- This project contains an automated API test suite built with **Postman** for managing a library system including **Books**, **Households**, and **Users**. 
- The suite includes full CRUD operations, schema validation, dynamic data generation, and test assertions for response accuracy and performance.

## Examples

### Local testing execution example

![Local testing execution example](execuation.gif)


## 📦 ProjectStructure

```
Library.postman_collection.json         # Main Postman collection file
Library-Test.postman_environment.json   # Environment with variables (e.g., URL)
```

---

## 🔧 EnvironmentSetup

1. Install Node.js (v14+ recommended)
2. Install Newman and htmlextra reporter globally:

```bash
npm install -g newman newman-reporter-htmlextra
```

3. Clone or download this repo and navigate to the directory.

---

## 🚀 Running

To run the entire collection with CLI and HTML report output:

```bash
newman run Library.postman_collection.json \
  -e Library-Test.postman_environment.json \
  --reporters cli,htmlextra \
  --reporter-htmlextra-export output/Library_Report.html
```

Ensure the environment URL is correct:
```env
{{URL}} = http://localhost:3000
```

---

## ✨ Features

- ✅ Full CRUD for **Books**, **Households**, and **Users**
- 🔁 Uses dynamic values (e.g., `{{$randomWords}}`, `{{$randomFullName}}`, `{{releaseDate}}`)
- 📅 Automatically generates random past dates for `releaseDate`
- ✅ Validates:
  - Response status codes
  - Schema (JSON structure and required fields)
  - Response time & size
  - Value match between request & response
- 🧪 Collection variables are dynamically set during test runs
- 📊 Compatible with `htmlextra` HTML reports for easy test result visualization

---

## 📚 Example: Create New Book

### Request:
```http
POST {{URL}}/books
```

### Body:
```json
{
  "title": "{{$randomWords}}",
  "author": "{{$randomFullName}}",
  "isbn": "{{$randomLastName}}",
  "releaseDate": "{{releaseDate}}"
}
```

### Tests:
- Status = 201
- Body fields match request
- Schema is valid
- Response time < 1000ms

---

## 📁 CollectionCategories

- `📚 Books`
  - Create, Read, Update (Full & Partial), Delete
- `🏠 Households`
  - Full lifecycle with validation
- `👤 Users`
  - Same structure and validations (in progress or available in separate section)

---

## 📝 Notes

- Token-based auth (`G-Token: ROM831ESV`) is used in headers
- Uses Postman pre-request scripts to assign random values
- Collection variables like `id`, `title`, etc., are reused across requests

---

## 📎 Resources

- [Postman](https://www.postman.com/)
- [Newman CLI](https://www.npmjs.com/package/newman)
- [HTMLEXTRA Reporter](https://www.npmjs.com/package/newman-reporter-htmlextra)

---
## 🧑‍💻 Author

**Esraa Elkheshen**  
_Contact: [Your Contact Info or GitHub Profile]