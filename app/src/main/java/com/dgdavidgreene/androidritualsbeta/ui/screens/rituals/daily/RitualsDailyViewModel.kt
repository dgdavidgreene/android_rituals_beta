package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.daily

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import appdb.GetRitualSentimentCountByCategory
import com.dgdavidgreene.androidritualsbeta.data.Repository
import com.dgdavidgreene.androidritualsbeta.ui.notifications.counter.CounterNotificationService
import com.dgdavidgreene.androidritualsbeta.ui.util.DateTimeUtil
import dagger.hilt.android.lifecycle.HiltViewModel
//import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RitualsDailyViewModel @Inject constructor(private val repository: Repository, private val notificationService: CounterNotificationService,) : ViewModel() {
    var sentimentCounts: Flow<List<GetRitualSentimentCountByCategory>> = emptyFlow()
    val service = notificationService
    var notificationCount = 0
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

