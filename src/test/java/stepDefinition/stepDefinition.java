package stepDefinition;

import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;


@RunWith(Cucumber.class)



public class stepDefinition  {
    public static WebDriver driver;

    @Given("^I am on SauceLabs login page$")
    public void i_am_on_saucelabs_login_page() throws Throwable {
            System.out.println("I am ON LOGIN PAGE");
            driver = Base.getDriver();
            driver.get("https://www.saucedemo.com/");
            driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]")).getText();

    }

    @Given("^I am on SauceLabs HomePage$")
    public void i_am_on_saucelabs_homepage() throws Throwable {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
        System.out.println("I am at Home page");
    }

    @When("^I enter username \"([^\"]*)\"$")
    public void i_enter_username_something(String username) throws Throwable {
        System.out.println("This is where i will enter my username");
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]")).sendKeys(username);
    }

    @When("^I click on login button$")
    public void i_click_on_login_button() throws Throwable {

        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/input[1]")).click();
    }

    @When("^I click on SauceLabs BackPack$")
    public void i_click_on_saucelabs_backpack() throws Throwable {
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]/div[1]")).click();
        System.out.println("This is when i am at home page after login and i am selecting backpack from home page");
    }

    @Then("^I am taken to SauceLabs Home Page$")
    public void i_am_taken_to_saucelabs_home_page() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
        System.out.println("I am now on Home Page");
    }

    @Then("^I am taken to Sauce Labs Backpack page$")
    public void i_am_taken_to_sauce_labs_backpack_page() throws Throwable {
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]")).getText();
        System.out.println("I am now at backpage page");
    }

    @And("^I enter password \"([^\"]*)\"$")
    public void i_enter_password_something(String password) throws Throwable {
        System.out.println("This is where i will enter my password");
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/input[1]")).sendKeys(password);
    }

    @And("^BackPage is available on HomePage$")
    public void backpage_is_available_on_homepage() throws Throwable {
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]/div[1]")).getText();
        System.out.println("back pack is available for selection on homepage");
    }



    @Given("Jacket is available on HomePage")
    public void jacket_is_available_on_home_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/a[1]/div[1]")).getText();
    }
    @When("I click on SauceLabs Jacket")
    public void i_click_on_sauce_labs_jacket() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/a[1]/div[1]")).click();

    }
    @Then("I am taken to Sauce Labs Jacket page")
    public void i_am_taken_to_sauce_labs_jacket_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]")).getText();

    }
    @And("I close the browser")
    public void i_close_the_browser() throws IOException, InterruptedException {

        boolean flag = false;

        Runtime runtime = Runtime.getRuntime();
        runtime.exec("cmd /c start dockerdown.bat");
        Thread.sleep(5000);


        String file = "output.txt";
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, 5);
        long stopnow = cal.getTimeInMillis();

        while (System.currentTimeMillis() < stopnow) {
            if (flag) {
                break;
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String currenLine = reader.readLine();

            while (currenLine != null && !flag) {
                if (currenLine.contains("exited with code 143")) {
                    System.out.println("Docker shutdown Complete");
                    Thread.sleep(5000);
                    flag = true;
                    break;
                }
                currenLine = reader.readLine();
            }
            reader.close();
        }
        Assert.assertTrue(flag);
        Thread.sleep(2000);
        File delfile = new File("output.txt");
        if (delfile.delete()){
            System.out.println("Output File Deleted Successfully");
        }


        //driver.quit(); //close driver
    }
}
