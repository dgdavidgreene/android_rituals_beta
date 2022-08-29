package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.recap

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import appdb.GetRitualSentimentCountByCategory
import com.dgdavidgreene.androidritualsbeta.data.Repository
import com.dgdavidgreene.androidritualsbeta.ui.util.DateTimeUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecapViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    var sentimentCounts: Flow<List<GetRitualSentimentCountByCategory>> = emptyFlow()
    init {
        getSentimentCategoryCounts()
    }

    private fun getSentimentCategoryCounts() {
        viewModelScope.launch {
            val today = DateTimeUtil.getTodayString()
            sentimentCounts = repository.getRitualSentimentCountsByCategory(today)
        }
    }
}