package com.dgdavidgreene.androidritualsbeta.domain

import com.dgdavidgreene.androidritualsbeta.R

enum class Ritual(val value: Int) {
    GRATITUDE(0),
    ACCEPTANCE(1),
    FORGIVENESS(2),
    AFFIRMATION(3),
    INTENTION(4),
    WINS(5);

    companion object {
        private val types = values().associateBy { it.value }

        fun findByValue(value: Int) = types[value]

        fun getPreamble(value: Int?) = when (value) {
            0 -> R.string.gratitude_preamble
            1 -> R.string.acceptance_preamble
            2 -> R.string.forgiveness_preamble
            3 -> R.string.affirmation_preamble
            4 -> R.string.intention_preamble
            5 -> R.string.wins_preamble
            else -> R.string.gratitude_preamble
        }

        fun getPrompt(value: Int?) = when (value) {
            0 -> R.string.gratitude_prompt
            1 -> R.string.acceptance_prompt
            2 -> R.string.forgiveness_prompt
            3 -> R.string.affirmation_prompt
            4 -> R.string.intention_prompt
            5 -> R.string.wins_prompt
            else -> R.string.gratitude_prompt
        }
        fun getTitle(value: Int?) = when (value) {
            0 -> R.string.gratitude
            1 -> R.string.acceptance
            2 -> R.string.forgiveness
            3 -> R.string.affirmation
            4 -> R.string.intention
            5 -> R.string.wins
            else -> R.string.gratitude
        }
    }
}