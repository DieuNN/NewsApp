package com.dieunn.vietceteraclone.viewmodels

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.dieunn.vietceteraclone.database.AppDatabase
import com.dieunn.vietceteraclone.models.Article

class AppViewModel(application: Application) : AndroidViewModel(application) {
    private var savedNews by mutableStateOf(emptyList<Article>())

    init {
        savedNews = AppDatabase.getDatabase(application.applicationContext).NewsDAO().getAll()
    }

    fun getAll() : List<Article> = savedNews

    fun addNews(article: Article) : Boolean {
        if (checkIfExist(article)) {
            return false
        }
        return AppDatabase.getDatabase(getApplication<Application>().applicationContext).NewsDAO().addNews(article) == 1L
    }

    fun deleteNews(article: Article) : Boolean {
        return AppDatabase.getDatabase(getApplication<Application>().applicationContext).NewsDAO().deleteNews(article) == 1
    }

    private fun checkIfExist(article: Article) : Boolean {
        return savedNews.contains(article)
    }



}