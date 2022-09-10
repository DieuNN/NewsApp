package com.dieunn.vietceteraclone.ui.components

import android.app.Application
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.dieunn.vietceteraclone.ApiInstance
import com.dieunn.vietceteraclone.R
import com.dieunn.vietceteraclone.models.Article
import com.dieunn.vietceteraclone.models.News
import com.dieunn.vietceteraclone.models.Source
import com.dieunn.vietceteraclone.ui.theme.GelionFontFamily
import com.dieunn.vietceteraclone.viewmodels.AppViewModel
import kotlinx.coroutines.launch
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun NewsItem(article: Article, navController: NavController) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        AsyncImage(
            model = article.urlToImage,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    val linkEncoded =
                        URLEncoder.encode(article.url, StandardCharsets.UTF_8.toString())
                    navController.navigate("detail/$linkEncoded")
                })
        Spacer(modifier = Modifier.height(8.dp))
        article.title?.let {
            Text(
                text = it,
                fontFamily = GelionFontFamily,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        article.content?.let {
            Text(
                text = it,
                fontFamily = GelionFontFamily,
                fontWeight = FontWeight.Normal
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                article.author?.let {
                    Text(
                        text = it,
                        color = Color.Gray,
                        fontFamily = GelionFontFamily,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.width(3.dp))
                Text(text = "·", fontFamily = GelionFontFamily)
                Spacer(modifier = Modifier.width(3.dp))
                article.source?.name?.let {
                    Text(
                        text = it,
                        fontFamily = GelionFontFamily,
                        fontWeight = FontWeight.Light
                    )
                }
            }
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_bookmark_border_24),
                    contentDescription = null,
                    Modifier.clickable {
//                        val appViewModel = AppViewModel(application = context.applicationContext as Application)
//                        val insertResult = appViewModel.addNews(article)
//
//                        if (insertResult) {
//                            Toast.makeText(context, "News added to favorite", Toast.LENGTH_SHORT).show()
//                        } else {
//                            Toast.makeText(context, "News already exist!", Toast.LENGTH_SHORT).show()
//                        }
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Divider(Modifier.fillMaxWidth())
    }
}

