package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.sentiments.add

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dgdavidgreene.androidritualsbeta.data.Repository
import com.dgdavidgreene.androidritualsbeta.ui.theme.Util.composeTimeStamp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

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
            val timeStamp = composeTimeStamp()
            repository.insertRitualSentimentEntity(sentimentCategoryIdentifier, sentimentContentField, timeStamp, timeStamp)
        }
    }

    fun onCategoryChange(value: Long){
        this.sentimentCategoryIdentifier = value
    }

    fun onContentChange(value:String){
        this.sentimentContentField = value
    }

}