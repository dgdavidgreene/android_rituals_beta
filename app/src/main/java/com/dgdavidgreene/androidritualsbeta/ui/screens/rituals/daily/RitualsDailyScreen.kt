package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.daily

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
import com.dgdavidgreene.androidritualsbeta.ui.components.*
import com.dgdavidgreene.androidritualsbeta.ui.navigation.Screen
import com.dgdavidgreene.androidritualsbeta.ui.theme.LocalSpacing
import com.dgdavidgreene.androidritualsbeta.ui.util.Util.getColorIntervals

@Composable
fun RitualsDailyScreen(
    navController: NavController,
    viewModel: RitualsDailyViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val sentimentCounts = viewModel.sentimentCounts.collectAsState(
        initial = emptyList()
    ).value

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            TitleCard(title =  stringResource(id = R.string.rituals_daily), subTitle = "")
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                for (ritual in Ritual.values()) {
                    val category = ritual.ordinal.toInt()
                    //val categoryCount = sentimentCounts[category]

                    RitualCard(
                        modifier = Modifier,
                        ritualCategory = category,
                        additionalInfo = category.toString(),
                        cardColor = getColorIntervals(category),
                        //onRitualClick = {}
                    ) {
                        navController.navigate(Screen.RitualScreen.route + "/${category}")
                    }
                }
            }
        }
    }
}
