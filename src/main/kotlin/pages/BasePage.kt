package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory
import org.openqa.selenium.support.ui.WebDriverWait

open class BasePage(val driver: WebDriver) {

    init {
        PageFactory.initElements(AjaxElementLocatorFactory(driver, 10), this)
    }

    val baseURL = "https://dev-scan.stqr.io/"

    val wait = WebDriverWait(driver, 5)

    val capabilities = DesiredCapabilities()

    fun openPage(pageURL: String) = driver.get(pageURL)
}
