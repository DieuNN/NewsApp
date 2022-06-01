package com.dieunn.vietceteraclone.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.dieunn.vietceteraclone.ApiInstance
import com.dieunn.vietceteraclone.models.Article
import com.dieunn.vietceteraclone.ui.components.NewsItem
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppleNewsTabsScreen(navController: NavController) {
    val scope = rememberCoroutineScope()
    val articleList = remember {
        mutableStateOf(emptyList<Article>())
    }
    SideEffect {
        scope.launch {
            articleList.value = try {
                ApiInstance.api.getAppleNews().articles!!
            } catch (e:Exception) {
                emptyList()
            }
        }
    }
    LazyColumn {
        items(articleList.value.size) { index->
            NewsItem(article = articleList.value[index], navController=navController)
        }
    }
}