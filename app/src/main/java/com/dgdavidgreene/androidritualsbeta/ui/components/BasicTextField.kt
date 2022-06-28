package com.dgdavidgreene.androidritualsbeta.ui.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.dgdavidgreene.androidritualsbeta.ui.theme.LocalSpacing


@Composable
fun BasicTextField(
    modifier: Modifier = Modifier,
    value: String,
    fontSize: TextUnit = 20.sp,
    onValueChange: (String) -> Unit,
    placeHolderTitle: String,
    imeAction: ImeAction = ImeAction.Next,
    onNextClick: () -> Unit = {},
    onDoneClick: () -> Unit = {}
) {
    val spacing = LocalSpacing.current
    TextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeHolderTitle,
                fontSize = fontSize
            )
        },
        textStyle = TextStyle(
            color = Color.Black,
            fontWeight = FontWeight.Medium,
            fontSize = fontSize
        ),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            disabledTextColor = Color.Transparent,
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            cursorColor = Color.White.copy(alpha = spacing.float0_5)
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = imeAction,
            keyboardType = KeyboardType.Text,
            capitalization = KeyboardCapitalization.Sentences,
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                onNextClick()
            },
            onDone = {
                onDoneClick()
            }
        )
    )
}