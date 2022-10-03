import org.testng.annotations.Test
import robot.PageObjectsRobots.signInScreen

class SignInTests : BaseTest() {

    @Test(description = "Navigate and verify Sign In screen")
    fun test1_SignInScreenVerification(){
        signInScreen
            .verify_SignInScreen()
            .verify_signInWithInvalidCred()
    }
    @Test(description = "Verification of Sign up using existing username")
    fun test2_SignUpOfExistingUser(){
        signInScreen
            .verify_signInWithNewCred()
    }



}