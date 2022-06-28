package com.dgdavidgreene.androidritualsbeta.ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dgdavidgreene.androidritualsbeta.ui.theme.LocalSpacing
import com.dgdavidgreene.androidritualsbeta.ui.theme.buttonColor
import com.dgdavidgreene.androidritualsbeta.ui.theme.white

@Composable
fun ImageButton(
    modifier: Modifier=Modifier,
    color: Color = buttonColor,
    iconColor:Color = white,
    icon: ImageVector,
    size: Dp = 40.dp,
    iconSize:Dp = 28.dp,
    onClick: () -> Unit = {}
) {
    val spacing = LocalSpacing.current
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .background(
                    color,
                    shape = RoundedCornerShape(spacing.dp8)
                )
                .size(size)
                .clickable(onClick = onClick)

        )
        Icon(
            imageVector = icon,
            tint= iconColor,
            contentDescription = null,
            modifier = Modifier.padding(spacing.dp4)
                .size(iconSize)
        )
    }

}