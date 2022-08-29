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
import com.dgdavidgreene.androidritualsbeta.domain.CategoryCount
import com.dgdavidgreene.androidritualsbeta.domain.Ritual
import com.dgdavidgreene.androidritualsbeta.ui.components.RitualCard
import com.dgdavidgreene.androidritualsbeta.ui.components.StandardButton
import com.dgdavidgreene.androidritualsbeta.ui.components.TitleCard
import com.dgdavidgreene.androidritualsbeta.ui.navigation.Screen
import com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.daily.RitualsDailyViewModel
import com.dgdavidgreene.androidritualsbeta.ui.theme.LocalSpacing
import com.dgdavidgreene.androidritualsbeta.ui.util.Util

@Composable
fun RecapScreen(
    navController: NavController,
    viewModel: RecapViewModel = hiltViewModel()
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
            TitleCard(title =  "Recap Screen", subTitle = "")
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                var countsByCategory: ArrayList<CategoryCount> = arrayListOf()
                sentimentCounts.forEach { sentimentCount ->
                    var categoryCount = CategoryCount()
                    categoryCount.category = sentimentCount.category
                    categoryCount.count = sentimentCount.COUNT
                    countsByCategory.add(categoryCount)
                }
                for (ritual in Ritual.values()) {
                    val category = ritual.ordinal.toInt()
                    var categoryCount = 0L
                    val sentimentCount = countsByCategory.find { sentiment -> sentiment.category.toInt() === category }
                    if (sentimentCount != null) {
                        categoryCount = sentimentCount.count
                    }
                    RitualCard(
                        modifier = Modifier,
                        ritualCategory = category,
                        additionalInfo = categoryCount.toString(),
                        cardColor = Util.getColorIntervals(category),
                        //onRitualClick = {}
                    ) {
                        navController.navigate(Screen.RitualScreen.route + "/${category}")
                    }
                }
                Spacer(modifier = Modifier.height(spacing.dp64))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    StandardButton(
                        label = stringResource(id = R.string.recap),
                        widthFraction = spacing.float0_5,
                    ) {
                        navController.navigate(Screen.RitualsInitialScreen.route)
                    }
                }
            }
        }
    }
}
