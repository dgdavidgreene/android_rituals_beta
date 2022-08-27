package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.ritual

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dgdavidgreene.androidritualsbeta.domain.Ritual
import com.dgdavidgreene.androidritualsbeta.ui.components.*
import com.dgdavidgreene.androidritualsbeta.ui.navigation.Screen
import com.dgdavidgreene.androidritualsbeta.ui.theme.*
import com.dgdavidgreene.androidritualsbeta.ui.theme.Util.composeTimeStamp
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun RitualScreen(
    navController: NavController,
    viewModel: RitualViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val category = viewModel.category
    val sentiments = viewModel.sentiments.collectAsState(
        initial = emptyList()
    ).value
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val title = stringResource(Ritual.getTitle(category.toInt()))
            TitleCard(title = title, subTitle = "", titleSize = spacing.size32, subTitleSize = spacing.size16)
            Spacer(modifier = Modifier.height(spacing.dp12))
            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = viewModel.sentimentContentField,
                onValueChange = viewModel::onContentChange,
                imeAction = ImeAction.None,
                placeHolderTitle = stringResource(Ritual.getPreamble(category.toInt())),
            )

            Box(
                modifier = Modifier
                    .background(
                        buttonColor,
                        shape = RoundedCornerShape(spacing.dp8)
                    )
                    .height(spacing.dp32)
                    .fillMaxWidth(spacing.float0_5)
                    .align(Alignment.CenterHorizontally)
                    .clickable(
                        onClick = {
                            viewModel.onSaveSentiment()

                        }
                    ),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = stringResource(id = com.dgdavidgreene.androidritualsbeta.R.string.add),
                    color = white,
                    style = MaterialTheme.typography.button
                )

            }


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (sentiments.isNullOrEmpty()) {

                } else {
                    StaggeredVerticalGrid(
                    maxColumnWidth = spacing.dp240,
                    modifier = Modifier.padding(spacing.dp4)
                ) {
                    sentiments.forEachIndexed { index, sentiment ->
                        val color = Util.getColorIntervals(index)
                        SentimentCard(
                            modifier = Modifier.padding(spacing.dp0),
                            ritualSentimentEntity = sentiment,
                            cardColor = color,
                            fontSize = spacing.size16,
                            padding = spacing.dp12,
                            //onRitualSentimentClick = {}
                        ) {

                            navController.navigate(Screen.SentimentViewScreen.route + "/${sentiment.id}")

                        }
                    }
                }
                }
            }

        }
        ImageButton(
           modifier = Modifier
               .align(Alignment.BottomStart)
               .padding(spacing.dp4),
            icon = Icons.Default.KeyboardArrowLeft
        ) {
            var prior = category - 1
            if (prior < 0L) {
                navController.navigate(Screen.RitualsDailyScreen.route)
            } else {
                navController.navigate(Screen.RitualScreen.route + "/${prior}")
            }
        }
        Button(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            onClick = {navController.navigate(Screen.RitualsDailyScreen.route)},
            content = {
                Text(
                    modifier = Modifier.width(spacing.dp220),
                    textAlign = TextAlign.Center,
                    fontSize = spacing.size16,
                    text = stringResource(id = com.dgdavidgreene.androidritualsbeta.R.string.rituals_daily))},
        )
        ImageButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(spacing.dp4),
            icon = Icons.Default.KeyboardArrowRight
        ) {
            val max = Ritual.values().size - 1
            var next = category + 1
            if (next > max) {
                navController.navigate(Screen.RitualsDailyScreen.route)
            } else {
                navController.navigate(Screen.RitualScreen.route + "/${next}")
            }

        }
    }
}