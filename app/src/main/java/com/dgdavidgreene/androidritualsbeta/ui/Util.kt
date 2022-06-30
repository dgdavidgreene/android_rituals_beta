package com.dgdavidgreene.androidritualsbeta.ui.theme

import androidx.compose.ui.graphics.Color
import com.dgdavidgreene.androidritualsbeta.ui.theme.*
import java.text.SimpleDateFormat
import java.util.*

object Util {
    fun getCurrentTime() : String{
        val date = Date()
        // "yyMMddHHmmssZ"
        val sdf = SimpleDateFormat("dd MMMM, yyyy", Locale.getDefault())
        return sdf.format(date)
    }

    fun formatTime(dateString: String) : String{
        val inputFormat = SimpleDateFormat("dd MMMM, yyyy", Locale.US)
        val dateDate: Date = inputFormat.parse(dateString) // You got Date object of 2020 jul 7
        val outputFormat = SimpleDateFormat("MMMM d, yyyy", Locale.US)
        println(outputFormat.format(dateDate)) //it prints "2020-07-07"
        return outputFormat.format(dateDate)
        /*val date = Date(dateString)
        val sdf = SimpleDateFormat("dd MMMM, yyyy", Locale.getDefault())
        return sdf.format(date)*/
    }

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