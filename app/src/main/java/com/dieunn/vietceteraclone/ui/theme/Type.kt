package com.dieunn.vietceteraclone.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dieunn.vietceteraclone.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

val GelionFontFamily = FontFamily(
    Font(R.font.gelion_light, FontWeight.Light),
    Font(R.font.gelion_black, FontWeight.Black),
    Font(R.font.gelion_black_italic, FontWeight.Black, FontStyle.Italic),
    Font(R.font.gelion_bold, FontWeight.Bold),
    Font(R.font.gelion_regular),
    Font(R.font.gelion_semibold, FontWeight.SemiBold),
    Font(R.font.gelion_thin, FontWeight.Thin),
)