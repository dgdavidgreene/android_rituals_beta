package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.ritual

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dgdavidgreene.androidritualsbeta.R
import com.dgdavidgreene.androidritualsbeta.domain.Ritual
import com.dgdavidgreene.androidritualsbeta.ui.components.*
import com.dgdavidgreene.androidritualsbeta.ui.navigation.Screen
import com.dgdavidgreene.androidritualsbeta.ui.theme.*
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList

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
        val title = stringResource(Ritual.getTitle(category))
        TitleCard(title = title, subTitle = "", titleSize = spacing.size32, subTitleSize = spacing.size16)
        Spacer(modifier = Modifier.height(spacing.dp12))
        BasicTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = viewModel.sentimentContentField,
            onValueChange = viewModel::onContentChange,
            imeAction = ImeAction.None,
            placeHolderTitle = stringResource(id = R.string.gratitude_i_am_grateful_for),
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
                        if (viewModel.sentimentContentField.isNotBlank()) {
                            navController.navigateUp()
                        }
                    }
                ),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = stringResource(id = com.dgdavidgreene.androidritualsbeta.R.string.save),
                color = white,
                style = MaterialTheme.typography.button
            )

        }


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            StaggeredVerticalGrid(
                maxColumnWidth = spacing.dp220,
                modifier = Modifier.padding(spacing.dp4)
            ) {
                sentiments.forEachIndexed { index, sentiment ->
                    val color = Util.getColorIntervals(index)
                    SentimentCard(
                        modifier = Modifier.padding(spacing.dp0),
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
    ImageButton(
       modifier = Modifier
           .align(Alignment.BottomStart)
           .padding(spacing.dp4),
        icon = Icons.Default.KeyboardArrowLeft
    ) {
        navController.navigateUp()
    }
    ImageButton(
        modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(spacing.dp4),
        icon = Icons.Default.KeyboardArrowRight
    ) {
        navController.navigateUp()
    }
}
}