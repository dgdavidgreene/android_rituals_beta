package com.dgdavidgreene.androidritualsbeta.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.isUnspecified
import com.dgdavidgreene.androidritualsbeta.ui.theme.LocalSpacing

@Composable
fun TitleCard(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String,
    titleSize: TextUnit = com.dgdavidgreene.androidritualsbeta.ui.theme.LocalSpacing.current.size32,
    subTitleSize: TextUnit = com.dgdavidgreene.androidritualsbeta.ui.theme.LocalSpacing.current.size24,
    padding: Dp = com.dgdavidgreene.androidritualsbeta.ui.theme.LocalSpacing.current.dp8,
    //cardColor: Color,
    //onRitualClick : (String) -> Unit = {}
) {
    val spacing = LocalSpacing.current


    Box(
        modifier = modifier
            .fillMaxWidth()
            /*.padding(spacing.dp1)
            .background(
                cardColor,
                shape = RoundedCornerShape(spacing.dp8)
            )
            .clickable(onClick =
            { onRitualClick(ritualCategory) }),*/
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp)
        ) {

            Text(
                text = "${title}",
                style = MaterialTheme.typography.subtitle1,
                fontSize = titleSize,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            if (subTitle.isNullOrBlank()) {

            } else {
                Spacer(modifier = Modifier.width(spacing.dp4))
                Text(
                    text = "${subTitle}",
                    style = MaterialTheme.typography.subtitle2,
                    fontSize = subTitleSize,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

            }
        }
    }

}