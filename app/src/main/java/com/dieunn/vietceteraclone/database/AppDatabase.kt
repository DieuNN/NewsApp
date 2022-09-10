package com.dieunn.vietceteraclone.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dieunn.vietceteraclone.common.RoomConverters
import com.dieunn.vietceteraclone.models.Article

@TypeConverters(RoomConverters::class)
@Database(entities = [Article::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun NewsDAO() : NewsDAO

    companion object {
        private var INSTANCE : AppDatabase? = null
        fun getDatabase(context : Context) : AppDatabase {

            if (INSTANCE != null) {
                return INSTANCE!!
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
            }
            return INSTANCE!!
        }
    }
}