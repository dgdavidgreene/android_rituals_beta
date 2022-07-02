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
import com.dgdavidgreene.androidritualsbeta.ui.theme.Util.composeTimeStamp
import com.dgdavidgreene.androidritualsbeta.ui.theme.Util.formatDateMonthDefault
import com.dgdavidgreene.androidritualsbeta.ui.theme.Util.formatDateTimeDefault
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

    var createdAt by mutableStateOf<String>("")
        private set

    var modifiedAt by mutableStateOf<String>("")
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
                val createdDateString = sentiment?.createdAt ?: composeTimeStamp()
                val modifiedDateString = sentiment?.modifiedAt ?: composeTimeStamp()
                createdAt = formatDateMonthDefault(createdDateString)
                modifiedAt = formatDateTimeDefault(modifiedDateString)
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