package com.dgdavidgreene.androidritualsbeta.domain

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed class StringHandler {
    data class DynamicString(val value: String) : StringHandler()
    class StringResource(
        @StringRes val id: Int,
        val args: Array<Any> = emptyArray()
    ) : StringHandler()

    @Composable
    fun asString(): String {
        return when(this) {
            is DynamicString -> value
            is StringResource -> stringResource(id, args)
        }
    }
}