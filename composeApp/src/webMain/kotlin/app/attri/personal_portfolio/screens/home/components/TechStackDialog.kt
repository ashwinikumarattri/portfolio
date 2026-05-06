package app.attri.personal_portfolio.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import app.attri.personal_portfolio.theme.OnSurface
import app.attri.personal_portfolio.theme.OnSurfaceVariant
import app.attri.personal_portfolio.theme.Primary
import app.attri.personal_portfolio.theme.SurfaceContainerHigh

@Composable
fun TechStackDialog(onDismissRequest: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = { Text("Technical Stack", color = OnSurface) },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("Kotlin", color = OnSurfaceVariant)
                Text("Compose Multiplatform", color = OnSurfaceVariant)
                Text("Java", color = OnSurfaceVariant)
                Text("Spring Boot", color = OnSurfaceVariant)
                Text("Microservices", color = OnSurfaceVariant)
                Text("Swift", color = OnSurfaceVariant)
                Text("iOS", color = OnSurfaceVariant)
                Text("React Native", color = OnSurfaceVariant)
                Text("JavaScript", color = OnSurfaceVariant)
                Text("TypeScript", color = OnSurfaceVariant)
            }
        },
        confirmButton = {
            Button(
                onClick = onDismissRequest,
                colors = ButtonDefaults.buttonColors(containerColor = Primary)
            ) {
                Text("Close")
            }
        },
        containerColor = SurfaceContainerHigh
    )
}