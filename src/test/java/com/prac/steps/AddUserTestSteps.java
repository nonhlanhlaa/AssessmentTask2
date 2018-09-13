package com.prac.steps;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import com.prac.utilities.*;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddUserTestSteps {
    WebDriver driver;
    String userN;

    private static final String DRIVER_PATH = "chromedriver";

    @Given("^user is on way2automation landing page$")
    public void user_is_on_login_page() {
        ClassLoader classLoader = getClass().getClassLoader();
        String driverPath =  classLoader.getResource(DRIVER_PATH).getPath();
        driver = DriverFactory.open("chrome", driverPath);
        driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1400, 1000));
        driver.get("http://www.way2automation.com/angularjs-protractor/webtables");
    }

    @When("^user confirms that they are on the User List Table$")
    public void confirm_landing_page() {
        Assert.assertTrue("Validate 'Add User' button displayed!", driver.findElement(By.cssSelector(".btn-link.pull-right")).isDisplayed());
    }

    @And("^user enters firstname (.*) & lastname (.*) & username (.*) & password (.*) & customer (.*) & role (.*) & email (.*) & cellphone (.*)$")
    public void user_enters_details(String firstname, String lastname, String username, String password, String customer, String role, String email, String cellphone) {
        WebElement btnAddUser = driver.findElement(By.cssSelector(".btn-link.pull-right"));
        GenericMethods.waitForElementToBeClickable(driver, btnAddUser);
        btnAddUser.click();

        WebElement titileAddUser = driver.findElement(By.cssSelector("h3"));
        WebElement txtFirstName = driver.findElement(By.name("FirstName"));
        WebElement txtLastName = driver.findElement(By.name("LastName"));
        WebElement txtUserName = driver.findElement(By.name("UserName"));
        WebElement txtPassword = driver.findElement(By.name("Password"));
        WebElement txtEmail = driver.findElement(By.name("Email"));
        WebElement txtCellPhone = driver.findElement(By.name("Mobilephone"));
        WebElement selectRole = driver.findElement(By.name("RoleId"));

        GenericMethods.waitForElementToAppear(driver, titileAddUser);
        txtFirstName.sendKeys(firstname);
        txtLastName.sendKeys(lastname);
        userN = username + randomAlphaNumeric(5);
        txtUserName.sendKeys(userN);
        txtPassword.sendKeys(password);

        List<WebElement> radioButton = driver.findElements(By.name("optionsRadios"));
        if (customer.equalsIgnoreCase("AAA")) {
            radioButton.get(0).click();
        } else {
            radioButton.get(1).click();
        }

        GenericMethods.selectAnItemFromDropdown(selectRole, role);
        txtEmail.sendKeys(email);
        txtCellPhone.sendKeys(cellphone);
    }

    @And("^user clicks save button$")
    public void user_clicks_save() {
        WebElement btnSave = driver.findElement(By.cssSelector("[ng-click='save(user)']"));
        btnSave.click();
    }

    @Then("^user confirms that they have successfully added the user$")
    public void userConfirmsThatTheyHaveSuccessfullyAddedTheUser() {
        String userNameExpected = driver.findElement(By.xpath("//table[@class='smart-table table table-striped']/tbody/tr[1]/td[3]")).getText();
        Assert.assertEquals("Validate User is added to list!",userN, userNameExpected);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
}
