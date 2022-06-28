package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.sentiments.add

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dgdavidgreene.androidritualsbeta.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class SentimentAddViewModel @Inject constructor(private val repository: Repository) : ViewModel() {



    var sentimentCategoryIdentifier by mutableStateOf(0L)
        private set

    var sentimentContentField by mutableStateOf("")
        private set

    fun onSaveSentiment() {
        if (sentimentContentField.isBlank()) {
            return
        }

        viewModelScope.launch {
            repository.insertRitualSentimentEntity(sentimentCategoryIdentifier, sentimentContentField, getCreationTime())
        }
    }

    fun onCategoryChange(value: Long){
        this.sentimentCategoryIdentifier = value
    }

    fun onContentChange(value:String){
        this.sentimentContentField = value
    }

    private fun getCreationTime() : String{
        val date = Date()
        val sdf = SimpleDateFormat("dd MMMM, yyyy", Locale.getDefault())
        return sdf.format(date)
    }

}