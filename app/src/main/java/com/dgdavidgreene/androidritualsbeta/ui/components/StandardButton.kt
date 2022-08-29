package com.dgdavidgreene.androidritualsbeta.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dgdavidgreene.androidritualsbeta.ui.theme.LocalSpacing
import com.dgdavidgreene.androidritualsbeta.ui.theme.buttonColor
import com.dgdavidgreene.androidritualsbeta.ui.theme.white

@Composable
fun StandardButton(
    modifier: Modifier = Modifier,
    color: Color = buttonColor,
    radius: Dp = LocalSpacing.current.dp8,
    textColor: Color = white,
    contentAlignment: Alignment = Alignment.Center,
    label: String = "",
    widthFraction: Float = 1F,
    padding: Dp = 4.dp,
    onClick: () -> Unit = {}
) {
    val spacing = LocalSpacing.current
    Box(
        modifier = modifier
            .fillMaxWidth(widthFraction)
            .background(
                color = color,
                shape = RoundedCornerShape(radius)
            )
            //.width(size)
            .clickable(onClick = onClick),
        contentAlignment = contentAlignment,
    ) {
        Text(
            text = label,
            textAlign = TextAlign.Center,
            color = textColor,
            modifier = modifier
                .padding(padding)
                .fillMaxWidth()
                .align(Alignment.Center)
        )
    }
}