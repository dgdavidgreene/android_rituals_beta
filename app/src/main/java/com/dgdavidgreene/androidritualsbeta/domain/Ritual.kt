package com.dgdavidgreene.androidritualsbeta.domain

import androidx.annotation.DrawableRes
import com.dgdavidgreene.androidritualsbeta.R

enum class Ritual(val value: Int) {
    GRATITUDE(0),
    ACCEPTANCE(1),
    FORGIVENESS(2),
    AFFIRMATION(3),
    INTENTION(4);

    companion object {
        private val types = values().associateBy { it.value }

        fun findByValue(value: Int) = types[value]

        fun getPreamble(value: Int) = when (value) {
            0 -> R.string.gratitude_i_am_thankful_for
            1 -> R.string.acceptance_i_accept
            2 -> R.string.forgiveness_i_forgive
            3 -> R.string.affirmation_i_am_i_will
            4 -> R.string.intention_i_will_try
            else -> R.string.gratitude_i_am_thankful_for
        }

    }
}