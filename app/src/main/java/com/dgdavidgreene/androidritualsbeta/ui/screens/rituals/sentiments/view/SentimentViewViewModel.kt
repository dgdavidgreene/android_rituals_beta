package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.sentiments.view

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
import javax.inject.Inject

@HiltViewModel
class SentimentViewViewModel @Inject constructor(
    private val repository: Repository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var sentimentId: Long? = null
        private set

    var sentiment by mutableStateOf<RitualSentimentEntity?>(null)
        private set

    init {
        savedStateHandle.get<String>("sentimentId")?.let { sentimentId ->
            val id = sentimentId
            this.sentimentId = sentimentId.toLong()
            getSentimentById()
        }
    }

    fun getSentimentById() {
        viewModelScope.launch {
            val id = sentimentId
            sentimentId?.let {
                sentiment = repository.getRitualSentimentEntityById(it)
            }
        }
    }

    fun deleteSentiment(){
        viewModelScope.launch {
            sentimentId?.let {
                repository.deleteRitualSentimentEntityById(it)
            }
        }
    }


}