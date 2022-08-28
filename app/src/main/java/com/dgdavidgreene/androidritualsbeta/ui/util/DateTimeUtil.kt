package com.dgdavidgreene.androidritualsbeta.ui.util

import androidx.compose.ui.graphics.Color
import com.dgdavidgreene.androidritualsbeta.ui.theme.*
import java.text.SimpleDateFormat
import java.util.*

object DateTimeUtil {
        private const val timeStampFormatString = "yyyy-MM-dd HH:mm:ss.sss"
        private const val dateDisplayFormatString = "MMMM d, yyyy"
        private const val dateTimeFormatString = "MMMM d, HH:mm:ss"

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

        fun formatDateTimeDefault(dateTimeString: String): String {
            val inputDate = convertDateTimeStringUStoDate(dateTimeString)
            val sdf = SimpleDateFormat(dateTimeFormatString, Locale.getDefault())

            return sdf.format(inputDate)
        }

        fun composeTimeStamp(): String {
            val date = Date()

            return composeDateTimeStringUS(date)
        }

        fun getTodayString(): String {
            return composeTimeStamp().substring(0, 10)
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