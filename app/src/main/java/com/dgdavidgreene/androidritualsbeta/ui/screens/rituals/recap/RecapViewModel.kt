package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.recap

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import appdb.GetRitualSentimentCountByCategory
import appdb.RitualSentimentEntity
import com.dgdavidgreene.androidritualsbeta.data.Repository
import com.dgdavidgreene.androidritualsbeta.ui.util.DateTimeUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecapViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    var sentiments: Flow<List<RitualSentimentEntity>> = emptyFlow()
    var sentimentCounts: Flow<List<GetRitualSentimentCountByCategory>> = emptyFlow()
    init {
        getSentiments()
        getSentimentCounts()
    }

    private fun getSentiments() {
        viewModelScope.launch {
            val today = DateTimeUtil.getTodayString()
            sentiments = repository.getAllRitualSentiments(today)
        }
    }

    private fun getSentimentCounts() {
        viewModelScope.launch {
            val today = DateTimeUtil.getTodayString()
            sentimentCounts = repository.getRitualSentimentCountsByCategory(today)
        }
    }
}