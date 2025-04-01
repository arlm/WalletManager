package br.com.alexandremarcondes.walletmanager.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.alexandremarcondes.walletmanager.ui.theme.AndroidPhonePreviews
import br.com.alexandremarcondes.walletmanager.ui.theme.ApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            ApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MessageCard("Android")
                }
            }
        }
    }
}

@Composable
fun MessageCard(text: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = text
        )
    }
}

@AndroidPhonePreviews
@Composable
fun PreviewMessageCard() {
    ApplicationTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            MessageCard("Android")
        }
    }
}