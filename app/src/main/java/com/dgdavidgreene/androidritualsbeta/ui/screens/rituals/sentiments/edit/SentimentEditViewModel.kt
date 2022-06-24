package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.sentiments.edit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dgdavidgreene.androidritualsbeta.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import appdb.RitualSentimentEntity
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class SentimentEditViewModel @Inject constructor(
    private val repository: Repository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var sentimentId: Long? = null
        private set

    var sentimentCategory by mutableStateOf(0L)
        private set

    var sentimentContentField by mutableStateOf("")
        private set


    var sentiment by mutableStateOf<RitualSentimentEntity?>(null)
        private set

    init {
        savedStateHandle.get<String>("SentimentId")?.let { SentimentId ->
            this.sentimentId = sentimentId?.toLong()
            getSentimentById()
        }
    }

    fun getSentimentById() {
        viewModelScope.launch {
            sentimentId?.let {
                sentiment = repository.getRitualSentimentEntityById(it)
                sentimentCategory = sentiment?.category ?: 0
                sentimentContentField = sentiment?.sentiment ?: ""
            }
        }
    }

    fun onSaveSentiment() {
        if (sentimentContentField.isBlank()) {
            return
        }

        viewModelScope.launch {
            repository.insertRitualSentimentEntity(sentimentCategory, sentimentContentField, getCreationTime(), sentimentId)
        }
    }

    fun onSentimentCategoryChange(value: String) {
        this.sentimentCategory = value.toLong()
    }

    fun onContentChange(value: String) {
        this.sentimentContentField = value
    }

    private fun getCreationTime(): String {
        val date = Date()
        val sdf = SimpleDateFormat("dd MMMM, yyyy", Locale.getDefault())
        return sdf.format(date)
    }

}