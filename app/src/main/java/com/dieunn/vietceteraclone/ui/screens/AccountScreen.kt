package com.dieunn.vietceteraclone.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dieunn.vietceteraclone.R
import com.dieunn.vietceteraclone.ui.theme.GelionFontFamily

@Composable
fun AccountScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(state = rememberScrollState(), orientation = Orientation.Vertical)
            .padding(top = 8.dp, start = 16.dp, end = 8.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(
                text = "Liên hệ",
                fontFamily = GelionFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        AccountMenuItem(icon = R.drawable.ic_outline_home_24, text = "Về chúng tôi")
        AccountMenuItem(icon = R.drawable.ic_outline_check_24, text = "Điều khoản sử dụng")
        AccountMenuItem(icon = R.drawable.ic_outline_book_24, text = "Chính sách bảo mật")
        AccountMenuItem(icon = R.drawable.ic_outline_mail_24, text = "Góp ý ứng dụng")
        AccountMenuItem(icon = R.drawable.ic_outline_local_phone_24, text = "Liên hệ")
        Divider(modifier = Modifier.fillMaxWidth())
        Text(text = "Sản phẩm dùng cho vui, không có mục đích thương mại")
        Text(text = "Các chức năng khác ngoài đọc báo chưa thể thực hiện được, sẽ làm sau")

    }
}

@Composable
fun AccountMenuItem(icon: Int, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(id = icon), contentDescription = null)
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            fontFamily = GelionFontFamily,
            fontSize = 22.sp
        )

    }
}
