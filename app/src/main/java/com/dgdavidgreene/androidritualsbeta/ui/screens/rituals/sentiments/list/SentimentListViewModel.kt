package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.sentiments.list

import androidx.lifecycle.ViewModel
import com.dgdavidgreene.androidritualsbeta.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SentimentListViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val sentiments = repository.getAllRitualSentiments()
}