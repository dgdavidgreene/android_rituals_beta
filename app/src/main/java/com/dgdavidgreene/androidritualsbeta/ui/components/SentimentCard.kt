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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import appdb.RitualSentimentEntity
import com.dgdavidgreene.androidritualsbeta.domain.Ritual
import com.dgdavidgreene.androidritualsbeta.ui.theme.LocalSpacing

@Composable
    fun SentimentCard(
    modifier: Modifier = Modifier,
    ritualSentimentEntity: RitualSentimentEntity,
    cardColor: Color,
    onRitualSentimentClick : (RitualSentimentEntity) -> Unit = {}
    ) {
    val spacing = LocalSpacing.current
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(spacing.dp1)
                .background(
                    cardColor,
                    shape = RoundedCornerShape(spacing.dp8)
                )
                .clickable(onClick =
                { onRitualSentimentClick(ritualSentimentEntity) }),
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
            ) {

                Text(
                    text = "${ritualSentimentEntity.sentiment}",
                    style = MaterialTheme.typography.subtitle1,
                    fontSize = spacing.size20,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }