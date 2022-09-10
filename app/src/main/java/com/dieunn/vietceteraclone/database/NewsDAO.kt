package com.dieunn.vietceteraclone.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.dieunn.vietceteraclone.models.Article
import com.dieunn.vietceteraclone.models.News

@Dao
interface NewsDAO  {
    @Query("SELECT * FROM article")
    fun getAll() : List<Article>

    @Insert
    fun addNews(article: Article) : Long

    @Delete
    fun deleteNews(article: Article) : Int

    @Query("Select * from article where url = :url")
    fun getNewsByUrl(url : String) : Article
}