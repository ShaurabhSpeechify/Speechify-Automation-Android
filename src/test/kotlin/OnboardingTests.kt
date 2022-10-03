import org.testng.annotations.Test

import robot.PageObjectsRobots.onboardingScreen

@Test(priority = 1)
class OnboardingTests : BaseTest() {

    @Test(description = "Verification of first Onboarding screen")
    fun test1_FirstOnboardingScreen(){
        onboardingScreen
            .verify_WelcomeToSpeechifyText()
    }

    @Test(description = "Verification of What Is Your First Name? Onboarding screen")
    fun test2_WhatsYourNameOnboardingScreen(){
        onboardingScreen
            .verify_WhatIsYourFirstNameScreen()
    }

    @Test(description = "Verification of What Is Your Reading for? Onboarding screen and select School")
    fun test3_WhatIsYourReadingForScreen() {
        onboardingScreen
            .verify_WhatIsYourReadingFor("School")
    }

    @Test(description = "Verification of What do you want Speechify to help you do? Onboarding screen")
    fun test4_WhatDoYouWantSpeechifyToHelpYouDoScreen() {
        onboardingScreen
            .verify_WhatDoYouWantFromSpeechify(true, false, true, false)
    }

    @Test(description = "Verification of What do read most often? Onboarding screen")
    fun test5_WhatDoYouReadMostOftenScreen() {
        onboardingScreen
            .verify_WhatDoReadOften(true, false, true, false, false, false)
    }

    @Test(description = "Verification of Reading Superpower Article during Onboarding")
    fun test6_VerifyReadingSuperpowerArticle() {
        onboardingScreen
            .verify_ReadingSuperpowersArticle()
    }

    @Test(description = "Verification of Try Premium For Free Upsell post Onboarding")
    fun test7_verifyTryPremiumForFreeUpsell() {
        onboardingScreen
            .verify_TryPremiumForFreeUpsell()
    }

    @Test(description = "Verification of A Gift For You Dilog post Onboarding")
    fun test8_verify_AGiftForYouDilog() {
        onboardingScreen
            .verify_AGiftForYouDilog()
            .verify_postOnboardingLibrary()

    }



}