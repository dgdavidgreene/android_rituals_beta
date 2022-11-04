package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.daily

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import appdb.GetRitualSentimentCountByCategory
import com.dgdavidgreene.androidritualsbeta.data.Repository
import com.dgdavidgreene.androidritualsbeta.ui.notifications.counter.CounterNotificationService
import com.dgdavidgreene.androidritualsbeta.ui.util.DateTimeUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import com.dgdavidgreene.androidritualsbeta.ui.notifications.counter.Counter
import com.dgdavidgreene.androidritualsbeta.ui.notifications.daily.DailyNotificationService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RitualsDailyViewModel @Inject constructor(private val repository: Repository, notificationService: CounterNotificationService, dailyNotificationService: DailyNotificationService) : ViewModel() {
    var sentimentCounts: Flow<List<GetRitualSentimentCountByCategory>> = emptyFlow()
    var service = notificationService
    var dailyService = dailyNotificationService
    var notificationCount = Counter.value
    init {
        getSentimentCategoryCounts()
    }

    private fun getSentimentCategoryCounts() {
        viewModelScope.launch {
            val today = DateTimeUtil.getTodayString()
            sentimentCounts = repository.getRitualSentimentCountsByCategory(today)
        }
    }

    internal fun showNotification(counter: Int) {
        service.showNotification(counter)
        dailyService.showNotification(counter)
        notificationCount++
    }
 }

