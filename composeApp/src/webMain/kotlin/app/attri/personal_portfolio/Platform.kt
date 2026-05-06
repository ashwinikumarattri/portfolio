package app.attri.personal_portfolio

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform