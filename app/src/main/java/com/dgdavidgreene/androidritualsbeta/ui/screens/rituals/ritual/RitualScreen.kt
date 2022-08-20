package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.ritual

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dgdavidgreene.androidritualsbeta.R
import com.dgdavidgreene.androidritualsbeta.ui.theme.black

@Composable
fun RitualScreen(
    navController: NavController,
    viewModel: RitualViewModel = hiltViewModel()
) {
    Text(
        text = viewModel.category.toString(), // stringResource(id = R.string.gratitude_i_am_grateful_for),
        color = black,
        style = MaterialTheme.typography.h4
    )
}