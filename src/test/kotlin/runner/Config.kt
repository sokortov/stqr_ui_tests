package runner

object Config {
    private const val USERNAME: String = "ivansokortov1"
    private const val AUTOMATE_KEY: String = "crit5qUKZx4vvX9JiBGg"
    const val URL: String = "https://$USERNAME:$AUTOMATE_KEY@hub-cloud.browserstack.com/wd/hub"

    val deviceList = listOf(
        Device("13", "iPhone SE 2020"),
        Device("13", "iPhone 8"),
        Device("12", "iPhone 8 Plus"),
        Device("10", "iPhone 7"),
        Device("11", "iPhone 6"),
        Device("14.2", "iPhone 12 Pro Max"))
}

data class Device(
    val osVersion: String,
    val deviceName: String,
)