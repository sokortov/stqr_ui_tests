package pages

import org.junit.Assert
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class PickedVideoPage(driver: WebDriver) : BasePage(driver)  {

    @FindBy(css = ".picked-video-player.video-player.inverted")
    lateinit var videoPlayer: WebElement

    fun checkPageIsDisplayed() {
        Assert.assertTrue(videoPlayer.isDisplayed)
    }
}
