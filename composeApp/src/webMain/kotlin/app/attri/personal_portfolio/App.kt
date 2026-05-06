package app.attri.personal_portfolio

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.attri.personal_portfolio.screens.home.HomeScreen
import app.attri.personal_portfolio.theme.PortfolioTheme
import app.attri.personal_portfolio.theme.Surface


@Composable
fun App() {
    PortfolioTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HomeScreen()
        }
    }
}
