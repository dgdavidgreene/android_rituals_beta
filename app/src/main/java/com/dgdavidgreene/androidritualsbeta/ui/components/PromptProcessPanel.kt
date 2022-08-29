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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import com.dgdavidgreene.androidritualsbeta.domain.Ritual
import com.dgdavidgreene.androidritualsbeta.ui.theme.LocalSpacing

@Composable
fun PromptProcessPanel (
    modifier: Modifier = Modifier,
    mode: Int = 0,  // 0 prompt, 1 process
    category: Int = 0,
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
            /*.clickable(onClick =
            {  }),*/
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            //horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (mode === 0) {
                val prompt = stringResource(Ritual.getPrompt(category))
                Text(
                    text = prompt,
                    style = MaterialTheme.typography.subtitle1,
                    //fontSize = titleSize,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )


            } else {
                val process = stringResource(com.dgdavidgreene.androidritualsbeta.R.string.process)
                Text(
                    text = process,
                    style = MaterialTheme.typography.subtitle1,
                    //fontSize = titleSize,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}