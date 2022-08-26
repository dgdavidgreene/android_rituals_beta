package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.suggestions

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import appdb.RitualSentimentEntity
import com.dgdavidgreene.androidritualsbeta.data.Repository
import com.dgdavidgreene.androidritualsbeta.ui.theme.Util
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

@HiltViewModel
class SuggestionsViewModel @Inject constructor(
    private val repository: Repository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

}