package com.dieunn.vietceteraclone.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dieunn.vietceteraclone.R
import com.dieunn.vietceteraclone.ui.theme.GelionFontFamily

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ReligionChooser(
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .wrapContentSize(align = Alignment.Center)
            .defaultMinSize(minWidth = 54.dp),
        onClick = onClick,
        border = BorderStroke(1.dp, Color.Gray),
        shape = RoundedCornerShape(70),
        elevation = 0.dp,
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(1.dp)
        ) {
            Text(text = "VN", fontFamily = GelionFontFamily, fontWeight = FontWeight.Thin)
            Spacer(modifier = Modifier.width(1.dp))
            Image(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = null,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReligionChooserPrev() {
    ReligionChooser(
        onClick = {}
    )
}