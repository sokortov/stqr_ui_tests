package pages

import org.junit.Assert
import org.openqa.selenium.Platform
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions

class MobileMainPage(driver: WebDriver) : BasePage(driver) {

    @FindBy(className = "logo")
    lateinit var logoImage: WebElement

    @FindBy(className = "powered")
    lateinit var poweredText: WebElement

    @FindBy(css = ".locale-changer.locale-switcher")
    lateinit var localeDropdown: WebElement

    @FindBy(css = ".fullscreen-button.fullscreen-btn")
    lateinit var fullscreenButton: WebElement

    @FindBy(className = "playIcon")
    lateinit var playIcon: WebElement

    @FindBy(id = "ar-button")
    lateinit var arButton: WebElement

    @FindBy(id = "videoFrame")
    lateinit var videoFrame: WebElement

    @FindBy(css = ".CTA-buttons-container.cta-buttons")
    lateinit var ctaBlock: WebElement

    @FindBy(className = "recordVideo")
    lateinit var recordVideoButton: WebElement

    fun waitForPageToBeCompletelyLoaded(): MobileMainPage {
        wait.until(ExpectedConditions.visibilityOf(playIcon))
        return this
    }

    fun tapRecordVideoButton() {
        wait.until(ExpectedConditions.elementToBeClickable(recordVideoButton))
        recordVideoButton.click()
    }

    fun checkPageIsDisplayed() {
        Assert.assertTrue(logoImage.isDisplayed)
        Assert.assertTrue(poweredText.isDisplayed)
        Assert.assertTrue(localeDropdown.isDisplayed)
        Assert.assertTrue(videoFrame.isDisplayed)
        Assert.assertTrue(playIcon.isDisplayed)
        Assert.assertTrue(arButton.isDisplayed)
        Assert.assertTrue(ctaBlock.isDisplayed)
        if (capabilities.platform == (Platform.ANDROID)) {
            Assert.assertTrue(fullscreenButton.isDisplayed)
        }
    }

}
