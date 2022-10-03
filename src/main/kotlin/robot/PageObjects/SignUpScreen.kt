package robot.PageObjects
import io.appium.java_client.MobileElement
import io.qameta.allure.Step
import org.testng.Assert
import robot.BaseRobot
import robot.PageObjectsRobots.signUpScreen

class SignUpScreen: BaseRobot() {
    //Library screen
    private val btn_profile: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/home_menu_profile")

    //Profile Screen
    private val btn_SignUpSignIn: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/txtLoginSignUp")

    //Sign In Screen
    private val lbl_SignIn: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/signInHeading")
    private val btn_createAccount: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/signUpButton")

    //Sign Up Screen
    private val lbl_createAccount: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/signInHeading")
    private val btn_ContinueWithGoogle: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/signInWithGoogle")
    private val lbl_signUpWithEmail: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/useEmail")
    private val txtField_Email: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/emailEditText")
    private val txtField_Password: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/passwordEditText")
    private val chkBox_sendUpdates: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/promotionsEnabledCheckbox")
    private val lbl_sendUpdates: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/promotionsTextView")
    private val btn_SignUpContinue: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/signInWithEmail")
    private val lbl_TermsConditions: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/disclaimerTextView")

    //Profile Screen
    private val txt_loggedInUsername: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/txtUserEmail")
    private val btn_logOut: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/btnLogout")


    @Step("Navigate to Sign Up page from Library")
    fun verify_navigateToSignUpFromLibrary(): SignUpScreen {

        driver.implicitWait(5)

        //Click on Profile icon from Library screen
        driver.clickElement(btn_profile)

        //Click on SignUp and Sign In button from Profile screen
        driver.clickElement(btn_SignUpSignIn)

        //Click on Sign In button
        driver.clickElement(lbl_SignIn)

        //Click on Create Account button
        driver.clickElement(btn_createAccount)

        //Verify Sign Up screen is displayed
        driver.isEleVisible(lbl_createAccount)

        return signUpScreen
    }

    @Step("Verify all the elements on Sign Up Screen")
    fun verify_SignUpScreen(): SignUpScreen{

        driver.isEleVisible(lbl_createAccount)
        driver.isEleVisible(btn_ContinueWithGoogle)
        driver.isEleVisible(lbl_signUpWithEmail)
        driver.isEleVisible(txtField_Email)
        driver.isEleVisible(txtField_Password)
        driver.isEleVisible(chkBox_sendUpdates)
        driver.isEleVisible(lbl_sendUpdates)
        driver.isEleVisible(btn_SignUpContinue)
        driver.isEleVisible(lbl_TermsConditions)

        //Verify the label is as expected
        Assert.assertEquals(
            lbl_createAccount.text,"Create an account")
        Assert.assertEquals(
            btn_ContinueWithGoogle.text,"Continue with Google")
        Assert.assertEquals(
            lbl_signUpWithEmail.text,"Or sign up with email")
        Assert.assertEquals(
            lbl_sendUpdates.text,"Send me Speechify updates and offers")
        return signUpScreen
    }

    @Step("As a user I cannot sign up with already registered email and password")
    fun verify_signUpWithExistingUser(): SignUpScreen{

        //Get the text fron JSON file
        val existingUsername = driver.extractDataFromJsonFile("existingUser1")

        //Get the text fron JSON file
        val validPassword = driver.extractDataFromJsonFile("defaultPassword")

        //Enter Existing Username
        driver.typeText(txtField_Email, existingUsername.replace("\"", ""))

        //Enter valid Password
        driver.typeText(txtField_Password, validPassword.replace("\"", ""))

        driver.navigateBack()

        //Click on Continue button
        driver.clickElement(btn_SignUpContinue)

        driver.implicitWait(3)

        driver.isEleVisible(lbl_createAccount)

        return signUpScreen
    }

    @Step("As a user I cannot sign up by entering any invalid email and password")
    fun verify_signUpWithInvalidCred(): SignUpScreen{

        //Get the text fron JSON file
        val invalidUsername = driver.extractDataFromJsonFile("invalidUser1")

        //Get the text fron JSON file
        val invalidPassword = driver.extractDataFromJsonFile("invalidPassword")

        //Click on Continue button
        driver.clickElement(btn_SignUpContinue)

        driver.implicitWait(3)

        driver.isEleVisible(lbl_createAccount)

        //Enter Invalid Username
        driver.typeText(txtField_Email, invalidUsername.replace("\"", ""))

        //Enter valid Password
        driver.typeText(txtField_Password, invalidPassword.replace("\"", ""))

        driver.navigateBack()

        //Click on Continue button
        driver.clickElement(btn_SignUpContinue)

        driver.implicitWait(3)

        driver.isEleVisible(lbl_createAccount)

        return signUpScreen
    }

    @Step("As a user I can sign up with a new email address and password")
    fun verify_signUpWithNewCred(): SignUpScreen{

        //Get the text fron JSON file
        val newUsername = ((driver.extractDataFromJsonFile("newUser1")).replace("\"", "") + ((0..10000).random()) + "@test.com")

        //Get the text fron JSON file
        val invalidPassword = driver.extractDataFromJsonFile("defaultPassword")

        //Enter Invalid Username
        driver.typeText(txtField_Email, newUsername)

        //Enter valid Password
        driver.typeText(txtField_Password, invalidPassword.replace("\"", ""))

        driver.navigateBack()

        //Click on Continue button
        driver.clickElement(btn_SignUpContinue)

        driver.implicitWait(6)

        Assert.assertEquals(
            txt_loggedInUsername.text,newUsername)

        return signUpScreen
    }

    @Step("Log out from account")
    fun logOut(): SignUpScreen{

        driver.clickElement(btn_logOut)

        return signUpScreen
    }
}