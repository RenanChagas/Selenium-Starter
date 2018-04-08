package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {

    @Given("the user is on the login page")
    public void loginPage() {
        System.out.println("loginPage");
    }

    @When("the user enters valid credentials")
    public void entersValidCredentials() {
        System.out.println("validCredentials");
    }

    @And("the user should be able to view account balance")
    public void viewAccountBalance() {
        System.out.println("accountBalance");
    }

    @When("the user enters invalid credentials")
    public void entersInvalidCredentials() {

    }

    @Then("the user should not be able to view account balance")
    public void notBeAbleToViewAccountBalance() {

    }

    @And("the user should get an invalid login message")
    public void invalidLoginMessage() {

    }

    @When("^the user enters a valid username \"([^\"]*)\"$")
    public void entersAValidUsername(String username) {

    }

    @When("^the user enters a valid password \"([^\"]*)\"$")
    public void entersAValidPassword(String password) throws Throwable {

    }

    @Then("^user click login button$")
    public void userClickLoginButton() {

    }
}

