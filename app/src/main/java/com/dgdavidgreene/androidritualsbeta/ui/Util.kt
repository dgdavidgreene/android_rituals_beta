package com.dgdavidgreene.androidritualsbeta.ui.theme

import androidx.compose.ui.graphics.Color
import com.dgdavidgreene.androidritualsbeta.ui.theme.*

object Util {


    fun getColorIntervals(index:Int): Color {
        return when (index % 8) {
            0 -> card9
            1 -> card2
            2 -> card3
            3 -> card4
            4 -> card5
            5 -> card6
            6 -> card7
            7 -> card8
            else -> card1
        }
    }

    fun shortestColumn(colHeights: IntArray): Int {
        var minHeight = Int.MAX_VALUE
        var column = 0
        colHeights.forEachIndexed { index, height ->
            if (height < minHeight) {
                minHeight = height
                column = index
            }
        }
        return column
    }
}