package com.dgdavidgreene.androidritualsbeta.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Dimension(
    val dp0: Dp = 0.dp,
    val dp1: Dp = 1.dp,
    val dp4: Dp = 4.dp,
    val dp8: Dp = 8.dp,
    val dp16: Dp = 16.dp,
    val dp32: Dp = 32.dp,
    val dp64: Dp = 64.dp,
    val dp220: Dp = 220.dp,

    val size1: TextUnit = 1.sp,
    val size4: TextUnit = 4.sp,
    val size8: TextUnit = 8.sp,
    val size12: TextUnit = 12.sp,
    val size14: TextUnit = 14.sp,
    val size16: TextUnit = 16.sp,
    val size18: TextUnit = 18.sp,
    val size20: TextUnit = 20.sp,
    val size24: TextUnit = 24.sp,

    val float0: Float = 0f,
    val float0_4: Float = 0.4f,
    val float0_5: Float = 0.5f,
    val float2: Float = 2f,
    val float5: Float = 5f,
)

val LocalSpacing = compositionLocalOf { Dimension() }
