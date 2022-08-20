package com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.ritual

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dgdavidgreene.androidritualsbeta.R
import com.dgdavidgreene.androidritualsbeta.ui.components.ImageButton
import com.dgdavidgreene.androidritualsbeta.ui.components.TitleCard
import com.dgdavidgreene.androidritualsbeta.ui.theme.LocalSpacing
import com.dgdavidgreene.androidritualsbeta.ui.theme.black

@Composable
fun RitualScreen(
    navController: NavController,
    viewModel: RitualViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(spacing.dp8)
        ) {
            TitleCard(title = "Title", subTitle = "sub title here", titleSize = spacing.size32, subTitleSize = spacing.size16)
            Spacer(modifier = Modifier.height(spacing.dp12))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = viewModel.category.toString(), // stringResource(id = R.string.gratitude_i_am_grateful_for),
                    color = black,
                    style = MaterialTheme.typography.h4
                )
            }
            Spacer(modifier = Modifier.height(spacing.dp12))


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