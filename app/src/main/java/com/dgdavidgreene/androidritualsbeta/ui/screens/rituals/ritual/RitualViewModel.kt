package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.ritual

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import appdb.RitualSentimentEntity
import com.dgdavidgreene.androidritualsbeta.data.Repository
import com.dgdavidgreene.androidritualsbeta.ui.theme.Util
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RitualViewModel @Inject constructor(private val repository: Repository,
                                          private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    var category: Long = 0
        private set

    var sentiments: Flow<List<RitualSentimentEntity>> = emptyFlow()
    init {
        savedStateHandle.get<String>("category")?.let { category ->
            val id = category
            this.category = category.toLong()
            sentiments = repository.getAllRitualSentimentsByCategory(this.category)
        }
    }

    var sentimentContentField by mutableStateOf("")
        private set

    fun onSaveSentiment() {
        if (sentimentContentField.isBlank()) {
            return
        }

        viewModelScope.launch {
            val timeStamp = Util.composeTimeStamp()
            repository.insertRitualSentimentEntity(category, sentimentContentField, timeStamp, timeStamp)
        }
    }

    fun onContentChange(value:String){
        this.sentimentContentField = value
    }
}