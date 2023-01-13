package com.example.flashcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flashcard.ui.theme.FlashcardTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlashcardApp()
        }
    }

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    private fun FlashcardApp() {
        val viewModel by viewModels<FlashcardViewModel>()
        val flashcardDataList = viewModel.flashcardDataList

        FlashcardTheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                HorizontalPager(count = flashcardDataList.size) { page ->
                    val termDef = flashcardDataList[page]
                    FlashcardItem(termDef)
                }
            }
        }
    }
}

@Composable
fun FlashcardItem(flashcardData: FlashcardData) {
    var showDefinition by remember { mutableStateOf(false) }
    Card(Modifier.clickable {
        showDefinition = !showDefinition
    }) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .requiredHeight(160.dp)
                .width(360.dp)
                .padding(16.dp)
        ) {
            if (!showDefinition) {
                Term(flashcardData.term)
            } else {
                Definition(flashcardData.definition)
            }
        }
    }
}

@Composable
private fun Term(term: String) {
    Text(term)
}

@Composable
private fun Definition(definition: String) {
    Text(definition)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FlashcardTheme {
        FlashcardItem(FlashcardData("A", "def"))
    }
}
