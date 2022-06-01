package com.dieunn.vietceteraclone.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dieunn.vietceteraclone.ui.screens.*
import com.dieunn.vietceteraclone.ui.theme.GelionFontFamily
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabScreen(pagerState: PagerState, navController: NavController) {
    Column {
        Tabs(pagerState = pagerState)
        TabsContent(pagerState = pagerState, navController = navController)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(pagerState: PagerState) {
    val tabList = listOf<String>("APPLE", "TESLA", "US", "TECH CRUNCH", " WALL STREET JOURNAL")
    val scope = rememberCoroutineScope()
    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.White,
        contentColor = Color.White,
        divider = {
            TabRowDefaults.Divider()
        },
        indicator = {
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, it),
                height = 2.dp,
                color = Color.Black
            )
        },
        edgePadding = 8.dp
    ) {
        tabList.forEachIndexed { index, _ ->
            Tab(
                text =
                {
                    Text(
                        text = tabList[index],
                        color = if (pagerState.currentPage == index) Color.Black else Color.Gray,
                        fontFamily = GelionFontFamily,

                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                })
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(pagerState: PagerState, navController: NavController) {
    HorizontalPager(state = pagerState) { page ->
        when (page) {
            0 -> AppleNewsTabsScreen(navController = navController)
            1 -> TeslaNewsTabsScreen(navController=navController)
            2 -> USNewsTabsScreen(navController=navController)
            3 -> TechCrunchNewsTabsScreen(navController=navController)
            4 -> WallStreetNewsTabsScreen(navController=navController)
        }
    }
}