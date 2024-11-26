@NewCustomer
Feature: Check the New Customer functionality.


  Background: open the Guru99 Bank website.
    Given The Manager navigated to the login page of Guru99 Bank and logged in with his UserID as "mngr590074" and Password as "ehadYmy"


  @Smoke
  Scenario: Test the New Customer functionality of Guru99 Bank when the Manager clicks on the 'New Customer' option to create a New Customer account.
    When the Manager clicks on 'New Customer' option from the menu
    Then the Manager should be redirected to the ‘Add New Customer’ page
    And the Message “Add New Customer” should appear
    And the Customer Name field, Gender, Date of Birth, Address, City, State, PIN, Mobile Number, E-mail, and Password should be displayed
    And Submit button, Reset should be displayed
    And the Home page Link should be visible

  @ValidData @Regression
  Scenario: Test the New Customer functionality of Guru99 Bank when the Manager clicks on the 'New Customer' option to create a New Customer account.
    When the Manager clicks on 'New Customer' option from the menu
    And enters a valid CustomerName as "Ahmed", Select Gender as [male], valid Date of Birth as "11-23-1995", valid Address as "123 Ora Street", valid City Name as "Giza"
    And valid State as "Married", valid PIN as "183822", Valid Mobile Number as "01123123124", valid Email as "ahmed6060@gmail.com" and valid Password as "Ahmed&6060"
    And click on the Submit button
    Then the customer account should be created and the success message 'Customer Registered Successfully!!!' should appear
    And the customer account data that entered and 'customer ID' should be displayed in a table
    And the continue and Home link should be displayed


    @CustomerName @Regression
    Scenario Outline: Test the New Customer functionality of Guru99 Bank when the Manager clicks on the 'New Customer' option to create a New customer account.
      When the Manager clicks on 'New Customer' option from the menu
      And enters an invalid CustomerName that contains 'numbers' or 'special characters' or begins with a 'space' or leaves it 'empty' as <CustomerName>
      And Select Gender, enters valid Date of Birth as "<Date of Birth>", valid Address as "<Address>", valid City Name as "<City>"
      And valid State as "<State>", valid PIN as "<PIN>", valid Mobile Number as "<MobileNo>", valid Email as "<Email>" and valid Password as "<Password>"
      Then an error message <Error Message> that related to the Customer Name field should be displayed
      When click on the Submit button
      Then the new customer account should NOT be created and an alert message saying 'Please fill all fields' should appear
      Examples:
      |CustomerName|Date of Birth|Address       |City |State  |PIN   |MobileNo    |Email              |Password|Error Message|
      |"Mo77med"   |10-25-1999   |10 Aziz Street|Cairo|Single |123456|012232785412|mohamed77@gmail.com|Mohamed&77|"Numbers are not allowed"|
      |"Mo&hamed"  |03-13-1987   |123 Ora Street|Giza |Married|112233|012232785412|mohamed77@gmail.com|Mohamed&77|"Special characters are not allowed"|
      |" Mohamed"  |03-28-1988   |123 Ora Street|Giza |Married|112233|012232785412|mohamed77@gmail.com|Mohamed&77|"First character can not have space"|
      |     ""     |03-7-1985    |123 Ora Street|Giza |Single |112233|012232785412|mohamed77@gmail.com|Mohamed&77|"Customer name must not be blank"|


  @Gender @Regression
  Scenario: Test the New Customer functionality of Guru99 Bank when the Manager clicks on the 'New Customer' option to create a New Customer account.
    When the Manager clicks on 'New Customer' option from the menu
    And enters a valid CustomerName as "Asmaa", Select Gender as [female], valid Date of Birth as "11-23-1999", valid Address as "123 Ora Street", valid City Name as "Giza"
    And valid State as "Married", valid PIN as "183822", Valid Mobile Number as "01123123124", valid Email as "asmaa6060@gmail.com" and valid Password as "Asmaa&6060"
    And click on the Submit button
    Then the customer account should be created and the success message 'Customer Registered Successfully!!!' should appear
    And the customer account data that entered and 'customer ID' should be displayed in a table
    And the continue and Home link should be displayed

  @DateOfBrith @Regression
  Scenario Outline: Test the New Customer functionality of Guru99 Bank when the Manager clicks on the 'New Customer' option to create a New customer account.
    When the Manager clicks on 'New Customer' option from the menu
    And enters a valid CustomerName as "<CustomerName>", Select Gender
    And leaves the Date of Birth field 'empty' as <Date of Birth>, valid Address as "<Address>", valid City Name as "<City>"
    And valid State as "<State>", valid PIN as "<PIN>", valid Mobile Number as "<MobileNo>", valid Email as "<Email>" and valid Password as "<Password>"
    Then an error message <Error Message> that related to the Date of Birth should be displayed
    When click on the Submit button
    Then the new customer account should NOT be created and an alert message saying 'Please fill all fields' should appear
    Examples:
      |CustomerName|Date of Birth|Address       |City  |State  |PIN   |MobileNo    |Email            |Password|Error Message|
      |Mazen       |     ""      |123 Ora Street|Cairo |Single |112233|012232785412|mazen55@gmail.com|Mazen&55|"Date Field must not be blank"|


  @Address @Regression
  Scenario Outline: Test the New Customer functionality of Guru99 Bank when the Manager clicks on the 'New Customer' option to create a New customer account.
    When the Manager clicks on 'New Customer' option from the menu
    And enters a valid CustomerName as "<CustomerName>", Select Gender, valid Date of Birth as "<Date of Birth>"
    And enters an invalid Address that contains 'special characters' or begins with a 'space' or leaves it 'empty' as <Address>, valid City Name as "<City>"
    And valid State as "<State>", valid PIN as "<PIN>", valid Mobile Number as "<MobileNo>", valid Email as "<Email>" and valid Password as "<Password>"
    Then an error message <Error Message> that related to the Address field should be displayed
    When click on the Submit button
    Then the new customer account should NOT be created and an alert message saying 'Please fill all fields' should appear
    Examples:
      |CustomerName|Date of Birth|Address            |City|State   |PIN   |MobileNo    |Email             |Password |Error Message|
      |Kareem      |03-13-1987   |"123 Ora && Street"|Giza |Married|112233|012232785412|Kareem22@gmail.com|Kareem&22|"Special characters are not allowed"|
      |Kareem      |03-28-1988   |" 123 Ora Street"  |Cairo|Married|112233|012232785412|Kareem22@gmail.com|Kareem&22|"First character can not have space"|
      |Kareem      |03-7-1985    |       ""          |Giza |Single |112233|012232785412|Kareem22@gmail.com|Kareem&22|"Address Field must not be blank"|


  @City @Regression
  Scenario Outline: Test the New Customer functionality of Guru99 Bank when the Manager clicks on the 'New Customer' option to create a New customer account.
    When the Manager clicks on 'New Customer' option from the menu
    And enters a valid CustomerName as "<CustomerName>", Select Gender, enters valid Date of Birth as "<Date of Birth>", valid Address as "<Address>"
    And enters an invalid City Name that contains 'numbers' or 'special characters' or begins with a 'space' or leaves it 'empty' as <City>
    And valid State as "<State>", valid PIN as "<PIN>", valid Mobile Number as "<MobileNo>", valid Email as "<Email>" and valid Password as "<Password>"
    Then an error message <Error Message> that related to the City Name field should be displayed
    When click on the Submit button
    Then the new customer account should NOT be created and an alert message saying 'Please fill all fields' should appear
    Examples:
      |CustomerName|Date of Birth|Address       |City     |State  |PIN   |MobileNo    |Email          |Password|Error Message|
      |Ali         |10-25-1999   |10 Aziz Street|"Cairo12"|Single |123456|012232785412|ali33@gmail.com|Ali&33|"Numbers are not allowed"|
      |Ali         |03-13-1987   |123 Ora Street|"Cairo&C"|Married|112233|012232785412|ali33@gmail.com|Ali&33|"Special characters are not allowed"|
      |Ali         |03-28-1988   |123 Ora Street|" Giza"  |Married|112233|012232785412|ali33@gmail.com|Ali&33|"First character can not have space"|
      |Ali         |03-7-1985    |12 Aziz Street|   ""    |Single |112233|012232785412|ali33@gmail.com|Ali&33|"City Field must not be blank"|


  @State @Regression
  Scenario Outline: Test the New Customer functionality of Guru99 Bank when the Manager clicks on the 'New Customer' option to create a New customer account.
    When the Manager clicks on 'New Customer' option from the menu
    And enters a valid CustomerName as "<CustomerName>", Select Gender, valid Date of Birth as "<Date of Birth>", valid Address as "<Address>", valid City as "<City>"
    And enters an invalid State that contains 'numbers' or 'special characters' or begins with a 'space' or leaves it 'empty' as <State>
    And enters a valid PIN as "<PIN>", valid Mobile Number as "<MobileNo>", valid Email as "<Email>" and valid Password as "<Password>"
    Then an error message <Error Message> that related to the State field should be displayed
    When click on the Submit button
    Then the new customer account should NOT be created and an alert message saying 'Please fill all fields' should appear
    Examples:
      |CustomerName|Date of Birth|Address       |City |State     |PIN   |MobileNo    |Email          |Password|Error Message|
      |Ali         |10-25-1999   |10 Aziz Street|Cairo|"Married2"|123456|012232785412|ali33@gmail.com|Ali&33  |"Numbers are not allowed"|
      |Ali         |03-13-1987   |123 Ora Street|Giza |"Single&S"|112233|012232785412|ali33@gmail.com|Ali&33  |"Special characters are not allowed"|
      |Ali         |03-28-1988   |123 Ora Street|Giza |" Married"|112233|012232785412|ali33@gmail.com|Ali&33  |"First character can not have space"|
      |Ali         |03-7-1985    |12 Aziz Street|Cairo|    ""    |112233|012232785412|ali33@gmail.com|Ali&33  |"State must not be blank"|


  @PIN @Regression
  Scenario Outline: Test the New Customer functionality of Guru99 Bank when the Manager clicks on the 'New Customer' option to create a New customer account.
    When the Manager clicks on 'New Customer' option from the menu
    And enters a valid CustomerName as "<CustomerName>", Select Gender, enters valid Date of Birth as "<Date of Birth>", valid Address as "<Address>"
    And valid City as "<City>", valid State as "<State>"
    And enters an invalid PIN that contains 'characters' or 'special characters' or begins with a 'space' or less than '6 digits 'or leaves it 'empty' as <PIN>
    And enters a valid Mobile Number as "<MobileNo>", valid Email as "<Email>" and valid Password as "<Password>"
    Then an error message <Error Message> that related to the PIN Code field should be displayed
    When click on the Submit button
    Then the new customer account should NOT be created and an alert message saying 'Please fill all fields' should appear
    Examples:
      |CustomerName|Date of Birth|Address       |City |State  |PIN    |MobileNo    |Email          |Password|Error Message|
      |Ali         |10-25-1999   |10 Aziz Street|Cairo|Married|"al32" |012232785412|ali33@gmail.com|Ali&33  |"Characters are not allowed"|
      |Ali         |03-13-1987   |123 Ora Street|Giza |Single |"11&33"|012232785412|ali33@gmail.com|Ali&33  |"Special characters are not allowed"|
      |Ali         |03-28-1988   |123 Ora Street|Giza |Married|" 122" |012232785412|ali33@gmail.com|Ali&33  |"First character can not have space"|
      |Ali         |07-15-2000   |14 Ora Street |Alex |Single |"678"  |012232785412|ali33@gmail.com|Ali&33  |"PIN Code must have 6 Digits"       |
      |Ali         |03-7-1985    |12 Aziz Street|Cairo|Married|   ""  |012232785412|ali33@gmail.com|Ali&33  |"PIN Code must not be blank"|



  @MobileNumber @Regression
  Scenario Outline: Test the New Customer functionality of Guru99 Bank when the Manager clicks on the 'New Customer' option to create a New customer account.
    When the Manager clicks on 'New Customer' option from the menu
    And enters a valid CustomerName as "<CustomerName>", Select Gender, enters valid Date of Birth as "<Date of Birth>", valid Address as "<Address>"
    And valid City as "<City>", valid State as "<State>", valid PIN as "<PIN>"
    And enters an invalid Mobile Number that contains 'characters' or 'special characters' or begins with a 'space' or leaves it 'empty' as <MobileNo>
    And enters a valid Email as "<Email>" and valid Password as "<Password>"
    Then an error message <Error Message> that related to the Mobile Number field should be displayed
    When click on the Submit button
    Then the new customer account should NOT be created and an alert message saying 'Please fill all fields' should appear
    Examples:
      |CustomerName|Date of Birth|Address       |City |State  |PIN    |MobileNo      |Email          |Password|Error Message|
      |Ali         |10-25-1999   |10 Aziz Street|Cairo|Married|123456 |"0122abc85412"|ali33@gmail.com|Ali&33  |"Characters are not allowed"|
      |Ali         |03-13-1987   |123 Ora Street|Giza |Single |123456 |"0122&&85412" |ali33@gmail.com|Ali&33  |"Special characters are not allowed"|
      |Ali         |03-28-1988   |123 Ora Street|Giza |Married|123456 |" 01223278512"|ali33@gmail.com|Ali&33  |"First character can not have space"|
      |Ali         |03-7-1985    |12 Aziz Street|Cairo|Married|123456 |      ""      |ali33@gmail.com|Ali&33  |"Mobile no must not be blank"|



  @Email @Regression
  Scenario Outline: Test the New Customer functionality of Guru99 Bank when the Manager clicks on the 'New Customer' option to create a New customer account.
    When the Manager clicks on 'New Customer' option from the menu
    And enters a valid CustomerName as "<CustomerName>", Select Gender, enters valid Date of Birth as "<Date of Birth>", valid Address as "<Address>"
    And valid City as "<City>", valid State as "<State>", valid PIN as "<PIN>", valid Mobile Number as "<MobileNo>"
    And enters an invalid Email that begins with a 'space' or leaves it 'empty' or enter invalid 'format email' as <Email> and valid Password as "<Password>"
    Then an error message <Error Message> that related to the Email field should be displayed
    When click on the Submit button
    Then the new customer account should NOT be created and an alert message saying 'Please fill all fields' should appear
    Examples:
      |CustomerName|Date of Birth|Address       |City |State  |PIN    |MobileNo    |Email             |Password|Error Message|
      |Ali         |10-25-1999   |10 Aziz Street|Cairo|Married|123456 |012232785412|" ali33@gmail.com"|Ali&33  |"First character can not have space"|
      |Ali         |03-13-1987   |123 Ora Street|Giza |Single |123456 |012232785412|        ""        |Ali&33  |"Email-ID must not be blank"|
      |Ali         |03-28-1988   |123 Ora Street|Giza |Married|123456 |012232785412|"ahmed_gmail.com" |Ali&33  |"Email-ID is not valid"|


  @ExistingEmail
  Scenario: Test the New Customer functionality of Guru99 Bank when the Manager enters an already-used Email address to create a New Customer account.
    When the Manager clicks on 'New Customer' option from the menu
    And enters a valid CustomerName as "Ammar", Select Gender as [male], valid Date of Birth as "11-23-1995", valid Address as "123 Ora Street", valid City Name as "Giza"
    And valid State as "Married", valid PIN as "183822", Valid Mobile Number as "01123123124", valid Email as "ammar767@gmail.com" and valid Password as "Ammar&123"
    And click on the Submit button
    Then the customer account should NOT be created and an alert message saying 'Email Address Already Exist !!' should appear


  @Password @Regression
  Scenario Outline: Test the New Customer functionality of Guru99 Bank when the Manager clicks on the 'New Customer' option to create a New customer account.
    When the Manager clicks on 'New Customer' option from the menu
    And enters a valid CustomerName as "<CustomerName>", Select Gender, enters valid Date of Birth as "<Date of Birth>", valid Address as "<Address>"
    And valid City as "<City>", valid State as "<State>", valid PIN as "<PIN>", valid Mobile Number as "<MobileNo>"
    And valid Email-ID as "<Email>" and leaves the Password field 'empty' as <Password>
    Then an error message <Error Message> that related to the Password field should be displayed
    When click on the Submit button
    Then the new customer account should NOT be created and an alert message saying 'Please fill all fields' should appear
    Examples:
      |CustomerName|Date of Birth|Address       |City |State  |PIN    |MobileNo   |Email             |Password|Error Message|
      |Yassen      |03-13-1987   |123 Ora Street|Giza |Single |123456 |01123123124|yassen12@gmail.com|   ""   |"Password must not be blank"|


  @EmptyFields @Regression
  Scenario: Test the New Customer functionality of Guru99 Bank when the Manager leaves all required fields are empty to create a New Customer account.
    When the Manager clicks on 'New Customer' option from the menu
    And he leaves all required fields are empty and click the submit button
    Then the new customer account should NOT be created and an alert message saying 'Please fill all fields' should appear

  @ResetBtn
  Scenario: Test the New Customer functionality of Guru99 Bank when the Manager fills all required fields AND Clicks on the Reset button
    When the Manager clicks on 'New Customer' option from the menu
    And he fills all required fields
    And click on the Reset button
    Then the Data should be cleared from all fields
