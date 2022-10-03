package framework.driver
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import framework.SeleniumGridManager
import org.openqa.selenium.*
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import robot.PageObjects.OnboardingScreen
import java.io.FileReader
import java.net.URL
import java.util.concurrent.TimeUnit
import java.util.logging.Logger

interface AutomateDriver {
    var driver:AppiumDriver<MobileElement>

    fun initDriver()

    fun findElementById(id: String): MobileElement

    fun findElementByAccessibilityId(id: String): MobileElement

    fun findElementByXpath(XPath: String): MobileElement

    fun findElementsById(id: String): List<MobileElement>

    fun isEleVisible(elementID: MobileElement): Boolean

    fun isEleEnabled(elementID: MobileElement): Boolean

    fun extractDataFromJsonFile(key: String): String

    fun typeText(elementID: MobileElement, input: String)

    fun clearText(elementID: MobileElement)

    fun clickElement(elementID: MobileElement)

    fun implicitWait(duration: Long)

    fun dragToPosition(elementID: MobileElement, XPosition: Int, YPosition: Int)

    fun navigateBack()

}

abstract class BaseAutomateDriver: AutomateDriver {
    override var driver: AppiumDriver<MobileElement> by ThreadLocalDelegate.lateinit()

    //override var androidDriver: AndroidDriver<MobileElement> by ThreadLocalDelegate.lateinit()

    override fun findElementByAccessibilityId(id: String): MobileElement {
        return driver.findElementByAccessibilityId(id)
    }

    protected fun setImplicityWait() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS)
    }
}

class AndroidAutomateDriver: BaseAutomateDriver() {

    override fun initDriver() {
        driver = AndroidDriver(URL(SeleniumGridManager.serverAddress), Capabilities.Android())
        setImplicityWait()
    }

    override fun implicitWait(duration: Long){
        driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS)
    }

    override fun findElementById(id: String): MobileElement {
        return driver.findElementById(id)
    }

    override fun findElementsById(id: String): List<MobileElement> {
        return driver.findElementsById(id)
    }

    override fun findElementByXpath(XPath: String): MobileElement {
        return driver.findElementByXPath(XPath)
    }

    override fun isEleVisible(elementID: MobileElement): Boolean{
        try{
            WebDriverWait(driver, 3000)
                .until(ExpectedConditions.visibilityOf(elementID))
        }
        catch (e: TimeoutException)
        {

            return false
        }
        return true
    }

    override fun isEleEnabled(elementID: MobileElement): Boolean{
        return elementID.isEnabled()
    }

    override  fun typeText(elementID: MobileElement, input: String){
        try{
            WebDriverWait(driver, 3000)
                .until(ExpectedConditions.visibilityOf(elementID))
            elementID.click()
            elementID.clear()
            elementID.sendKeys(input)
        }
        catch (exception: Exception)
        {
            Logger.getLogger(OnboardingScreen:: class.java.name).warning("Error in parsing " + exception.toString())
        }
    }

    override fun clearText(elementID: MobileElement){
        WebDriverWait(driver, 3000)
            .until(ExpectedConditions.visibilityOf(elementID))
        elementID.click()
        elementID.clear()
    }

    override fun clickElement(elementID: MobileElement) {
        try {
            WebDriverWait(driver, 3000)
                .until(ExpectedConditions.visibilityOf(elementID))
            elementID.click()
        } catch (exception: Exception) {
            Logger.getLogger(OnboardingScreen::class.java.name)
                .warning("Error in parsing " + exception.toString())
        }
    }

    override fun extractDataFromJsonFile(key: String): String{
        var returnObj: JsonObject = JsonObject()
        val path = "${System.getProperty("user.dir")}\\src\\main\\kotlin\\util\\Android.json"
        try{
            val reader = FileReader(path)
            val jsonParser: JsonParser = JsonParser()
            val fileContentArray: JsonObject = jsonParser.parse(reader) as JsonObject
            returnObj = fileContentArray as JsonObject

        }catch (exception: Exception){
            Logger.getLogger(OnboardingScreen:: class.java.name).warning("Error in parsing " + exception.toString())
        }
        return returnObj.get(key).toString()
    }

    override fun dragToPosition(elementID: MobileElement, XPosition: Int, YPosition: Int){
        var act = Actions(driver)
        act.clickAndHold(elementID).moveByOffset(XPosition, YPosition).release(elementID).build().perform()
    }

    override fun navigateBack(){
        driver.navigate().back()
    }
}

class IOSAutomateDriver: BaseAutomateDriver() {
    override fun initDriver() {
        driver = IOSDriver(URL(SeleniumGridManager.serverAddress), Capabilities.iOS())
        setImplicityWait()
    }

    override fun implicitWait(duration: Long){
        driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS)
    }

    override fun findElementById(id: String): MobileElement {
        return driver.findElementByAccessibilityId(id)
    }

    override fun findElementsById(id: String): List<MobileElement> {
        return driver.findElementsByAccessibilityId(id)
    }

    override fun findElementByXpath(XPath: String): MobileElement {
        return driver.findElementByXPath(XPath)
    }

    override fun isEleVisible(elementID: MobileElement): Boolean{
        try{
            WebDriverWait(driver, 3000)
                .until(ExpectedConditions.visibilityOf(elementID))
        }
        catch (e: TimeoutException)
        {
            return false
        }
        return true
    }

    override fun isEleEnabled(elementID: MobileElement): Boolean{
        return elementID.isEnabled
    }

    override  fun typeText(elementID: MobileElement, input: String){
        try{
            WebDriverWait(driver, 3000)
                .until(ExpectedConditions.visibilityOf(elementID))
            elementID.click()
            elementID.clear()
            elementID.sendKeys(input)
        }
        catch (exception: Exception)
        {
            Logger.getLogger(OnboardingScreen:: class.java.name).warning("Error in parsing " + exception.toString())
        }
    }

    override fun clearText(elementID: MobileElement){
        WebDriverWait(driver, 3000)
            .until(ExpectedConditions.visibilityOf(elementID))
        elementID.click()
        elementID.clear()
    }

    override fun clickElement(elementID: MobileElement){
        try{
            WebDriverWait(driver, 3000)
                .until(ExpectedConditions.visibilityOf(elementID))
            elementID.click()
        }
        catch (exception: Exception)
        {
            Logger.getLogger(OnboardingScreen:: class.java.name).warning("Error in parsing " + exception.toString())
        }
    }

    override fun extractDataFromJsonFile(key: String): String{
        var returnObj: JsonObject = JsonObject()
        val path = "D:\\SpeechifyAutomationKotlin\\src\\main\\kotlin\\util\\Android.json"
        try{
            val reader = FileReader(path)
            val jsonParser: JsonParser = JsonParser()
            val fileContentArray: JsonObject = jsonParser.parse(reader) as JsonObject
            returnObj = fileContentArray as JsonObject

        }catch (exception: Exception){
            Logger.getLogger(OnboardingScreen:: class.java.name).warning("Error in parsing " + exception.toString())
        }
        Logger.getLogger(OnboardingScreen:: class.java.name).warning("Shaurabh " + returnObj.get(key).toString())
        return returnObj.get(key).toString()
    }

    override fun dragToPosition(elementID: MobileElement, XPosition: Int, YPosition: Int){
        var act = Actions(driver)
        act.clickAndHold(elementID).moveByOffset(XPosition, YPosition).release(elementID).build().perform()
    }

    override fun navigateBack(){
        driver.navigate().back()
    }
}