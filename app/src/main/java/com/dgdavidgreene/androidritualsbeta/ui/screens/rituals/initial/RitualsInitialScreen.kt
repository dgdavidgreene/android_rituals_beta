package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.initial

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
import com.dgdavidgreene.androidritualsbeta.ui.components.ImageButton
import com.dgdavidgreene.androidritualsbeta.ui.components.SentimentCard
import com.dgdavidgreene.androidritualsbeta.ui.components.StaggeredVerticalGrid
import com.dgdavidgreene.androidritualsbeta.ui.navigation.Screen
import com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.sentiments.list.SentimentListViewModel
import com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.sentiments.view.SentimentViewViewModel
import com.dgdavidgreene.androidritualsbeta.ui.theme.LocalSpacing
import com.dgdavidgreene.androidritualsbeta.ui.theme.Util
import com.dgdavidgreene.androidritualsbeta.ui.theme.black
import com.dgdavidgreene.androidritualsbeta.ui.theme.white


@Composable
fun RitualsInitialScreen(
    navController: NavController,
    viewModel: SentimentListViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val sentiments = viewModel.sentiments.collectAsState(
        initial = emptyList()
    ).value
    sentiments.sortedByDescending { it.modifiedAt }

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
                    text = stringResource(id = R.string.gratitude),
                    color = black,
                    style = MaterialTheme.typography.h4
                )

                ImageButton(
                    icon = Icons.Outlined.Search,
                    onClick = {
                        navController.navigate(Screen.SentimentListScreen.route)
                    }
                )
            }

            if (sentiments.isNullOrEmpty()) {

                EmptyRituals {
                    navController.navigate(Screen.SentimentAddScreen.route)
                }

            } else {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {

                    StaggeredVerticalGrid(
                        maxColumnWidth = spacing.dp220,
                        modifier = Modifier.padding(spacing.dp8)
                    ) {

                        sentiments.forEachIndexed { index, sentiment ->
                            val color = Util.getColorIntervals(index)
                            SentimentCard(
                                modifier = Modifier.padding(),
                                ritualSentimentEntity = sentiment,
                                cardColor = color,
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

@Composable
fun EmptyRituals(
    onClick : () -> Unit
) {
    val spacing = LocalSpacing.current
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .clickable(
                    onClick = onClick
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .size(spacing.dp75)
                    .alpha(spacing.float0_5),
                painter = painterResource(id = R.drawable.ic_praying_hands_solid_svgrepo_com),
                contentDescription = "Logo",
            )
            Spacer(modifier = Modifier.height(spacing.dp12))

            Text(
                text = stringResource(id = R.string.looks_like_empty),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = white.copy(spacing.float0_4),
                    //fontFamily = Helvetica,
                    fontSize = spacing.size16
                )
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = stringResource(id = R.string.add_sentiments),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = white.copy(spacing.float0_4),
                    fontSize = spacing.size20
                )
            )
        }

    }
}