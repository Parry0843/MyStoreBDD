package myStore.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Harshala on 01/02/2018.
 */

public class StepDefinations {

    public static WebDriver driver;
    public  static String url = "http://automationpractice.com/index.php";


    @Before
    public void startBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @After
    public void stopBrowser(){
        driver.close();
    }


    @Given("^User on MyStore Home Page$")
    public void user_on_MyStore_Home_Page() throws Throwable {
        Assert.assertTrue(driver.getTitle().contains("My Store"));
        System.out.println("Home page is displayed.");

    }

    @Then("^User should see 'your logo' image$")
    public void user_should_see_your_logo_image() throws Throwable {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='header_logo']/a/img")).isDisplayed());
        System.out.println("Logo is displayed");
    }


    @Given("^User on authentication Page$")
    public void user_on_authentication_Page() throws Throwable {
        driver.findElement(By.className("login")).click();
        Assert.assertTrue(driver.getTitle().contains("Login"));
        System.out.println("User is now on Authentication Page.");
    }

    @When("^User enter email as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void user_enter_email_as_and_password_as(String email, String password) throws Throwable {
        // Scroll page if needed.
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("passwd")).sendKeys(password);
        System.out.println("User enters email and password.");
    }

    @When("^User click on SignIn button$")
    public void user_click_on_SignIn_button() throws Throwable {
        driver.findElement(By.id("SubmitLogin")).click();
        System.out.println("User selects SignIn button.");
    }

    @Then("^User should be logged in successfully$")
    public void user_should_be_logged_in_successfully() throws Throwable {
        String username = driver.findElement(By.xpath("//*[@class='header_user_info']/a[@class='account']/*")).getText();
        Assert.assertTrue(username.contains("Harsh"));
        System.out.println("User logged in with username: "+username);
    }

    @Then("^User Account Page is displayed\\.$")
    public void user_Account_Page_is_displayed() throws Throwable {
        String pageTab = driver.findElement(By.xpath("//*[@class='navigation_page'][contains(text(),'My account')]")).getText();
        Assert.assertEquals("My account",pageTab);
        System.out.println("My account page is displayed.");
    }

    @Then("^User should not login successfully$")
    public void user_should_not_login_successfully() throws Throwable {
        String signIn = driver.findElement(By.className("login")).getText();
        Assert.assertTrue(signIn.contains("Sign in"));
        System.out.println("User could not logged in....");
    }

    @Then("^User should see msg as \"([^\"]*)\"$")
    public void user_should_see_msg_as(String erroroMsg) throws Throwable {
        String msg = driver.findElement(By.xpath("//*[@id='center_column']/div[1]/ol/li")).getText();
        Assert.assertTrue(msg.contains(erroroMsg));
        System.out.println("Message: "+msg);
    }
}
