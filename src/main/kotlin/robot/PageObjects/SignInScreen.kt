package robot.PageObjects
import io.appium.java_client.MobileElement
import io.qameta.allure.Step
import org.testng.Assert
import robot.BaseRobot
import robot.PageObjectsRobots
import robot.PageObjectsRobots.signInScreen

class SignInScreen: BaseRobot() {

    //Sign In Screen
    private val lbl_SignIn: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/signInHeading")
    private val btn_continueWithGoogle: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/signInWithGoogle")
    private val btn_continueWithFacebook: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/signInWithFacebook")
    private val btn_continueWithApple: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/signInWithApple")
    private val lbl_OrIgnInWithEmail: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/useEmail")
    private val txtField_Email: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/emailEditText")
    private val txtField_Password: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/passwordEditText")
    private val link_forgotPassword: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/forgotPasswordButton")
    private val btn_SignInContinue: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/signInWithEmail")
    private val btn_createAccount: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/signUpButton")

    //Profile Screen
    private val txt_loggedInUsername: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/txtUserEmail")
    private val btn_logOut: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/btnLogout")
    private val btn_SignUpSignIn: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/txtLoginSignUp")

    @Step("Verify all the elements on Sign In Screen")
    fun verify_SignInScreen(): SignInScreen{

        //Click on Sign In button
        driver.clickElement(btn_SignUpSignIn)

        driver.implicitWait(2)

        driver.isEleVisible(lbl_SignIn)
        driver.isEleVisible(btn_continueWithGoogle)
        driver.isEleVisible(btn_continueWithFacebook)
        driver.isEleVisible(btn_continueWithApple)
        driver.isEleVisible(lbl_OrIgnInWithEmail)
        driver.isEleVisible(txtField_Email)
        driver.isEleVisible(txtField_Password)
        driver.isEleVisible(link_forgotPassword)
        driver.isEleVisible(btn_SignInContinue)
        driver.isEleVisible(btn_createAccount)

        //Verify the label is as expected
        Assert.assertEquals(
            lbl_SignIn.text,"Sign in")
        Assert.assertEquals(
            btn_continueWithGoogle.text,"Continue with Google")
        Assert.assertEquals(
            btn_continueWithFacebook.text,"Continue with Facebook")
        Assert.assertEquals(
            btn_continueWithApple.text,"Continue with Apple")
        Assert.assertEquals(
            lbl_OrIgnInWithEmail.text,"Or sign in with email")

        return signInScreen
    }

    @Step("As a user I cannot sign in by entering any invalid email and password")
    fun verify_signInWithInvalidCred(): SignInScreen{

        //Get the text fron JSON file
        val invalidUsername = driver.extractDataFromJsonFile("invalidUser1")

        //Get the text fron JSON file
        val invalidPassword = driver.extractDataFromJsonFile("invalidPassword")

        //Click on Continue button
        driver.clickElement(btn_SignInContinue)

        driver.implicitWait(3)

        driver.isEleVisible(lbl_SignIn)

        //Enter Invalid Username
        driver.typeText(txtField_Email, invalidUsername.replace("\"", ""))

        driver.navigateBack()

        //Enter valid Password
        driver.typeText(txtField_Password, invalidPassword.replace("\"", ""))

        driver.navigateBack()

        //Click on Continue button
        driver.clickElement(btn_SignInContinue)

        driver.implicitWait(3)

        driver.isEleVisible(lbl_SignIn)

        return signInScreen
    }

    @Step("As a user I can sign in to an existing Free Email account")
    fun verify_signInWithNewCred(): SignInScreen{

        //Get the text fron JSON file
        val existUsername = ((driver.extractDataFromJsonFile("existingUser1")).replace("\"", ""))

        //Get the text fron JSON file
        val validPassword = driver.extractDataFromJsonFile("defaultPassword")

        driver.clearText(txtField_Email)

        //Enter Invalid Username
        driver.typeText(txtField_Email, existUsername)

        driver.navigateBack()

        //Enter valid Password
        driver.typeText(txtField_Password, validPassword.replace("\"", ""))

        driver.navigateBack()

        driver.implicitWait(2)

        //Click on Continue button
        driver.clickElement(btn_SignInContinue)

        driver.implicitWait(6)

        Assert.assertEquals(
            txt_loggedInUsername.text,existUsername)

        driver.implicitWait(2)

        driver.clickElement(btn_logOut)

        return signInScreen
    }

    @Step("As a user I can sign in with an unregistered Google account")
    fun verify_signInWithGoogleAccount(): SignInScreen{

        driver.clickElement(btn_continueWithGoogle)

        //Code to select Google user

        driver.implicitWait(3)

        driver.clickElement(btn_logOut)

        return signInScreen
    }

    @Step("As a user I can sign in with an unregistered Facebook account")
    fun verify_signInWithFacebookAccount(): SignInScreen{

        driver.clickElement(btn_continueWithGoogle)

        //Code to select Facebook user

        driver.implicitWait(3)

        driver.clickElement(btn_logOut)

        return signInScreen
    }
}