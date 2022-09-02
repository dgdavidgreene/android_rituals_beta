package com.dgdavidgreene.androidritualsbeta.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.dgdavidgreene.androidritualsbeta.ui.theme.LocalSpacing
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.dgdavidgreene.androidritualsbeta.domain.Ritual

@Composable
fun RitualCard(
    modifier: Modifier = Modifier,
    ritualCategory: Int,
    additionalInfo: String = "",
    cardColor: Color,
    onRitualClick : (Int) -> Unit = {}
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
                { onRitualClick(ritualCategory) }),
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                    Text(
                        text = stringResource(Ritual.getTitle(ritualCategory)),
                        style = MaterialTheme.typography.subtitle1,
                        fontSize = spacing.size20,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )

                    Text(
                        text = additionalInfo,
                        style = MaterialTheme.typography.subtitle1,
                        fontSize = spacing.size20,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )

            }
        }

    }