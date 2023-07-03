package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.AddAssessment;
import pageObjects.AddTrainingDetails;
import pageObjects.LoginDetails;

@SuppressWarnings("deprecation")
public class Steps extends BaseClass{

	@Before
	public void setup() throws IOException {

		logger=Logger.getLogger("MapLogikCucumber");
		PropertyConfigurator.configure("log4j.properties");

		/*configProp = new Properties();
		FileInputStream configPropFile = new FileInputStream("C:\\Users\\rajag\\Eclipse work\\chromedriver_win32\\chromedriver.exe");
		configProp.load(configPropFile);

		String br = configProp.getProperty("browser");*/

		//if(br.equals("chrome")) 
		//{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\rajag\\Eclipse work\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		//}
		logger.info("***** Launching Browers *****");
	}

	@Given("User launch Chrome browser")
	public void user_launch_chrome_browser() {
		ld = new LoginDetails(driver);
	}

	@When("User open URL {string}")
	public void user_open_url(String url) {
		logger.info("***** Opening URL *****");
		driver.get(url);

	}

	@Then("User enter Email as {string} and Password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) {
		logger.info("***** Enter Admin Details *****");
		ld.adminLogin(email, password);

	}

	@Then("Click on Login")
	public void click_on_login() {
		logger.info("***** Login into the page *****");
		ld.clickLogin();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
		logger.info("***** Check the title *****");

		if(driver.getPageSource().contains("On Progresss..")) {
			driver.close();
			Assert.assertTrue(false);
		}else {
			Assert.assertEquals(title, driver.getTitle());
		}

	}

	@When("User click Logout")
	public void user_click_logout() throws InterruptedException {
		logger.info("***** Logout From Admin page *****");
		ld.clickLogout();
		Thread.sleep(1000);
	}


	//Add New Training------------------------------------------

	@When("User click Skill Enhancment")
	public void user_click_skill_enhancment() throws InterruptedException {
		logger.info("***** Clicking Skill Enhancement *****");
		//wait.wait(1000);
		addTrain = new AddTrainingDetails(driver);
		addTrain.clickSkillEnhancement();
	}

	@When("Click All Trainings")
	public void click_all_trainings() throws InterruptedException {
		logger.info("***** Clicking All Trainings *****");
		//wait.wait(1000);
		Thread.sleep(1000);
		addTrain.clickAllTrainings();
	}

	@When("Click Add New")
	public void click_add_new() throws InterruptedException {
		logger.info("***** Clicking Add New Training *****");
		//wait.wait(1000);
		Thread.sleep(1000);
		addTrain.clickAddNew();
	}
	@When("User enter Training Details")
	public void user_enter_training_details() throws InterruptedException, IOException {
		logger.info("***** Entering Training Details *****");
		//wait.wait(1000);
		Thread.sleep(1000);
		addTrain.trainingDetails();

	}
	@When("Click Save button")
	public void click_save_button() throws InterruptedException {
		logger.info("***** Save the Details *****");
		Thread.sleep(1000);
		addTrain.clickSubmit();

	}

	@When("User enter Training Video Details")
	public void user_enter_training_video_details() throws InterruptedException, IOException {
		logger.info("***** Enter Training Video Details *****");
		Thread.sleep(1000);
		addTrain.trainingVideo();
	}

	@When("Click Save and Continue button")
	public void click_save_and_continue_button() throws InterruptedException {
		logger.info("***** Save the Details *****");
		Thread.sleep(1000);
		addTrain.clickSave();
	}

	@When("Close browser")
	public void close_browser() {
		logger.info("***** Closing Browers *****");
		driver.quit();
	}

	//Add Assessment Details

	@When("User click the Add Assessment")
	public void user_click_the_add_assessment() throws InterruptedException {

		addAss = new AddAssessment(driver);
		logger.info("***** Clicking Add Assessment *****");

		addAss.clickAddAss();

	}

	@When("Click Add New and User enter Question, Answers and Save")
	public void click_add_new_and_user_enter_question_answers_and_save() throws InterruptedException, IOException {
		logger.info("***** Add The Assessment Details *****");
		addAss.addAssessment();
	}

	@When("Click Add Assessment")
	public void click_add_assessment() throws InterruptedException {
		logger.info("***** Again Clicking Add Assessment *****");
		addAss.clickAddAss();
	}

	@When("Check the Total Number of Assessment")
	public void check_the_total_number_0f_assessment() throws InterruptedException {
		logger.info("***** Check the Number of Question *****");
		addAss.checkTotalAssessment();
	}

	@When("Close The browser")
	public void close_Browser() {
		logger.info("***** Closing Browers *****");
		driver.quit();

	}


}
