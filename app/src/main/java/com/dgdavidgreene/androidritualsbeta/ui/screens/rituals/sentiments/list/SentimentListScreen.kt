package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.sentiments.list

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dgdavidgreene.androidritualsbeta.ui.components.ImageButton
import com.dgdavidgreene.androidritualsbeta.ui.components.SentimentCard
import com.dgdavidgreene.androidritualsbeta.ui.components.StaggeredVerticalGrid
import com.dgdavidgreene.androidritualsbeta.ui.navigation.Screen
import com.dgdavidgreene.androidritualsbeta.ui.theme.LocalSpacing
import com.dgdavidgreene.androidritualsbeta.ui.theme.Util.getColorIntervals
import com.dgdavidgreene.androidritualsbeta.ui.theme.white
import appdb.RitualSentimentEntity

@Composable
fun SentimentListScreen(
    navController: NavController,
    viewModel: SentimentListViewModel = hiltViewModel()
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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 12.dp,
                        end = 12.dp,
                        top = 12.dp,
                        bottom = 8.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Notes",
                    color = white,
                    style = MaterialTheme.typography.h4
                )

                ImageButton(
                    icon = Icons.Outlined.Search,
                    onClick = {
                        navController.navigate(Screen.SplashScreen.route)
                    }
                )
            }

            if (sentiments.isNullOrEmpty()) {

                EmptySentiments {
                    navController.navigate(Screen.SplashScreen.route)
                }

            } else {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {

                    StaggeredVerticalGrid(
                        maxColumnWidth = 220.dp,
                        modifier = Modifier.padding(8.dp)
                    ) {

                        sentiments.forEachIndexed { index, sentiment ->
                            val color = getColorIntervals(index, sentiments.size)
                            SentimentCard(
                                modifier = Modifier.padding(),
                                ritualSentimentEntity = sentiment,
                                cardColor = color,
                                //onRitualSentimentClick = {}
                            ) /*{

                                navController.navigate(Screen.SplashScreen.route + "/${sentiment.id}")

                            }*/
                        }
                    }
                }
            }


        }
        ImageButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(12.dp),
            size = 64.dp,
            icon = Icons.Outlined.Add,
            onClick = {
                navController.navigate(Screen.SplashScreen.route)
            }
        )
    }
}

@Composable
fun EmptySentiments(
    onClick : () -> Unit
) {
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
                    .size(75.dp)
                    .alpha(0.5F),
                painter = painterResource(id = com.dgdavidgreene.androidritualsbeta.R.drawable.ic_praying_hands_solid_svgrepo_com),
                contentDescription = "Logo",
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Hmm...Looks like it's empty here!!",
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = white.copy(0.4F),
                    //fontFamily = Helvetica,
                    fontSize = 16.sp
                )
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "ADD SentimentS",
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = white.copy(0.4F),
                    //fontFamily = Helvetica,
                    fontSize = 20.sp
                )
            )
        }

    }
}