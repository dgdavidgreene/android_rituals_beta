package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.suggestions

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.dgdavidgreene.androidritualsbeta.ui.theme.LocalSpacing

@Composable
fun SuggestionsPanel(
    category: Long,
    viewModel: SuggestionsViewModel = hiltViewModel()
    ) {
    val spacing = LocalSpacing.current

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

        }
    }
}