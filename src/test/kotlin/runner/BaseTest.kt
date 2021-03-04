package runner

import org.junit.After
import org.junit.Before
import org.junit.runners.Parameterized
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import java.lang.Exception
import java.net.MalformedURLException
import java.net.URL

open class BaseTest(device: Device) {

    var driver: RemoteWebDriver? = null
    private val osVersion = device.osVersion
    private val deviceName = device.deviceName

    @Before
    @Throws(Exception::class)
    fun setUp() {
        val capabilities = DesiredCapabilities()

        //Set device
        capabilities.setCapability("os_version", osVersion)
        capabilities.setCapability("device", deviceName)
        capabilities.setCapability("real_mobile", "true")

        //Allow permissions (we need it for camera permission)
        capabilities.setCapability("autoAcceptAlerts", "true")
        capabilities.setCapability("autoGrantPermissions", "true")

        try {
            driver = RemoteWebDriver(URL(Config.URL), capabilities)
            driver?.manage()?.deleteAllCookies()
        } catch (e: MalformedURLException) {
            println("Invalid grid URL")
        } catch (e: Exception) {
            println(e.message)
        }
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        if (driver != null) driver!!.quit()
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Device> {
            return Config.deviceList
        }
    }
}
