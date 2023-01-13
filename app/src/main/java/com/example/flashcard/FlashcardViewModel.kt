package com.example.flashcard

import androidx.lifecycle.ViewModel

class FlashcardViewModel : ViewModel() {
    val flashcardDataList = listOf(
        FlashcardData(
            "Computer",
            "a programmable usually electronic device that can store, retrieve, and process data"
        ),
        FlashcardData("Laptop", "a computer that opens and closes"),
        FlashcardData("tablet", "a computer with a screen that you can touch"),
        FlashcardData("smartphone", "a phone that can use the internet"),
        FlashcardData("screen", "the part that shows pictures on a computer or phone"),
        FlashcardData("camera", "a device that takes photos"),
    )
}

data class FlashcardData(
    val term: String,
    val definition: String,
)
