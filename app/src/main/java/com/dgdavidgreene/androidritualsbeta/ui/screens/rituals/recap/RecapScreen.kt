package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.recap

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dgdavidgreene.androidritualsbeta.R
import com.dgdavidgreene.androidritualsbeta.domain.Ritual
import com.dgdavidgreene.androidritualsbeta.ui.components.RitualSummaryPanel
import com.dgdavidgreene.androidritualsbeta.ui.components.StandardButton
import com.dgdavidgreene.androidritualsbeta.ui.components.TitleCard
import com.dgdavidgreene.androidritualsbeta.ui.navigation.Screen
import com.dgdavidgreene.androidritualsbeta.ui.theme.LocalSpacing
import com.dgdavidgreene.androidritualsbeta.ui.util.Util

@Composable
fun RecapScreen(
    navController: NavController,
    viewModel: RecapViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val sentiments = viewModel.sentiments.collectAsState(
        initial = emptyList()
    ).value

    Box(
        modifier = Modifier.fillMaxSize(),

        ) {

        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            TitleCard(title =  "Recap Screen", subTitle = "")
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {

                for (ritual in Ritual.values()) {
                    val category = ritual.ordinal
                    var sentimentList: Array<String> = arrayOf()
                    sentiments
                        .filter {
                            sentiment -> sentiment.category == category.toLong()
                        }
                        .forEach { sentiment ->
                        val item = sentiment.sentiment
                        sentimentList = sentimentList.plus(item)
                    }
                    RitualSummaryPanel(
                        modifier = Modifier,
                        text = stringResource(Ritual.getTitle(category)),
                        preamble = stringResource(Ritual.getPreamble(category)),
                        cardColor = Util.getColorIntervals(category),
                        sentiments = sentimentList,
                    )
                }
                Spacer(modifier = Modifier.height(spacing.dp64))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    StandardButton(
                        label = stringResource(id = R.string.rituals_daily),
                        widthFraction = spacing.float0_5,
                    ) {
                        navController.navigate(Screen.RitualsDailyScreen.route)
                    }
                }
            }
        }
    }
}
