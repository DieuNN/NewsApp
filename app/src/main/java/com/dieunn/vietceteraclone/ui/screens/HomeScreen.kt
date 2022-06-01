package com.dieunn.vietceteraclone.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.dieunn.vietceteraclone.ui.components.HeaderBar
import com.dieunn.vietceteraclone.ui.components.TabScreen
import com.dieunn.vietceteraclone.ui.components.Tabs
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(navController: NavController) {
    Column {
        HeaderBar()
        TabScreen(pagerState = rememberPagerState(pageCount = 5), navController=navController)
    }
}
