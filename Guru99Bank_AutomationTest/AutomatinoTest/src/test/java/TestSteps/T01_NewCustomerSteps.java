package TestSteps;

import TestPages.P01_NewCustomerPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;


import static TestSteps.Hooks.driver;


public class T01_NewCustomerSteps {

    P01_NewCustomerPage newCustomerPage = new P01_NewCustomerPage();

    String HomeUrl;
    String NewCustomerUrl;
    String ID;

    @Given("The Manager navigated to the login page of Guru99 Bank and logged in with his UserID as {string} and Password as {string}")
    public void user_navigate_to_the_login_page_and_logged_in(String userID, String password){
        // Initialization is now handled in setUp();
        newCustomerPage.userId().sendKeys(userID);
        newCustomerPage.passwordID().sendKeys(password);
        newCustomerPage.loginBtn().click();
    }

    // Content of Page;

    @When("the Manager clicks on 'New Customer' option from the menu")
    public void user_clicks_on_NewCustomer(){
        HomeUrl = driver.getCurrentUrl();
        newCustomerPage.newCustomerBtn().click();
    }

    @Then("the Manager should be redirected to the ‘Add New Customer’ page")
    public void the_Manager_should_be_redirected_to_the_Add_NewCustomer_page(){
        NewCustomerUrl = driver.getCurrentUrl();
        newCustomerPage.newSoftAssert();
        newCustomerPage.assertURL(HomeUrl, NewCustomerUrl);
        System.out.println("Home page URL => " + HomeUrl);
        System.out.println("New Customer URL => " + NewCustomerUrl);
    }
    @And("the Message “Add New Customer” should appear")
    public void the_Message_Add_NewCustomer_should_appear(){
        newCustomerPage.assertAddNewCustomerSMS();
    }
    @And ("the Customer Name field, Gender, Date of Birth, Address, City, State, PIN, Mobile Number, E-mail, and Password should be displayed")
    public void all_required_fields_should_be_displayed(){
        newCustomerPage.assertCustomerNameNpt();
        newCustomerPage.assertGender_male();
        newCustomerPage.assertGender_female();
        newCustomerPage.assertDate();
        newCustomerPage.assertAddressNpt();
        newCustomerPage.assertCity();
        newCustomerPage.assertState();
        newCustomerPage.assertPIN();
        newCustomerPage.assertMobileNumber();
        newCustomerPage.assertEmailID();
        newCustomerPage.assertPasswordNpt();
    }
    @And ("Submit button, Reset should be displayed")
    public void Submit_button_and_Reset_should_be_displayed(){
        newCustomerPage.assertSubmitBtn();
        newCustomerPage.assertResetBtn();
    }
    @And ("the Home page Link should be visible")
    public void the_Home_page_Link_should_be_visible(){
        newCustomerPage.assertHomeLink();
        newCustomerPage.assertAll();
    }


    // Happy Scenario / Valid Scenario;
    @And("enters a valid CustomerName as {string}, Select Gender as [male], valid Date of Birth as {string}, valid Address as {string}, valid City Name as {string}")
    public void manager_enters_some_of_required_data_with_gender_as_male(String name, String date, String address, String city){
        newCustomerPage.customerNameNpt().sendKeys(name);
        newCustomerPage.gender_male().click();
        newCustomerPage.date().sendKeys(date);
        newCustomerPage.addressNpt().sendKeys(address);
        newCustomerPage.cityNpt().sendKeys(city);
    }
    @And("valid State as {string}, valid PIN as {string}, Valid Mobile Number as {string}, valid Email as {string} and valid Password as {string}")
    public void manager_enters_another_required_data(String state, String PIN, String mobileNo, String emailID, String password){
        newCustomerPage.stateNpt().sendKeys(state);
        newCustomerPage.PIN().sendKeys(PIN);
        newCustomerPage.mobileNumber().sendKeys(mobileNo);
        newCustomerPage.emailNpt().sendKeys(emailID);
        newCustomerPage.passwordNpt().sendKeys(password);
    }
    @And("click on the Submit button")
    public void click_on_submit_button(){
        newCustomerPage.submitBtn().click();
    }
    @Then("the customer account should be created and the success message 'Customer Registered Successfully!!!' should appear")
    public void the_customer_account_should_be_created_and_the_success_message_should_appear(){
        newCustomerPage.newSoftAssert();
        newCustomerPage.assertSuccessSMS();
    }
    @And ("the customer account data that entered and 'customer ID' should be displayed in a table")
    public void the_customer_account_data_that_entered_should_be_displayed_in_a_table(){
        newCustomerPage.assertCustomerTable();
        newCustomerPage.assertCustomerID();
        ID = driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]")).getText();
        System.out.println("Customer ID is => " + ID);
    }
    @And("the continue and Home link should be displayed")
    public void the_continue_link_should_be_displayed(){
        newCustomerPage.assertContinueLink();
        newCustomerPage.assertHomeLink();
        newCustomerPage.assertAll();
    }
    @And("enters a valid CustomerName as {string}, Select Gender as [female], valid Date of Birth as {string}, valid Address as {string}, valid City Name as {string}")
    public void manager_enters_some_of_required_data_with_gender_as_female(String name, String date, String address, String city){
        newCustomerPage.customerNameNpt().sendKeys(name);
        newCustomerPage.gender_female().click();
        newCustomerPage.date().sendKeys(date);
        newCustomerPage.addressNpt().sendKeys(address);
        newCustomerPage.cityNpt().sendKeys(city);
    }


    // Bad Scenarios / Invalid Scenarios;


    // BDD => Customer Name;
    @And("enters an invalid CustomerName that contains 'numbers' or 'special characters' or begins with a 'space' or leaves it 'empty' as {string}")
    public void manager_enters_invalid_customerName(String name){
        newCustomerPage.customerNameNpt().sendKeys(name);
    }
    @And("Select Gender, enters valid Date of Birth as {string}, valid Address as {string}, valid City Name as {string}")
    public void _some_of_required_data(String date, String address, String city){
        newCustomerPage.gender_male().click();
        newCustomerPage.date().sendKeys(date);
        newCustomerPage.addressNpt().sendKeys(address);
        newCustomerPage.cityNpt().sendKeys(city);
    }
    @And("valid State as {string}, valid PIN as {string}, valid Mobile Number as {string}, valid Email as {string} and valid Password as {string}")
    public void another_valid_data(String state, String PIN, String mobileNo, String email, String password){
        newCustomerPage.stateNpt().sendKeys(state);
        newCustomerPage.PIN().sendKeys(PIN);
        newCustomerPage.mobileNumber().sendKeys(mobileNo);
        newCustomerPage.emailNpt().sendKeys(email);
        newCustomerPage.passwordNpt().sendKeys(password);
    }
    @Then("an error message {string} that related to the Customer Name field should be displayed")
    public void customerName_error_message_should_be_displayed(String customerNameErrorSMS){
        newCustomerPage.newSoftAssert();
        newCustomerPage.assertCustomerNameErrorSMS(customerNameErrorSMS);
    }
    @Then("the new customer account should NOT be created and an alert message saying 'Please fill all fields' should appear")
    public void account_should_NOT_be_created_and_an_alert_message_should_appear(){
        newCustomerPage.newSoftAssert();
        newCustomerPage.assertAlertSMS();
        newCustomerPage.alertSMS().accept();
        newCustomerPage.assertAll();
    }

    // BDD => Date of Brith;
    @And("enters a valid CustomerName as {string}, Select Gender")
    public void valid_name_and_gender(String name){
        newCustomerPage.customerNameNpt().sendKeys(name);
    }
    @And("leaves the Date of Birth field 'empty' as {string}, valid Address as {string}, valid City Name as {string}")
    public void invalid_dateOfBrith(String date, String address, String city){
        newCustomerPage.date().sendKeys(date);
        newCustomerPage.addressNpt().sendKeys(address);
        newCustomerPage.cityNpt().sendKeys(city);
    }
    @Then("an error message {string} that related to the Date of Birth should be displayed")
    public void dateOfBrith_error_message_should_be_displayed(String dateOfBirthErrorSMS){
        newCustomerPage.newSoftAssert();
        newCustomerPage.assertDateOfBirthErrorSMS(dateOfBirthErrorSMS);
        newCustomerPage.assertAll();
    }

    // BDD => Address
    @And("enters a valid CustomerName as {string}, Select Gender, valid Date of Birth as {string}")
    public void enters_customer_name_and_gender_and_dateOfBirth(String name, String date){
        newCustomerPage.customerNameNpt().sendKeys(name);
        newCustomerPage.date().sendKeys(date);
    }
    @And("enters an invalid Address that contains 'special characters' or begins with a 'space' or leaves it 'empty' as {string}, valid City Name as {string}")
    public void invalid_address(String address, String city){
        newCustomerPage.addressNpt().sendKeys(address);
        newCustomerPage.cityNpt().sendKeys(city);
    }

    @Then("an error message {string} that related to the Address field should be displayed")
    public void address_ErrorSMS(String addressErrorSMS){
        newCustomerPage.newSoftAssert();
        newCustomerPage.assertAddressErrorSMS(addressErrorSMS);
        newCustomerPage.assertAll();
    }

    // BDD => City
    @And("enters a valid CustomerName as {string}, Select Gender, enters valid Date of Birth as {string}, valid Address as {string}")
    public void enters_valid_name_and_gender_and_date_and_address(String name, String date, String address){
        newCustomerPage.customerNameNpt().sendKeys(name);
        newCustomerPage.date().sendKeys(date);
        newCustomerPage.addressNpt().sendKeys(address);
    }
    @And("enters an invalid City Name that contains 'numbers' or 'special characters' or begins with a 'space' or leaves it 'empty' as {string}")
    public void invalid_cityName(String city){
        newCustomerPage.cityNpt().sendKeys(city);
    }
    @Then("an error message {string} that related to the City Name field should be displayed")
    public void city_ErrorSMS(String cityErrorSMS){
        newCustomerPage.newSoftAssert();
        newCustomerPage.assertCityErrorSMS(cityErrorSMS);
        newCustomerPage.assertAll();
    }

    // BDD => State
    @And("enters a valid CustomerName as {string}, Select Gender, valid Date of Birth as {string}, valid Address as {string}, valid City as {string}")
    public void enters_name_and_gender_and_date_address_and_city(String name, String date, String address, String city){
        newCustomerPage.customerNameNpt().sendKeys(name);
        newCustomerPage.date().sendKeys(date);
        newCustomerPage.addressNpt().sendKeys(address);
        newCustomerPage.cityNpt().sendKeys(city);
    }
    @And("enters an invalid State that contains 'numbers' or 'special characters' or begins with a 'space' or leaves it 'empty' as {string}")
    public void invalid_State(String state){
        newCustomerPage.stateNpt().sendKeys(state);
    }
    @And("enters a valid PIN as {string}, valid Mobile Number as {string}, valid Email as {string} and valid Password as {string}")
    public void enters_PIN_and_mobileNo_and_and_email_and_password(String PIN, String mobileNo, String email, String password){
        newCustomerPage.PIN().sendKeys(PIN);
        newCustomerPage.mobileNumber().sendKeys(mobileNo);
        newCustomerPage.emailNpt().sendKeys(email);
        newCustomerPage.passwordNpt().sendKeys(password);
    }
    @Then("an error message {string} that related to the State field should be displayed")
    public void state_ErrorSMS(String stateErrorSMS){
        newCustomerPage.newSoftAssert();
        newCustomerPage.assertStateErrorSMS(stateErrorSMS);
        newCustomerPage.assertAll();
    }

    // BDD => PIN
    @And("valid City as {string}, valid State as {string}")
    public void enter_city_and_state(String city, String state){
        newCustomerPage.cityNpt().sendKeys(city);
        newCustomerPage.stateNpt().sendKeys(state);
    }
    @And("enters an invalid PIN that contains 'characters' or 'special characters' or begins with a 'space' or less than '6 digits 'or leaves it 'empty' as {string}")
    public void invalid_PINCode(String PIN){
        newCustomerPage.PIN().sendKeys(PIN);
    }

    @And("enters a valid Mobile Number as {string}, valid Email as {string} and valid Password as {string}")
    public void enter_mobileNo_and_email_and_password(String mobileNo, String email, String password){
        newCustomerPage.mobileNumber().sendKeys(mobileNo);
        newCustomerPage.emailNpt().sendKeys(email);
        newCustomerPage.passwordNpt().sendKeys(password);
    }
    @Then("an error message {string} that related to the PIN Code field should be displayed")
    public void PIN_ErrorSMS(String PINErrorSMS){
        newCustomerPage.newSoftAssert();
        newCustomerPage.assertPINErrorSMS(PINErrorSMS);
        newCustomerPage.assertAll();
    }

    // BDD => MobileNumber
    @And("valid City as {string}, valid State as {string}, valid PIN as {string}")
    public void enters_city_and_state_and_PIN(String city, String state, String PIN){
        newCustomerPage.cityNpt().sendKeys(city);
        newCustomerPage.stateNpt().sendKeys(state);
        newCustomerPage.PIN().sendKeys(PIN);
    }
    @And("enters an invalid Mobile Number that contains 'characters' or 'special characters' or begins with a 'space' or leaves it 'empty' as {string}")
    public void invalid_MobileNo(String mobileNo){
        newCustomerPage.mobileNumber().sendKeys(mobileNo);
    }
    @And("enters a valid Email as {string} and valid Password as {string}")
    public void enters_email_and_password(String email, String password){
        newCustomerPage.emailNpt().sendKeys(email);
        newCustomerPage.passwordNpt().sendKeys(password);
    }
    @Then("an error message {string} that related to the Mobile Number field should be displayed")
    public void mobileNo_ErrorSMS(String mobileNoErrorSMS){
        newCustomerPage.newSoftAssert();
        newCustomerPage.assertMobileNoErrorSMS(mobileNoErrorSMS);
        newCustomerPage.assertAll();
    }

    // BDD => Email
    @And("valid City as {string}, valid State as {string}, valid PIN as {string}, valid Mobile Number as {string}")
    public void enters_city_and_state_and_PIN_and_mobileNo(String city, String state, String PIN, String mobileNo){
        newCustomerPage.cityNpt().sendKeys(city);
        newCustomerPage.stateNpt().sendKeys(state);
        newCustomerPage.PIN().sendKeys(PIN);
        newCustomerPage.mobileNumber().sendKeys(mobileNo);
    }
    @And("enters an invalid Email that begins with a 'space' or leaves it 'empty' or enter invalid 'format email' as {string} and valid Password as {string}")
    public void invalid_Email(String email, String password){
        newCustomerPage.emailNpt().sendKeys(email);
        newCustomerPage.passwordNpt().sendKeys(password);
    }
    @Then("an error message {string} that related to the Email field should be displayed")
    public void email_ErrorSMS(String emailErrorSMS){
        newCustomerPage.newSoftAssert();
        newCustomerPage.assertEmailErrorSMS(emailErrorSMS);
        newCustomerPage.assertAll();
    }

    // BDD => Existing Email
    @Then("the customer account should NOT be created and an alert message saying 'Email Address Already Exist !!' should appear")
    public void alert_SMS_should_appear(){
        newCustomerPage.newSoftAssert();
        newCustomerPage.assertAlertEmailSMS();
        newCustomerPage.alertSMS().accept();
        newCustomerPage.assertAll();
    }

    // BDD => Password
    @And("valid Email-ID as {string} and leaves the Password field 'empty' as {string}")
    public void enters_email_and_leaves_password_empty(String email, String password){
        newCustomerPage.emailNpt().sendKeys(email);
        newCustomerPage.passwordNpt().sendKeys(password);
        newCustomerPage.emailNpt().click();
    }
    @Then("an error message {string} that related to the Password field should be displayed")
    public void password_ErrorSMS(String passwordErrorSMS){
        newCustomerPage.newSoftAssert();
        newCustomerPage.assertPasswordErrorSMS(passwordErrorSMS);
        newCustomerPage.assertAll();
    }

    // BDD => Empty fields
    @And("he leaves all required fields are empty and click the submit button")
    public void empty_fields(){
        newCustomerPage.submitBtn().click();
    }

    // BDD => ResetBtn
    @And("he fills all required fields")
    public void he_fills_all_required_fields(){
        newCustomerPage.customerNameNpt().sendKeys("Ahmed Ali");
        newCustomerPage.date().sendKeys("01/01/1990");
        newCustomerPage.addressNpt().sendKeys("123 Main St");
        newCustomerPage.cityNpt().sendKeys("New York");
        newCustomerPage.stateNpt().sendKeys("NY");
        newCustomerPage.PIN().sendKeys("123456");
        newCustomerPage.mobileNumber().sendKeys("1234567890");
        newCustomerPage.emailNpt().sendKeys("ahmed.ali@gmail.com");
        newCustomerPage.passwordNpt().sendKeys("ahmed&123");
    }

    @And("click on the Reset button")
    public void click_on_reset_button(){
        newCustomerPage.resetBtn().click();
    }

    @Then("the Data should be cleared from all fields")
    public void clear_all_data(){
        newCustomerPage.newSoftAssert();
        newCustomerPage.assertClearAllData();
        newCustomerPage.assertAll();
    }

}
