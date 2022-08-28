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
import com.dgdavidgreene.androidritualsbeta.ui.util.DateTimeUtil.composeTimeStamp
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

    var createdDate by mutableStateOf("")
        private set


    var sentiment by mutableStateOf<RitualSentimentEntity?>(null)
        private set

    init {
        savedStateHandle.get<String>("sentimentId")?.let { sentimentId ->
            this.sentimentId = sentimentId.toLong()
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
            createdDate = sentiment?.createdAt.toString()
            repository.insertRitualSentimentEntity(sentimentCategory, sentimentContentField, createdDate, composeTimeStamp(), sentiment?.id)
        }
    }

    fun onSentimentCategoryChange(value: String) {
        this.sentimentCategory = value.toLong()
    }

    fun onContentChange(value: String) {
        this.sentimentContentField = value
    }

}