package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.sentiments.add


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dgdavidgreene.androidritualsbeta.ui.components.BasicTextField
import com.dgdavidgreene.androidritualsbeta.ui.components.ImageButton
import com.dgdavidgreene.androidritualsbeta.ui.theme.LocalSpacing
import com.dgdavidgreene.androidritualsbeta.ui.theme.buttonColor
import com.dgdavidgreene.androidritualsbeta.ui.theme.white

@Composable
fun AddSentimentScreen(
    navController: NavController,
    viewModel: SentimentAddViewModel = hiltViewModel()
) {

    val focusManager = LocalFocusManager.current
    val spacing = LocalSpacing.current

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(spacing.dp16),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            ImageButton(
                icon = Icons.Default.KeyboardArrowLeft
            ) {
                navController.navigateUp()
            }

            Box(
                modifier = Modifier
                    .background(
                        buttonColor,
                        shape = RoundedCornerShape(spacing.dp8)
                    )
                    .height(spacing.dp32)
                    .width(spacing.dp64)
                    .clickable(
                        onClick = {
                            viewModel.onSaveSentiment()
                            if (viewModel.SentimentContentField.isNotBlank()) {
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

        }
        Spacer(modifier = Modifier.height(spacing.dp8))
        /*BasicTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = viewModel.SentimentCategoryIdentifier.toString(),
            onValueChange = viewModel::onCategoryChange,
            imeAction = ImeAction.Next,
            fontSize = spacing.size24,
            placeHolderTitle = stringResource(com.dgdavidgreene.androidritualsbeta.R.string.Sentiment_title),
            onNextClick = { focusManager.moveFocus(FocusDirection.Down) }
        )*/
        BasicTextField(
            modifier = Modifier
                .fillMaxSize(),
            value = viewModel.SentimentContentField,
            onValueChange = viewModel::onContentChange,
            imeAction = ImeAction.None,
            placeHolderTitle = "thx"  //stringResource(com.dgdavidgreene.androidritualsbeta.R.string.Sentiment_content),
        )
        Spacer(modifier = Modifier.height(spacing.dp8))

    }


}