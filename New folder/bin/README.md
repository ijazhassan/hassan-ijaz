# JUnit5 + Selenium + ExtentReports Automation Project

Run locally:

```
mvn clean test
```

CI: GitHub Actions workflow is located at `.github/workflows/ci.yml` and runs on push/pr to main.

Extent report will be generated at `target/ExtentReport.html` and uploaded as an artifact in CI.
