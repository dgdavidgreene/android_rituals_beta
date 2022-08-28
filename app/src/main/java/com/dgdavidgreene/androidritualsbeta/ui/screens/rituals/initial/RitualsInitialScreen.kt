package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.initial

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dgdavidgreene.androidritualsbeta.R
import com.dgdavidgreene.androidritualsbeta.ui.components.ImageButton
import com.dgdavidgreene.androidritualsbeta.ui.navigation.Screen
import com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.sentiments.list.SentimentListViewModel
import com.dgdavidgreene.androidritualsbeta.ui.theme.LocalSpacing
import com.dgdavidgreene.androidritualsbeta.ui.theme.black


@Composable
fun RitualsInitialScreen(
    navController: NavController,
    viewModel: SentimentListViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    /*val sentiments = viewModel.sentiments.collectAsState(
        initial = emptyList()
    ).value*/
    //sentiments.sortedByDescending { it.modifiedAt }

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = spacing.dp12,
                        end = spacing.dp12,
                        top = spacing.dp12,
                        bottom = spacing.dp8
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = stringResource(id = R.string.rituals_initial),
                    color = black,
                    style = MaterialTheme.typography.h4
                )
            }

            // if (!sentiments.isNullOrEmpty()) {
                // navController.navigate(Screen.RitualsDailyScreen.route)
            // } else {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {

                    /*StaggeredVerticalGrid(
                        maxColumnWidth = spacing.dp220,
                        modifier = Modifier.padding(spacing.dp8)
                    ) {
                    }*/
                //}
            }


        }
        ImageButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(spacing.dp12),
            size = spacing.dp64,
            icon = Icons.Outlined.Add,
            onClick = {
                navController.navigate(Screen.SentimentAddScreen.route)
            }
        )
    }
}
