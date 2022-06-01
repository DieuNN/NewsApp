package com.dieunn.vietceteraclone.common

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Converter {
    companion object{
        @RequiresApi(Build.VERSION_CODES.O)
        fun parseDate():String {
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            return formatter.format(current)
        }
    }
}