import org.testng.annotations.Test
import robot.PageObjectsRobots.signUpScreen

class SignUpTests : BaseTest() {

    @Test(description = "Navigate and verify Sign up screen")
    fun test1_SignUpScreenVerification(){
        signUpScreen
            .verify_navigateToSignUpFromLibrary()
            .verify_SignUpScreen()
    }
    @Test(description = "Verification of Sign up using existing username")
    fun test2_SignUpOfExistingUser(){
        signUpScreen
            .verify_signUpWithExistingUser()
    }

    @Test(description = "Verification of Sign up using invalid username")
    fun test3_SignUpOfInvalidUser(){
        signUpScreen
            .verify_signUpWithInvalidCred()
    }

    @Test(description = "Verification of Sign up using new valid user account")
    fun test4_SignUpOfValidFreeUser(){
        signUpScreen
            .verify_signUpWithNewCred()
            .logOut()
    }
}