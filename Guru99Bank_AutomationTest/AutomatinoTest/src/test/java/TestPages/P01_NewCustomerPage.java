package TestPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import static TestSteps.Hooks.driver;


public class P01_NewCustomerPage {

    SoftAssert softAssert;
    Alert alert;

    // locators;
    By userIdLoc = By.name("uid");
    By passwordID = By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input");
    By loginBtnLoc = By.name("btnLogin");
    By NewCustomerBtnLoc = By.linkText("New Customer");
    By addNewCustomerSMSLoc = By.className("heading3");
    By customerNameNptLoc = By.name("name");
    By genderMaleLoc = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]");
    By genderFemaleLoc = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]");
    By dateLoc = By.id("dob");
    By addressNptLoc = By.name("addr");
    By cityNptLoc = By.name("city");
    By stateNptLoc = By.name("state");
    By PINLoc = By.name("pinno");
    By mobileNumberLoc = By.name("telephoneno");
    By emailNptLoc = By.name("emailid");
    By passwordNptLoc = By.name("password");
    By submitBtnLoc = By.name("sub");
    By resetBtnLoc = By.name("res");
    By homeLinkLoc = By.linkText("Home");
    By successSMSLoc = By.cssSelector(".heading3");
    By customerTableLoc = By.id("customer");
    By customerID = By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[1]");
    By continueLinkLoc = By.partialLinkText("Continue");
    // error messages;
    By CustomerNameErrorSMSLoc = By.id("message");
    By DateOfBirthErrorSMSLoc = By.id("message24");
    By AddressErrorSMSLoc = By.id("message3");
    By CityErrorSMSLoc = By.id("message4");
    By StateErrorSMSLoc = By.id("message5");
    By PINErrorSMSLoc = By.id("message6");
    By MobileNumberErrorSMSLoc = By.id("message7");
    By EmailErrorSMSLoc = By.id("message9");
    By PasswordErrorSMSLoc = By.id("message18");



    // hold Elements;
    public WebElement userId(){
        return driver.findElement(userIdLoc);
    }
    public WebElement passwordID(){
        return driver.findElement(passwordID);
    }
    public WebElement loginBtn(){
        return driver.findElement(loginBtnLoc);
    }
    public WebElement newCustomerBtn(){
        return driver.findElement(NewCustomerBtnLoc);
    }
    public WebElement addNewCustomerSMS(){
        return driver.findElement(addNewCustomerSMSLoc);
    }
    public WebElement customerNameNpt(){
        return driver.findElement(customerNameNptLoc);
    }
    public WebElement gender_male(){
        return driver.findElement(genderMaleLoc);
    }
    public WebElement gender_female(){
        return driver.findElement(genderFemaleLoc);
    }
    public WebElement date(){
        return driver.findElement(dateLoc);
    }
    public WebElement addressNpt(){
        return driver.findElement(addressNptLoc);
    }
    public WebElement cityNpt(){
        return driver.findElement(cityNptLoc);
    }
    public WebElement stateNpt(){
        return driver.findElement(stateNptLoc);
    }
    public WebElement PIN(){
        return driver.findElement(PINLoc);
    }
    public WebElement mobileNumber(){
        return driver.findElement(mobileNumberLoc);
    }
    public WebElement emailNpt(){
        return driver.findElement(emailNptLoc);
    }
    public WebElement passwordNpt(){
        return driver.findElement(passwordNptLoc);
    }
    public WebElement submitBtn(){
        return driver.findElement(submitBtnLoc);
    }
    public WebElement resetBtn(){
        return driver.findElement(resetBtnLoc);
    }
    public WebElement homeLink(){
        return driver.findElement(homeLinkLoc);
    }
    public WebElement successSMS(){
        return driver.findElement(successSMSLoc);
    }
    public WebElement customerTable(){
        return driver.findElement(customerTableLoc);
    }
    public WebElement customerID(){
        return driver.findElement(customerID);
    }
    public WebElement continueLink(){
        return driver.findElement(continueLinkLoc);
    }
    public Alert alertSMS(){
        return alert = driver.switchTo().alert();
    }


    // error message Methods;
    public WebElement CustomerNameErrorSMS(){
        return driver.findElement(CustomerNameErrorSMSLoc);
    }
    public WebElement DateOfBirthErrorSMS(){
        return driver.findElement(DateOfBirthErrorSMSLoc);
    }
    public WebElement AddressErrorSMS(){
        return driver.findElement(AddressErrorSMSLoc);
    }
    public WebElement CityErrorSMS(){
        return driver.findElement(CityErrorSMSLoc);
    }
    public WebElement StateErrorSMS(){
        return driver.findElement(StateErrorSMSLoc);
    }
    public WebElement PINErrorSMS(){
        return driver.findElement(PINErrorSMSLoc);
    }
    public WebElement MobileNoErrorSMS(){
        return driver.findElement(MobileNumberErrorSMSLoc);
    }
    public WebElement EmailErrorSMS(){
        return driver.findElement(EmailErrorSMSLoc);
    }
    public WebElement PasswordErrorSMS(){
        return driver.findElement(PasswordErrorSMSLoc);
    }


    // Assertions;
    public void newSoftAssert(){
        softAssert = new SoftAssert();
    }
    public void assertAddNewCustomerSMS(){
        String AR = addNewCustomerSMS().getText();
        String ER = "Add New Customer";
        softAssert.assertEquals(AR, ER, "Error: New Customer SMS");
    }
    public void assertCustomerNameNpt(){
        softAssert.assertTrue(customerNameNpt().isDisplayed(), "Error: Customer Name Field is NOT displayed");
    }
    public void assertGender_male(){
        softAssert.assertTrue(gender_male().isSelected(), "Error: Gender_male radio is NOT Selected");
    }
    public void assertGender_female(){
        softAssert.assertTrue(gender_male().isEnabled(), "Error: Gender_female radio is NOT Enabled");
    }
    public void assertDate(){
        softAssert.assertTrue(date().isDisplayed(), "Error: Date is NOT displayed");
    }
    public void assertAddressNpt(){
        softAssert.assertTrue(addressNpt().isDisplayed(), "Error: Address Field is NOT displayed");
    }
    public void assertCity(){
        softAssert.assertTrue(cityNpt().isDisplayed(), "Error: City Field is NOT displayed");
    }
    public void assertState(){
        softAssert.assertTrue(stateNpt().isDisplayed(), "Error: State Field is NOT displayed");
    }
    public void assertPIN(){
        softAssert.assertTrue(PIN().isDisplayed(), "Error: PIN Field is NOT displayed");
    }
    public void assertMobileNumber(){
        softAssert.assertTrue(mobileNumber().isDisplayed(), "Error: Mobile Number Field is NOT displayed");
    }
    public void assertEmailID(){
        softAssert.assertTrue(emailNpt().isDisplayed(), "Error: Email-ID Field is NOT displayed");
    }
    public void assertPasswordNpt(){
        softAssert.assertTrue(passwordNpt().isDisplayed(), "Error: password Field is NOT displayed");
    }
    public void assertSubmitBtn(){
        softAssert.assertTrue(submitBtn().isEnabled(), "Error: Submit button is NOT Enabled = Clickable");
    }
    public void assertResetBtn(){
        softAssert.assertTrue(resetBtn().isDisplayed(), "Error: Reset button is NOT displayed");
    }
    public void assertHomeLink(){
        softAssert.assertTrue(homeLink().isDisplayed(), "Error: Home Link is NOT displayed");
    }
    public void assertURL(String url1, String url2){
        softAssert.assertFalse(url1.equals(url2), "Error: User is NOT Redirected to the correct page");
    }
    public void assertSuccessSMS(){
        String AR = successSMS().getText();
        String ER = "Customer Registered Successfully!!!";
        softAssert.assertEquals(AR, ER, "Error: Success Message is not appear");
    }
    public void assertCustomerTable(){
        softAssert.assertTrue(customerTable().isDisplayed(), "Error: the Customer Table is not displayed");
    }
    public void assertCustomerID(){
        softAssert.assertTrue(customerID().isDisplayed(), "Error: Customer ID field is NOT displayed");
    }
    public void assertContinueLink(){
        softAssert.assertTrue(continueLink().isEnabled(), "Error: Continue Link is NOT Clickable");
    }
    // Fields Error SMS;

    // 1-Customer Name field
    public void assertCustomerNameErrorSMS(String ER_CustomerNameErrorSMS){
        String AR = CustomerNameErrorSMS().getText();
        softAssert.assertEquals(AR, ER_CustomerNameErrorSMS, "Error: in the CustomerName field");
    }
    // 2-Date of Birth field
    public void assertDateOfBirthErrorSMS(String ER_DateOfBirthErrorSMS){
        String AR = DateOfBirthErrorSMS().getText();
        softAssert.assertEquals(AR, ER_DateOfBirthErrorSMS, "Error: in the Date of Birth field");
    }
    // 3-Address field
    public void assertAddressErrorSMS(String ER_AddressErrorSMS){
        String AR = AddressErrorSMS().getText();
        softAssert.assertEquals(AR, ER_AddressErrorSMS, "Error: in the Address field");
    }
    // 4-City field
    public void assertCityErrorSMS(String ER_CityErrorSMS){
        String AR = CityErrorSMS().getText();
        softAssert.assertEquals(AR, ER_CityErrorSMS, "Error: in the City field");
    }
    // 4-State field
    public void assertStateErrorSMS(String ER_StateErrorSMS){
        String AR = StateErrorSMS().getText();
        softAssert.assertEquals(AR, ER_StateErrorSMS, "Error: in the State field");
    }
    // 5-PIN field
    public void assertPINErrorSMS(String ER_PINErrorSMS){
        String AR = PINErrorSMS().getText();
        softAssert.assertEquals(AR, ER_PINErrorSMS, "Error: in the PIN field");
    }
    // 6-Mobile Number field
    public void assertMobileNoErrorSMS(String ER_MobileNoErrorSMS){
        String AR = MobileNoErrorSMS().getText();
        softAssert.assertEquals(AR, ER_MobileNoErrorSMS, "Error: in the Mobile Number field");
    }
    // 7-Email
    public void assertEmailErrorSMS(String ER_EmailErrorSMS){
        String AR = EmailErrorSMS().getText();
        softAssert.assertEquals(AR, ER_EmailErrorSMS, "Error: in the Email field");
    }
    // 8-Password
    public void assertPasswordErrorSMS(String ER_PasswordErrorSMS){
        String AR = PasswordErrorSMS().getText();
        softAssert.assertEquals(AR, ER_PasswordErrorSMS, "Error: in the password field");
    }

    public void assertAlertSMS(){
       String AR = alertSMS().getText();
       String ER = "please fill all fields";
       softAssert.assertEquals(AR, ER, "Error: Alert Message have an error");
    }
    public void assertAlertEmailSMS(){
        String AR = alertSMS().getText();
        String ER = "Email Address Already Exist !!";
        softAssert.assertEquals(AR, ER, "Error: Email alert message have an error");
    }

    // Clear All Data
    public void assertClearAllData(){
        softAssert.assertTrue(customerNameNpt().getText().isEmpty());
        softAssert.assertTrue(date().getText().isEmpty());
        softAssert.assertTrue(addressNpt().getText().isEmpty());
        softAssert.assertTrue(cityNpt().getText().isEmpty());
        softAssert.assertTrue(stateNpt().getText().isEmpty());
        softAssert.assertTrue(PIN().getText().isEmpty());
        softAssert.assertTrue(mobileNumber().getText().isEmpty());
        softAssert.assertTrue(emailNpt().getText().isEmpty());
        softAssert.assertTrue(passwordNpt().getText().isEmpty());
    }
    public void assertAll(){
        softAssert.assertAll("Assertions have an error");
    }
}

