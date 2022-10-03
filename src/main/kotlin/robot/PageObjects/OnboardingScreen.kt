package robot.PageObjects

import io.appium.java_client.MobileElement
import io.qameta.allure.Step
import org.testng.Assert
import robot.BaseRobot
import robot.PageObjectsRobots.onboardingScreen


class OnboardingScreen: BaseRobot() {
    //Objects of First Onboarding screen
    private val txt_welcomeToSpeechify: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/heading")

    //Objects of Whats your first name? - Onboarding
    private val icon_whatIsYourFirstName: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/firstNameImv")
    private val lbl_whatIsYourFirstName: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/heading")
    private val txtField_whatIsYourFirstName: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/etFirstName")
    private val btn_whatIsYourFirstNameContinue: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/continueButton")

    //Objects of What is most of your reading for? - Onboarding
    private val lbl_mostOfReadingFor: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/heading")
    private val btn_school: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/optionTxtSchool")
    private val btn_work: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/optionTxtWork")
    private val btn_leisure: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/optionTxtLeisure")

    //Objects of What do want Speechify to help you do? - Onboarding
    private val lbl_whatYouWantSpeechifyHelp: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/heading")
    private val lbl_selectAllThatApply: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/subheading")
    private val btn_ImproveReadSpeed: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/optionTxt1")
    private val btn_ReadEasily: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/optionTxt2")
    private val btn_ImproveComprehension: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/optionTxt3")
    private val btn_ReadMultitask: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/optionTxt4")
    private val btn_whatDoYouWantContinue: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/continueButton")

    //Objects of What do you read most often?
    private val lbl_whatDoYouReadOften: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/heading")
    private val lbl_selectAllThatApply_2: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/subheading")
    private val btn_txt_assignment: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/optionTxt1")
    private val btn_docs_pdf: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/optionTxt2")
    private val btn_email_text: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/optionTxt3")
    private val btn_researchPaper: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/optionTxt4")
    private val btn_books_novels: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/optionTxt5")
    private val btn_articles: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/optionTxt6")
    private val btn_whatDoYouReadContinue: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/continueButton")

    //Objects of Reading Superpowers article on Onboarding
    private val lbl_readingSuperpowers: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/currentTrackTitleTextView")
    private val lbl_readingSuperpowersTimeEstimate: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/currentTrackDetails")
    private val lbl_readingSuperpowersElapsedTime: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/elapsedTime")
    private val lbl_readingSuperpowersTotalTime: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/totalTime")
    private val btn_readingSuperpowersPlay: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/playButton")
    private val btn_readingSuperpowersContinue: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/continueButton")

    private val icon_readingSuperpowersSelectVoiceHighlight: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/selectVoiceButton")
    private val icon_readingSuperpowersSelectSpeedHighlight: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/selectSpeedButton")

    //Onboarding Select Voice screen
    private val lbl_selectVoice: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/title")
    private val btn_selectVoiceDone: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/doneButton")
    private val txtField_voiceSearch: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/etSearch")
    private val lst_selectVoice: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/voicesRecyclerView")
    private val opt_voiceEmma: MobileElement get() = driver.findElementByXpath("//*[@text='Emma']")

    //Onboarding Select Speed
    private val lbl_selectSpeed: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/title")
    private val btn_selectSpeedDone: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/doneButton")
    private val lbl_speedReader: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/speedReader")
    private val icon_speedReaderPremium: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/imgPremiumSpeedReader")
    private val lbl_faster: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/faster")
    private val icon_fasterPremium: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/imgPremiumFaster")
    private val lbl_average: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/average")
    private val lbl_slower: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/slower")
    private val lbl_increaseSpeedAuto: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/checkBoxSpeedRamp")
    private val slider_Speed: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/speedSlider")
    private val lbl_defaultSpeed: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/listeningSpeed")
    private val lbl_defaultwpm: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/wpmSpeed")

    //Try Premium for free upsell dilog
    private val lbl_tryPremiumForFreeUpsell: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/heading")
    private val btn_tryPremiumForFreeUpsellClose: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/closeButton")
    private val btn_startFreeTrialNow: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/startFreeTrialButton")
    private val lbl_tryPremiumForFreeSignIn: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/bottomText")

    //A Gift for you dilog
    private val lbl_aGiftForYou: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/heading")
    private val lbl_1500DiscountWords: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/txtDiscount")
    private val btn_claimMyGift: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/claimDiscountButton")
    private val btn_aGiftForYou_signIn: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/bottomText")

    //Update Speechify Dilog from Play Store
    private val lbl_updateSpeechify: MobileElement get() = driver.findElementByXpath("//*[@text='Update Speechify?']")
    private val btn_NoThanks: MobileElement get() = driver.findElementByXpath("//*[@text='NO THANKS']")
    private val btn_NoThanksList: List<MobileElement> get() = driver.findElementsById("com.android.vending:id/0_resource_name_obfuscated")

    //Library screen post onboarding
    private val icon_Cliff: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/imageView")
    private val btn_LibraryImportFile: MobileElement get() = driver.findElementById("com.cliffweitzman.speechify2:id/fab")

    @Step("Verify Welcome To Speechify Text Content")
    fun verify_WelcomeToSpeechifyText(): OnboardingScreen {

        //val expectedWelcomeToSpeechifyTxt = driver.extractDataFromJsonFile("Onboarding_WelcomeToSpeechify").replace("\"", "")
        //Logger.getLogger(OnboardingScreen:: class.java.name).warning("Expected -------->  " + expectedWelcomeToSpeechifyTxt)
        //Logger.getLogger(OnboardingScreen:: class.java.name).warning("Actual -------->  " + txt_welcomeToSpeechify.text.replace("\n", ""))
        //Assert.assertEquals(txt_welcomeToSpeechify.text.replace("\n", "").trim(), expectedWelcomeToSpeechifyTxt)
        driver.isEleVisible(txt_welcomeToSpeechify)
        return onboardingScreen
    }

    @Step("What is your first name screen")
    fun verify_WhatIsYourFirstNameScreen(): OnboardingScreen {
        //Get the text fron JSON file
        val expectedWhatIsYourNameTxt = driver.extractDataFromJsonFile("WhatIsYourFirstName")

        //Verify Whats Your Name icon is visible
        driver.isEleVisible(icon_whatIsYourFirstName)

        //Verify Whats your name text field is visible
        driver.isEleVisible(txtField_whatIsYourFirstName)

        //Verify the label is as expected
        Assert.assertEquals(
            lbl_whatIsYourFirstName.text,
            expectedWhatIsYourNameTxt.replace("\"", "")
        )

        //Phone Call to mobile test device
        //driver.simulateCall()

        //Enter First name
        driver.typeText(txtField_whatIsYourFirstName, "John Wick")

        //Check if the Continue button is enabled
        driver.isEleEnabled(btn_whatIsYourFirstNameContinue)

        //Click on the Continue button
        driver.clickElement(btn_whatIsYourFirstNameContinue)

        return onboardingScreen
    }

    /*Accepts one of the following parameters based on the option to be selected
    School
    Work
    Leisure
    */
    @Step("What is Most of Your readind for? - School")
    fun verify_WhatIsYourReadingFor(option: String): OnboardingScreen {

        //Get the text fron JSON file
        val expectedWhatIsYourReadingForTxt =
            driver.extractDataFromJsonFile("WhatIsMostOfYourReadingFor")

        //Verify Label and the three options are visible
        driver.isEleVisible(lbl_mostOfReadingFor)
        driver.isEleVisible(btn_school)
        driver.isEleVisible(btn_work)
        driver.isEleVisible(btn_leisure)

        //Verify the label is as expected
        Assert.assertEquals(
            lbl_whatIsYourFirstName.text,
            expectedWhatIsYourReadingForTxt.replace("\"", "")
        )

        if (option == "School") {
            //Click on School
            driver.clickElement(btn_school)
        } else if (option == "Work") {
            //Click on Work
            driver.clickElement(btn_work)
        } else if (option == "Leisure") {
            //Click on Leisure
            driver.clickElement(btn_leisure)
        }


        return onboardingScreen
    }

    /*
    Provide the boolean value for the options to be selected.
    ImproveReadSpeed
    ReadEasily
    ImproveComprehension
    ReadMultitask
     */
    @Step("What do you want Speechify to help you do? - School")
    fun verify_WhatDoYouWantFromSpeechify(
        ImproveReadSpeed: Boolean,
        ReadEasily: Boolean,
        ImproveComprehension: Boolean,
        ReadMultitask: Boolean
    ): OnboardingScreen {

        //Get the text fron JSON file
        val expectedWhatDoYouWantSpeechifyToHelpTxt =
            driver.extractDataFromJsonFile("WhatDoYouWantSpeechifyToHelp")

        //Verify Label and the three options are visible
        driver.isEleVisible(lbl_whatYouWantSpeechifyHelp)
        driver.isEleVisible(lbl_selectAllThatApply)
        driver.isEleVisible(btn_ImproveReadSpeed)
        driver.isEleVisible(btn_ReadEasily)
        driver.isEleVisible(btn_ImproveComprehension)
        driver.isEleVisible(btn_ReadMultitask)

        //Verify the label is as expected
        Assert.assertEquals(
            lbl_whatIsYourFirstName.text,
            expectedWhatDoYouWantSpeechifyToHelpTxt.replace("\"", "")
        )

        if (ImproveReadSpeed) {
            //Click on Improve Reading Speed
            driver.clickElement(btn_ImproveReadSpeed)
        }

        if (ReadEasily) {
            //Click on Read Easily
            driver.clickElement(btn_ReadEasily)
        }

        if (ImproveComprehension) {
            //Click on Improve Comprehension
            driver.clickElement(btn_ImproveComprehension)
        }

        if (ReadMultitask) {
            //Click on Read Multi task
            driver.clickElement(btn_ReadMultitask)
        }

        //Click on Continue button
        driver.clickElement(btn_whatDoYouWantContinue)

        return onboardingScreen
    }

    /*
    Provide the boolean value for the options to be selected.
    txt_assignment
    docs_pdf
    email_text
    researchPaper
    books_novels
    articles
     */
    @Step("What do you want Speechify to help you do? - School")
    fun verify_WhatDoReadOften(
        txt_assignment: Boolean,
        docs_pdf: Boolean,
        email_text: Boolean,
        researchPaper: Boolean,
        books_novels: Boolean,
        articles: Boolean
    ): OnboardingScreen {

        //Get the text fron JSON file
        val expectedWhatDoYouReadMostOftenTxt =
            driver.extractDataFromJsonFile("WhatDoYouReadMostOften")

        //Verify Label and the three options are visible
        driver.isEleVisible(lbl_whatDoYouReadOften)
        driver.isEleVisible(lbl_selectAllThatApply_2)
        driver.isEleVisible(btn_txt_assignment)
        driver.isEleVisible(btn_docs_pdf)
        driver.isEleVisible(btn_email_text)
        driver.isEleVisible(btn_researchPaper)
        driver.isEleVisible(btn_books_novels)
        driver.isEleVisible(btn_articles)

        //Verify the label is as expected
        Assert.assertEquals(
            lbl_whatDoYouReadOften.text,
            expectedWhatDoYouReadMostOftenTxt.replace("\"", "")
        )

        if (txt_assignment) {
            //Click on txt_assignment
            driver.clickElement(btn_txt_assignment)
        }

        if (docs_pdf) {
            //Click on docs_pdf
            driver.clickElement(btn_docs_pdf)
        }

        if (email_text) {
            //Click on email_text
            driver.clickElement(btn_email_text)
        }

        if (researchPaper) {
            //Click on researchPaper
            driver.clickElement(btn_researchPaper)
        }

        if (books_novels) {
            //Click on books_novels
            driver.clickElement(btn_books_novels)
        }

        if (articles) {
            //Click on articles
            driver.clickElement(btn_articles)
        }

        //Click on Continue button
        driver.clickElement(btn_whatDoYouReadContinue)

        return onboardingScreen
    }

    @Step("Verify Reading Superpowers article")
    fun verify_ReadingSuperpowersArticle(): OnboardingScreen {

        driver.implicitWait(1)
        //Get the text fron JSON file
        val title_readingSuperpowers =
            driver.extractDataFromJsonFile("ReadingSuperpowers")

        //Verify the label is as expected
        Assert.assertEquals(
            lbl_readingSuperpowers.text,
            title_readingSuperpowers.replace("\"", "")
        )

        //Verify Reading Superpower elements are visible
        driver.isEleVisible(lbl_readingSuperpowers)
        driver.isEleVisible(lbl_readingSuperpowersTimeEstimate)
        driver.isEleVisible(lbl_readingSuperpowersElapsedTime)
        driver.isEleVisible(lbl_readingSuperpowersTotalTime)
        driver.isEleVisible(btn_readingSuperpowersPlay)

        driver.implicitWait(30)

        //Verify and click on Voice selector
        driver.isEleVisible(icon_readingSuperpowersSelectVoiceHighlight)
        driver.clickElement(icon_readingSuperpowersSelectVoiceHighlight)

        //Verify Voice selector elements
        driver.isEleVisible(lbl_selectVoice)
        driver.isEleVisible(btn_selectVoiceDone)
        driver.isEleVisible(txtField_voiceSearch)
        driver.isEleVisible(lst_selectVoice)

        //Select Emma voice
        driver.clickElement(opt_voiceEmma)
        driver.implicitWait(3)
        driver.clickElement(btn_selectVoiceDone)

        driver.implicitWait(15)

        //Verify and click on Speed Selector
        driver.isEleVisible(icon_readingSuperpowersSelectSpeedHighlight)
        driver.clickElement(icon_readingSuperpowersSelectSpeedHighlight)

        //Verify Speed selector elements
        driver.isEleVisible(lbl_selectSpeed)
        driver.isEleVisible(btn_selectSpeedDone)
        driver.isEleVisible(lbl_speedReader)
        driver.isEleVisible(icon_speedReaderPremium)
        driver.isEleVisible(lbl_faster)
        driver.isEleVisible(icon_fasterPremium)
        driver.isEleVisible(lbl_average)
        driver.isEleVisible(lbl_slower)
        driver.isEleVisible(lbl_increaseSpeedAuto)
        driver.isEleVisible(slider_Speed)
        driver.isEleVisible(lbl_defaultSpeed)
        driver.isEleVisible(lbl_defaultwpm)

        driver.dragToPosition(slider_Speed, 582, 616)

        driver.clickElement(btn_selectSpeedDone)

        //driver.implicitWait(3)

        //driver.clickElement(btn_readingSuperpowersPlay)

        //driver.implicitWait(5)

        //driver.clickElement(btn_readingSuperpowersPlay)

        driver.implicitWait(50)

        driver.clickElement(btn_readingSuperpowersContinue)


        return onboardingScreen
    }

    @Step("Verify Try Premium For free upsell")
    fun verify_TryPremiumForFreeUpsell(): OnboardingScreen {

        driver.implicitWait(1)
        //Get the text fron JSON file
        val title_tryPremiumForFreeUpsell =
            driver.extractDataFromJsonFile("TryPremiumForFree")

        //Verify the label is as expected
        Assert.assertEquals(
            lbl_tryPremiumForFreeUpsell.text,
            title_tryPremiumForFreeUpsell.replace("\"", "")
        )

        //Verify Try Premium For free upsell elements are visible
        driver.isEleVisible(lbl_tryPremiumForFreeUpsell)
        driver.isEleVisible(btn_tryPremiumForFreeUpsellClose)
        driver.isEleVisible(btn_startFreeTrialNow)
        driver.isEleVisible(lbl_tryPremiumForFreeSignIn)

        //Close the upsell dilog
        driver.clickElement(btn_tryPremiumForFreeUpsellClose)

        return onboardingScreen
    }

    @Step("Verify A Gift for you dilog")
    fun verify_AGiftForYouDilog(): OnboardingScreen {

        driver.implicitWait(1)
        //Get the text fron JSON file
        val title_aGiftForYouDilog =
            driver.extractDataFromJsonFile("AGiftForYou")

        //Verify the label is as expected
        Assert.assertEquals(
            lbl_aGiftForYou.text,
            title_aGiftForYouDilog.replace("\"", "")
        )

        //Verify A Gift For You dilog elements are visible
        driver.isEleVisible(lbl_aGiftForYou)
        driver.isEleVisible(lbl_1500DiscountWords)
        driver.isEleVisible(btn_claimMyGift)
        driver.isEleVisible(btn_aGiftForYou_signIn)

        //Click on claim my gift button
        driver.clickElement(btn_claimMyGift)

        driver.implicitWait(5)

        return onboardingScreen
    }

    @Step("Close Play store update dilog if displayed")
    fun close_PlayStoreUpdateDilog(): OnboardingScreen {
            driver.navigateBack()
        return onboardingScreen
    }

    @Step("Post Onboarding Library screen")
    fun verify_postOnboardingLibrary(): OnboardingScreen{
        driver.implicitWait(5)
        driver.isEleVisible(icon_Cliff)
        driver.clickElement(icon_Cliff)
        driver.implicitWait(2)
        driver.isEleVisible(btn_LibraryImportFile)
        driver.implicitWait(2)
        driver.clickElement(btn_LibraryImportFile)
        driver.implicitWait(2)
        driver.clickElement(btn_LibraryImportFile)
        return onboardingScreen
    }
}