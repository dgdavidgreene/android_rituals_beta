package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.suggestions

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.dgdavidgreene.androidritualsbeta.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SuggestionsViewModel @Inject constructor(
    private val repository: Repository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

}