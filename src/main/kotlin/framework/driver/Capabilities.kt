package framework.driver

import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.IOSMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import util.App
import util.EnvironmentManager.isRealIosDevice

object Capabilities {
    fun Android(): DesiredCapabilities {
        val capabilities = createCommonCapabilities()

        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 3000)
        capabilities.setCapability(AndroidMobileCapabilityType.NO_SIGN, true)
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "1368443630000GC")
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2")
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true)
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_LAUNCH, true)
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.cliffweitzman.speechify2.screens.splash.SplashScreenActivity")
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.cliffweitzman.speechify2")
        capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "com.cliffweitzman.speechify2.screens.onboarding.OnboardingActivity")
        //capabilities.setCapability(MobileCapabilityType.FULL_RESET,true)
        //capabilities.setCapability("appium:enforceAppInstall", true)

        return capabilities
    }

    fun iOS() : DesiredCapabilities {
        val capabilities = createCommonCapabilities()

        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120)
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS")
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8")
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.2")
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest")
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false)
        capabilities.setCapability(IOSMobileCapabilityType.CONNECT_HARDWARE_KEYBOARD, "false")
//        capabilities.setCapability("appium:permissions", permissions)
        capabilities.setCapability(IOSMobileCapabilityType.USE_NEW_WDA, "true")
        capabilities.setCapability("appium:waitForQuiescence", "false")
        capabilities.setCapability(IOSMobileCapabilityType.MAX_TYPING_FREQUENCY, 10)

        if (isRealIosDevice) {
            capabilities.setCapability(IOSMobileCapabilityType.XCODE_ORG_ID, "<ID>")
            capabilities.setCapability(IOSMobileCapabilityType.XCODE_SIGNING_ID, "<SIGN ID>")
            capabilities.setCapability(MobileCapabilityType.UDID, "<PHONE UDID>")
        }
        return capabilities
    }

    private fun createCommonCapabilities(): DesiredCapabilities {
        val capabilities = DesiredCapabilities()
        capabilities.setCapability(MobileCapabilityType.APP, App.Path)
        return capabilities
    }
}