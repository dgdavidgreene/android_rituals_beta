package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.initial

import androidx.lifecycle.ViewModel
import com.dgdavidgreene.androidritualsbeta.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RitualsInitialViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    //val sentiments = repository.getAllRitualSentiments()
}