package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.ritual

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.dgdavidgreene.androidritualsbeta.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RitualViewModel @Inject constructor(private val repository: Repository,
                                          private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    var category: Int? = null
        private set

    init {
        savedStateHandle.get<String>("category")?.let { category ->
            val id = category
            this.category = category.toInt()

        }
    }

    //val sentiments = repository.getAllRitualSentiments()
}