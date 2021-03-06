package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.sentiments.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dgdavidgreene.androidritualsbeta.R
import com.dgdavidgreene.androidritualsbeta.domain.Ritual
import com.dgdavidgreene.androidritualsbeta.ui.components.ImageButton
import com.dgdavidgreene.androidritualsbeta.ui.navigation.Screen
import com.dgdavidgreene.androidritualsbeta.ui.theme.LocalSpacing

@Composable
fun SentimentViewScreen(
    navController: NavController,
    viewModel: SentimentViewViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    viewModel.getSentimentById()
    val sentiment = viewModel.sentiment
    val createdDate = viewModel.createdAt
    val modifiedAt = viewModel.modifiedAt

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.dp8)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            ImageButton(
                icon = Icons.Default.KeyboardArrowLeft
            ) {
                navController.navigateUp()
            }

            Row {

                ImageButton(
                    icon = Icons.Default.Delete
                ) {
                    viewModel.deleteSentiment()
                    navController.navigateUp()
                }
                Spacer(modifier = Modifier.width(spacing.dp8))
                ImageButton(
                    icon = Icons.Default.Edit
                ) {
                    navController.navigate(Screen.SentimentEditScreen.route + "/${sentiment?.id}")
                }
            }


        }
        Spacer(modifier = Modifier.height(spacing.dp16))
        val category = sentiment?.category ?: 0
        val categoryLabel = stringResource(id = Ritual.getPreamble(category.toInt()))
        Text(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            text = categoryLabel,
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.W500,
            fontSize = spacing.size18,
            color = Color.Black,
        )

        val textSentiment = sentiment?.sentiment
        sentiment?.let {
            Spacer(modifier = Modifier.height(spacing.dp8))
            Text(
                text = "$textSentiment",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.W500,
                color = Color.Black,
                fontSize = spacing.size24,
            )
            Spacer(modifier = Modifier.height(spacing.dp8))
            if (!sentiment.modifiedAt.isNullOrBlank()) {
                Text(
                    text = "Modified: $modifiedAt",
                    style = MaterialTheme.typography.body2,
                    color = Color.Black.copy(spacing.float0_5)
                )
                Spacer(modifier = Modifier.height(spacing.dp8))
            }

            Text(
                text = "Created: $createdDate",
                style = MaterialTheme.typography.body2,
                color = Color.Black.copy(spacing.float0_5)
            )

        } ?: kotlin.run {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = stringResource(id = R.string.something_went_wrong))
            }
        }


    }

}