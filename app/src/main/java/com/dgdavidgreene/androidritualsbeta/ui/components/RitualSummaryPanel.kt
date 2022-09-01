package com.dgdavidgreene.androidritualsbeta.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.dgdavidgreene.androidritualsbeta.ui.theme.LocalSpacing

@Composable
fun RitualSummaryPanel(
    modifier: Modifier = Modifier,
    cardColor: Color,
    text: String,
    textSize: TextUnit = com.dgdavidgreene.androidritualsbeta.ui.theme.LocalSpacing.current.size20,
    preamble: String,
    preambleSize: TextUnit = com.dgdavidgreene.androidritualsbeta.ui.theme.LocalSpacing.current.size12,
    listSize: TextUnit = com.dgdavidgreene.androidritualsbeta.ui.theme.LocalSpacing.current.size14,
    sentiments: Array<String>,
) {
    val spacing = LocalSpacing.current


    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color = cardColor, shape = RoundedCornerShape(spacing.dp8))
    ) {
        Column() {
            var count = 0
            var list = ""
            sentiments.forEach { sentiment ->
                count += 1
                if (count > 1) {
                    list = "$list, $sentiment"
                } else {
                    list = "$sentiment"
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp)
                ,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${text}",
                    style = MaterialTheme.typography.subtitle1,
                    fontSize = textSize,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "${count}",
                    style = MaterialTheme.typography.subtitle1,
                    fontSize = textSize,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            /*Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 6.dp),
                //horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${preamble}",
                    style = MaterialTheme.typography.subtitle1,
                    fontSize = preambleSize,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }*/
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp),
                //horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "${preamble} ${list}",
                    style = MaterialTheme.typography.subtitle1,
                    fontSize = listSize,
                    maxLines = 6,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Spacer(modifier = Modifier.height(spacing.dp12))
        }
    }
    Spacer(modifier = Modifier.height(spacing.dp5))
}