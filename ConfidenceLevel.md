# Bug Report Summary #

## System Under Test (SUT): Aegir web application
## Test Project: Clean Data Flow

### **Test Environment**

*   **Browser**: Firefox (v130.0 (64 bit))

*   **Devices Tested**: Desktop (Windows 10 (64 bit))

*   **Selenium Version**: 4.15.0

*   **JDK Version**: OpenJDK 22.0.2

This report details a series of issues identified during the testing of the registration and data entry functionalities of the Aegir web application. The primary focus was on input validation, duplicate entries, and incorrect form behavior. The issues identified could lead to security vulnerabilities, user frustration, and data integrity problems.

___
___

### **Bug reports** ###

**SI3TASK2-1 Successful registration with a username that already exists in the database.**

_**Severity: High**_

_During registration, the system allows two identical usernames to be added to the database._

**User story:** As an Administrator, I want to register with my username and password to personalize my credentials.

**Steps:**

1. Navigate to the registration page, and click on the Signup button.
2.    Enter valid credentials (username and password).
3.    Confirm the password by entering it again in the confirmation field.
4.    Click on the submit button to send the registration form.
5. 	Navigate back.
6. 	Try registering again using the same username and password.

**Expected result:** The second registration with the same credentials will not be successful.

**Actual result:** The second registration with the same credentials was successful.

---

**SI3TASK2-2 There is no limit to the length of the username text.**

**_Severity: Medium_**

_During registration, the system allows the user to enter a name of any length. This can include special characters._

**User story:** As an Administrator, I want to register with my username and password to personalize my credentials.

**Steps:**

1. Navigate to the registration page, and click on the Signup button.
2. Enter a long or one character short username with special characters and a valid password.
3. Confirm the password by entering it again in the confirmation field.
4. Click on the submit button to send the registration form.

**Expected result:** The system will give a warning if the username is too long or too short.

**Actual result:** The registration with the long name was successful.

---

**SI3TASK2-3 There is no upper limit to the length of the password text.**

**_Severity: Medium_**

_During registration, the system allows the user to enter an arbitrary password if it exceeds the mandatory eight characters._

**User story:** As an Administrator, I want to register with my username and password to personalize my credentials.

**Steps:**

1. Navigate to the registration page, and click on the Signup button.
2.    Enter a valid username and a long (e.g. 50 characters) password.
3.    Confirm the password by entering it again in the confirmation field.
4.    Click on the submit button to send the registration form.

**Expected result:** The system will give a warning if the password name is too long.

**Actual result:** The registration with the long password was successful.

---

**SI3TASK2-4 The data entered is still visible after the logout.**

**_Severity: High_**

_The data entered is still visible on the List page after the user has logged out._

**User story:** As an Administrator, I want to log in so that the data I enter are safe from outsiders.

**Precondition:** 
* The user is logged in
* At least one student's data has been registered, and the List page shows this.
* The user stays on the List page

**Steps:**

1. Click on the Logout button
2.    Navigate back to the List page

**Expected result:** The user sees the Login page.

**Actual result:** The List page shows the entered data.

---

**SI3TASK2-5 There is no warning to the user in the event of invalid data entry by the user.**

_**Severity: Medium**_

_The system does not warn the user as soon as he or she enters the invalid data. It only warns the user when the form is submitted by pressing the submit button._

**User story:** As an Administrator, I want to get feedback about the data I enter so that I can fix any mistakes early on.

**Precondition:** 
* The user is logged in, and the "Data Entry" form is open.

**Steps:**
1. Fill in all mandatory fields for a new student and submit the form.

**Expected result:** The system warns the user after he or she has entered invalid data.

**Actual result:** The system displays the fields with invalid data only after clicking the Submit button.

---

**SI3TASK2-6 Duplicate student entries are allowed**

**_Severity: High_**

_The system allows the creation of duplicates of the student's data._

**User story:** As an Administrator, I want to see a list of the saved data so that I can check which students are already entered.

**Precondition:** 
* The user is logged in, and the "Data Entry" form is open.

**Steps:**

1. Fill in all mandatory fields for a new student and submit the form.
2. 	Re-enter the same data and submit the form again.
3. 	Go to the student list.

**Expected result:** The list shows one student with the entered data.

**Actual result:** The list shows two students with the same data.

---

**SI3TASK2-7: Some input fields have no limit to the length of the entered text.**

_**Severity: Medium**_

_While filling out the form, the system allows the user to enter an input of any length. This can include special characters. The involved fields are first name, last name, city, and street address._

**Precondition:** 
* The user is logged in, and the "Data Entry" form is open.
* The Submit button has been clicked.

**Steps:**

1. Select an input field: first name, last name, city or street address
2. Enter a long or one-character short input with special characters

**Expected result:** The system warns the user after he or she has entered invalid data.

**Actual result:** The system accepts the entered data.
	
---

**SI3TASK2-8: The email field only the @ validates.**

_**Severity: Medium**_

_While filling out the form, the system allows the user to enter an invalid email address._

**Precondition:** 
* The user is logged in, and the "Data Entry" form is open.
* The Submit button has been clicked.

**Steps:**

1. Select the Email input field, enter something like this: something@likethis

**Expected result:** The system warns the user after he or she has entered invalid data.

**Actual result:** The system accepts the entered data.

---

**SI3TASK2-9: The phone field validates any character, and it has not upper limit of the entered text .**

_**Severity: Medium**_

_While filling out the form, the system allows the user to enter an invalid phone number._

**Precondition:** 
* The user is logged in, and the "Data Entry" form is open.
* The Submit button has been clicked.

**Steps:**

1. Select the phone input field, enter a long (e.g. 50 characters) text with special characters

**Expected result:** The system warns the user after he or she has entered invalid data.

**Actual result:** The system accepts the entered data.

---

**SI3TASK2-10: The Personal ID field validates any combination of numbers.**

_**Severity: Medium**_

_When filling in the form, the system allows the user to enter an invalid personal ID if it starts with 1, 2, 3, or 4 and fits the pattern c-yyyymmdd-sssk. The first number must not be greater than 4, the year must not be greater than 2099, the month must not be greater than 19 and the day must not be greater than 39. The 's' and the 'k' numbers are not bigger than 9._

**Precondition:** 
* The user is logged in and the Data Entry form is open.
* The Submit button has been clicked.

**Steps:**

1. Select the Personal ID input field and use the c-yyyymmdd-sssk pattern, such as 1-20241932-0100.

**Expected result:** The system warns the user after he or she has entered invalid data.

**Actual result:** The system accepts the data entered.

**NOTE:** 

**The application documentation incorrectly mentions the format: c-yymmdd-sssk, and the application does not consider the calculation and creation method from the documentation!**

---

**SI3TASK2-11: The Zip field does not validate numbers between 1000 and 1010.**

_**Severity: Medium**_

_When filling in the form, the system does not allow the user to enter a Zip code between 1000 and 1010. The first valid number is 1011._

**Precondition:** 
* The user is logged in and the Data Entry form is open.
* The Submit button has been clicked.

**Steps:**

_**Severity: Medium**_

* Select the Zip code input field and enter 1008.

**Expected result:** The system accepts the data entered.

**Actual result:** The system warns the user of the invalid data.

**NOTE:**

**The application documentation says the form is exactly 4 digits and cannot start with 0...**

---

**SI3TASK2-12: The starting date of the course.**

**_Severity: Low_**

_When filling in the form, the system allows the user to enter 2028-01-01._

**Precondition:** 
* The user is logged in and the Data Entry form is open.
* The Submit button has been clicked.

**Steps:**
* Select the starting date input field and pick or enter 2028-01-01.

**Expected result:** The system warns the user of the invalid data.

**Actual result:** The system accepts the data entered.

**NOTE:** 

**The application documentation says the Starting date must be between 2022 and 2028. This must be a subject of further discussion with the Product Owner.** 

---

## **Evaluation and Confidence Level**

Based on the identified issues, the Aegir web application has several critical bugs, particularly regarding input validation and data security. These bugs could affect the reliability and usability of the system, especially in handling duplicate entries and safeguarding user data. **While the core functionality appears to be operational, the lack of adequate validation and error handling significantly undermines confidence in the system.**

**Confidence Level:** **65% confident** that the system will work satisfactorily, given that it requires major fixes to ensure proper functionality and security.
