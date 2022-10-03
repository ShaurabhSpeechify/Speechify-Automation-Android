package robot

import robot.PageObjects.SignUpScreen
import robot.PageObjects.OnboardingScreen
import robot.PageObjects.SignInScreen

object PageObjectsRobots {

    val onboardingScreen: OnboardingScreen get() = OnboardingScreen()
    val signUpScreen: SignUpScreen get() = SignUpScreen()
    val signInScreen: SignInScreen get() = SignInScreen()
}