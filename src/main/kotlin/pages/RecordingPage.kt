package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions

class RecordingPage(driver: WebDriver) : BasePage(driver) {

    @FindBy(css = ".toggle-record-container.toggle-record-btn")
    lateinit var recordButton: WebElement

    fun tapRecordButton() {
        wait.until(ExpectedConditions.elementToBeClickable(recordButton))
        recordButton.click()
    }

    fun recordVideoWithLength(videoLength: Long) {
        tapRecordButton()
        Thread.sleep(videoLength)
        tapRecordButton()
    }
}
