# Speechify-Automation-Android

# Appium + Kotlin (+ Allure)

Simple example for creating mobile auto tests using appium, kotlin and allure reports.

## What Do You Need (macOS)
* [install brew](https://brew.sh/)
* node: `brew install node`
* Appium: `npm install appium`
* [Appium Desktop](http://appium.io/downloads.html)
* Android SDK Tools
* Allure `npm install allure` && `npm install allure-commandline --save-dev`
* Device or emulator/simulator
* [iOS setup](http://appium.io/docs/en/drivers/ios-xcuitest-real-devices/)


## How To Run Tests

`./gradlew :test`

## Generate Report
`allure generate build/allure-results --clean -o allure-report`

`allure serve build/allure-results` for tmp report
