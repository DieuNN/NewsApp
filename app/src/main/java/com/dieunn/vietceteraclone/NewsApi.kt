package com.dieunn.vietceteraclone

import android.os.Build
import androidx.annotation.RequiresApi
import com.dieunn.vietceteraclone.common.Converter
import com.dieunn.vietceteraclone.common.Util
import com.dieunn.vietceteraclone.models.Article
import com.dieunn.vietceteraclone.models.News
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @RequiresApi(Build.VERSION_CODES.O)
    @GET("everything?apiKey=${Util.apiKey}")
    suspend fun getAppleNews(
        @Query("from") from: String = Converter.parseDate(),
        @Query("q") q: String = "Apple",
        @Query("to") to: String = Converter.parseDate(),
        @Query("sortBy") sortBy: String = "popularity",
    ): News

    @RequiresApi(Build.VERSION_CODES.O)
    @GET("everything?apiKey=${Util.apiKey}")
    suspend fun getTeslaNews(
        @Query("from") from: String = Converter.parseDate(),
        @Query("q") q: String = "tesla",
        @Query("to") to: String = Converter.parseDate(),
        @Query("sortBy") sortBy: String = "popularity",
    ): News

    @RequiresApi(Build.VERSION_CODES.O)
    @GET("top-headlines?apiKey=${Util.apiKey}")
    suspend fun getUSNews(
        @Query("country") country: String = "US",
        @Query("category") category: String = "business",
    ): News

    @RequiresApi(Build.VERSION_CODES.O)
    @GET("top-headlines?apiKey=${Util.apiKey}")
    suspend fun getTechCrunchNews(
        @Query("sources") source: String = "techcrunch",
    ): News

    @RequiresApi(Build.VERSION_CODES.O)
    @GET("everything?apiKey=${Util.apiKey}")
    suspend fun getWallStreetNews(
        @Query("domains") domains: String = "wsj.com",
    ): News
}