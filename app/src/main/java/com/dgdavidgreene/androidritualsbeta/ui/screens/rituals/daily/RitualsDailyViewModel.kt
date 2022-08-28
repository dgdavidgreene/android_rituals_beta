package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.daily

import androidx.lifecycle.ViewModel
import com.dgdavidgreene.androidritualsbeta.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RitualsDailyViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val today = "2022-08-27"
    val sentimentCounts = repository.getRitualSentimentCountsByCategory(today)
}