Feature: To validate Registration functionality

@wip0108a
Scenario: To validate registration functionality using valid data

Given user starts "Chrome" browser
And user launch app using URL "https://adactinhotelapp.com/"
When user clicks on linktext using xpath "//a[text()='New User Register Here']"
And user enters text "reyaz0109" using xpath "//input[@name='username']"
And user enters text "reyaz123" using xpath "//input[@name='password']"
And user enters text "reyaz123" using xpath "//input[@name='re_password']"
And user enters text "Reyaz S" using xpath "//input[@name='full_name']"
And user enters text "reyaz016@gmail.com" using xpath "//input[@name='email_add']"
And user enters text "harpagon" using xpath "//input[@name='captcha']"
And user clicks check box using xpath "//input[@name='tnc_box']"
And user clicks on button using xpath "//input[@name='Submit']"
Then validate text on element using xpath "//label[@id='captcha_span']" to be "Captcha is Invalid"

@abcde
Scenario: To validate registration functionality using valid data and data table

Given user starts "Chrome" browser
And user launch app using URL "https://adactinhotelapp.com/"
When user clicks on linktext using xpath "//a[text()='New User Register Here']"
And user enters details in registration form
|reyaz0110|reyaz123|reyaz123|Reyaz s|reyaz016@gmail.com | harpagon|
And user clicks check box using xpath "//input[@name='tnc_box']"
And user clicks on button using xpath "//input[@name='Submit']"
Then validate text on element using xpath "//label[@id='captcha_span']" to be "Captcha is Invalid"

@wxyz
Scenario: To validate registration functionality using valid data and data table

Given user starts "Chrome" browser
And user launch app using URL "https://adactinhotelapp.com/"
When user clicks on linktext using xpath "//a[text()='New User Register Here']"
And user enters details in registration form2
|username|password|confirm password|full name| email address|captcha|
|reyaz0111|reyaz123|reyaz123|Reyaz s|reyaz016@gmail.com | harpagon|
And user clicks check box using xpath "//input[@name='tnc_box']"
And user clicks on button using xpath "//input[@name='Submit']"
Then validate text on element using xpath "//label[@id='captcha_span']" to be "Captcha is Invalid"