package Annotation;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class annotation {
    WebDriver driver = new ChromeDriver();
//    WebDriver driver = new FirefoxDriver();;
    @Given("^I am on Facebook login page$")
    public void goToFacebook() {
        if (driver == null) {
//            driver = new FirefoxDriver();
            driver = new ChromeDriver();
            }
        driver.navigate().to("https://www.facebook.com/");
    }

    @When("^I enter username as \"(.*)\"$")
    public void i_enter_username_as(String arg1) {
        driver.findElement(By.id("email")).sendKeys(arg1);
    }

    @When ("^I enter password as \"(.*)\"$")
    public void i_enter_password_as(String arg1) {
        driver.findElement(By.id("pass")).sendKeys(arg1);
        driver.findElement(By.id("u_0_v")).click();
    }

    @Then("^Login should fail$")
    public void login_should_fail() {
        if(driver.getCurrentUrl().equalsIgnoreCase(
                "https://www.facebook.com/login.php?login_attempt=1&lwv=110")){
            System.out.println("Test1 Pass");
        } else {
            System.out.println("Test1 Failed");
        }
        driver.close();
    }

    @Then("^Relogin option should be available$")
    public void relogin_option_should_be_available() {
        if(driver.getCurrentUrl().equalsIgnoreCase(
                "https://www.facebook.com/login.php?login_attempt=1&lwv=110")){
            System.out.println("Test2 Pass");
        } else {
            System.out.println("Test2 Failed");
        }
        driver.close();
    }
}
