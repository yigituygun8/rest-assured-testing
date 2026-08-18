# REST Assured Testing

REST API manual testing and automation learning project. This repo follows along with the Udemy course "REST API Automation with REST Assured" and grows as new topics are covered.

## About

This repo tracks the process of learning REST API testing from the ground up, from manual testing with Postman to writing Java-based automation scripts with REST Assured, and eventually building a full test automation framework with TestNG and Maven.

It contains multiple independent test experiments against different public/practice APIs (e.g. Google API, JIRA API, Twitter API) as the course progresses. Each API gets its own package under `src/test/java`, sharing a common base setup.

## Tech Stack

- **Java** - project language
- **Maven** - build and dependency management
- **REST Assured** - API automation library
- **TestNG** - test framework (added later in the course)
- **IntelliJ IDEA** - IDE

## Project Structure

```
RestAssuredTesting/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/osmanyigituygun/
│   │   │       └── BaseTest.java        # shared setup (base URI, common config)
│   │   └── resources/
│   └── test/
│       └── java/
│           └── com/osmanyigituygun/
│               ├── googleapi/           # tests for Google API
│               ├── jiraapi/             # tests for JIRA API
│               └── twitterapi/          # tests for Twitter API
├── .gitignore
├── pom.xml
└── README.md
```

`BaseTest` lives under `src/main` because it is reusable setup code, not a test itself. Actual test classes live under `src/test`, one package per API, following Maven's standard directory layout.

## Course Coverage

- REST API architecture and terminology (endpoint, resource, payload, parameter)
- Manual API testing with Postman
- REST request types (GET, POST, PUT, DELETE, etc.)
- REST Assured environment setup
- REST Assured methods and validations
- JSON and XPath response validation
- Practical examples using Google, JIRA, and Twitter APIs
- OAuth authentication
- POJO classes, serialization and deserialization
- Response logging
- Migrating to the TestNG framework
- Maven build management
- Creating a BAT file to run the whole project with one click

## How to Run

Make sure Maven is installed, then from the project root:

```bash
mvn clean install
mvn test
```

## Notes

This repo is dedicated to the REST Assured course. Each new API tested gets its own package under `src/test/java/com/osmanyigituygun/`, reusing the shared `BaseTest` setup from `src/main`.