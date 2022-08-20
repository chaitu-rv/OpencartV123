package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"regression","master"})
	void test_account_registration() {
		
		logger.info("-----------Starting TC_001_AccountRegistrationtTest------------");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on Account");
		
		hp.clickRegister();
		logger.info("clicked on Register");

		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

		regpage.setFirstName(randomeString().toUpperCase());
		logger.info("Provided first name");

		regpage.setLastName(randomeString().toUpperCase());
		logger.info("Provided last name");


		regpage.setEmail(randomeString() + "@gmail.com");// randomly generated the email
		logger.info("Provided Email ");


		regpage.setTelephone(randomeNumber());
		logger.info("Provided Telephone ");

		regpage.setPassword("test@123");
		logger.info("Provided Password ");

		regpage.setConfirmPassword("test@123");
		//regpage.setConfirmPassword("test@1234");

		logger.info("Provided Confrmed Password ");

		regpage.setPrivacyPolicy();
		logger.info("Set Privacy Policy ");

		regpage.clickContinue();
		logger.info("Clicked on Continue ");
		
		String confmsg = regpage.getConfirmationMsg();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("Registration failed");
			Assert.fail();
		}
		logger.info("-----------Finished TC_001_AccountRegistrationtTest-------------");
	}
}