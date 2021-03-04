package tests

import org.junit.Test
import org.junit.runner.RunWith
import pages.MobileMainPage
import pages.PickedVideoPage
import pages.RecordingPage
import runner.BaseTest
import runner.Device
import runner.Parallelized

@RunWith(Parallelized::class)
class RecordingPageTests(device: Device) : BaseTest(device) {

    private fun mobileMainPage(func: MobileMainPage.() -> Unit) = driver?.let { MobileMainPage(it).apply { func() } }
    private fun recordingPage(func: RecordingPage.() -> Unit) = driver?.let { RecordingPage(it).apply { func() } }
    private fun pickedVideoPage(func: PickedVideoPage.() -> Unit) = driver?.let { PickedVideoPage(it).apply { func() } }

    private val endpoint = "?qr=test7#/"
    private val videoLength: Long = 1000

    @Test
    fun testVideoRec() {
        mobileMainPage {
            openPage(baseURL + endpoint)
            tapRecordVideoButton()
        }
        recordingPage {
            recordVideoWithLength(videoLength)
        }
        pickedVideoPage {
            checkPageIsDisplayed()
        }
    }
}
