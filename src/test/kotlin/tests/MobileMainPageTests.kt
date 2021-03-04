package tests

import org.junit.Test
import org.junit.runner.RunWith
import pages.MobileMainPage
import runner.BaseTest
import runner.Device
import runner.Parallelized

@RunWith(Parallelized::class)
class MobileMainPageTests(device: Device) : BaseTest(device) {

    private fun mobileMainPage(func: MobileMainPage.() -> Unit) = driver?.let { MobileMainPage(it).apply { func() } }

    private val endpoint = "?qr=test1#/"

    @Test
    fun testMainPageOpening() {
        mobileMainPage {
            openPage(baseURL + endpoint)
            waitForPageToBeCompletelyLoaded()
            checkPageIsDisplayed()
        }
    }
}
