package com.dgdavidgreene.androidritualsbeta.ui.theme

import androidx.compose.ui.graphics.Color
import java.text.SimpleDateFormat
import java.util.*

object Util {

    private const val timeStampFormatString = "yyyy-MM-dd hh:mm:ss.sss"
    private const val dateDisplayFormatString = "d MMMM, yyyy"

    private fun composeDateTimeStringUS(inputDate: Date): String {
        val sdf = SimpleDateFormat(timeStampFormatString, Locale.US)

        return sdf.format(inputDate)
    }

    private fun convertDateTimeStringUStoDate(dateTimeString: String): Date {
        val sdf = SimpleDateFormat(timeStampFormatString, Locale.US)

        return sdf.parse(dateTimeString)
    }

    fun formatDateMonthDefault(dateTimeString: String): String {
        val inputDate = convertDateTimeStringUStoDate(dateTimeString)
        val sdf = SimpleDateFormat(dateDisplayFormatString, Locale.getDefault())

        return sdf.format(inputDate)
    }

    fun composeTimeStamp(): String {
        val date = Date()

        return composeDateTimeStringUS(date)
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