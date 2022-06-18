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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import appdb.RitualSentimentEntity

@Composable
    fun ListCard(
    modifier: Modifier = Modifier,
    ritualSentimentEntity: RitualSentimentEntity,
    cardColor: Color,
    onRitualSentimentClick : (RitualSentimentEntity) -> Unit = {}
    ) {

        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(4.dp)
                .background(
                    cardColor,
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable(onClick = { onRitualSentimentClick(ritualSentimentEntity) }),
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
            ) {

                Text(
                    text = ritualSentimentEntity.sentiment,
                    style = MaterialTheme.typography.subtitle1,
                    fontSize = 16.sp,
                    maxLines = 6,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }


    }