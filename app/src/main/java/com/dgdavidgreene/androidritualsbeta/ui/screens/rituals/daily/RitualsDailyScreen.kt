package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.daily

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dgdavidgreene.androidritualsbeta.R
import com.dgdavidgreene.androidritualsbeta.domain.Ritual
import com.dgdavidgreene.androidritualsbeta.ui.components.*
import com.dgdavidgreene.androidritualsbeta.ui.navigation.Screen
import com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.sentiments.list.SentimentListViewModel
import com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.sentiments.view.SentimentViewViewModel
import com.dgdavidgreene.androidritualsbeta.ui.theme.LocalSpacing
import com.dgdavidgreene.androidritualsbeta.ui.theme.Util
import com.dgdavidgreene.androidritualsbeta.ui.theme.black
import com.dgdavidgreene.androidritualsbeta.ui.theme.white
import com.dgdavidgreene.androidritualsbeta.ui.theme.Util.getColorIntervals
import kotlinx.coroutines.flow.toCollection

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
