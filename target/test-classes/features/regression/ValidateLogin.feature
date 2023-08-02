Feature: To validate login for Orange HRM 

Scenario: To validate login using valid credentials 

Given user starts "Chrome" browser
And user launch app using URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
When user enters text "Admin" using xpath "//input[@name='username']"
And user enters text "admin123" using xpath "//input[@name='password']"
And user clicks on button using xpath "//button[@type='submit']"
Then user validate the URL to be "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"

@wip2907
Scenario Outline: To validate login using Invalid credentials

Given user starts "Chrome" browser
And user launch app using URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
When user enters text '<username>' using xpath "//input[@name='username']"
And user enters text '<password>' using xpath "//input[@name='password']"
And user clicks on button using xpath "//button[@type='submit']"
Then user validate the URL to be '<expectedURL>'

Examples:
| username | password | expectedURL |
| admin	| admin456 | https://opensource-demo.orangehrmlive.com/web/index.php/auth/login|
| admin777	| admin123 | https://opensource-demo.orangehrmlive.com/web/index.php/auth/login|
| admin777	| admin456 | https://opensource-demo.orangehrmlive.com/web/index.php/auth/login|







