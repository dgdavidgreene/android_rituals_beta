package com.dgdavidgreene.androidritualsbeta.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import com.dgdavidgreene.androidritualsbeta.ui.theme.LocalSpacing

@Composable
fun PromptProcessPanel (
    modifier: Modifier = Modifier,
    //ritualCategory: Int,
    //additionalInfo: String = "",
    cardColor: Color,
    //onRitualClick : (Int) -> Unit = {}
    ) {
    val spacing = LocalSpacing.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(spacing.dp1)
            .background(
                shape = RoundedCornerShape(spacing.dp8),
                color = cardColor
            )
            .clickable(onClick =
            {  }),
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            //horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Test",
                style = MaterialTheme.typography.subtitle1,
                //fontSize = titleSize,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}