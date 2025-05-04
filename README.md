# Library

![Library Logo](download.png)

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Variables](#variables)
- [Requirements](#requirements)
- [RunningCollection](#runningCollection)


## Introduction

- This project contains an automated API test suite built with **Postman** for managing a library system including **Books**, **Households**, and **Users**. 
- The suite includes full CRUD operations, schema validation, dynamic data generation, and test assertions for response accuracy and performance.
---


## Examples

# Local testing execution example

![Local testing execution example](execution.gif)

## Features




## Variables

- `{{URL}}` → Base URL for the API (e.g., `https://restful-booker.herokuapp.com`)
- `{{token}}` → Token generated after login (used for updating and deleting bookings)
- `{{bookingid}}` → Booking ID created dynamically

The collection uses **collection variables** and **random data generation** for some fields like first name, last name, and dates.

## Requirements

- **Postman** latest version installed
- **Newman** (optional, for running tests from command line)


## RunningCollection

### Option 1 — Import and Run from Postman

1. Download the `Restful-Booker.postman_collection.json` file.
2. Import the collection into Postman.
3. Set up the required variables (Base URL, Token if needed).
4. Run individual requests or the full collection using **Collection Runner**.

### Option 2 — Run via Newman (Command Line)

```bash
newman run Restful-Booker.postman_collection.json