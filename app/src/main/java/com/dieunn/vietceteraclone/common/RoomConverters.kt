package com.dieunn.vietceteraclone.common

import androidx.room.TypeConverter
import com.dieunn.vietceteraclone.models.Source

class RoomConverters {
    @TypeConverter
    fun fromSourceToString(source: Source?) : String {
        return "${source?.name} - ${source?.id}"
    }

    @TypeConverter
    fun fromStringToSource(string: String): Source {
        val rawObject = string.split("-")
        rawObject.forEach { it.trim() }
        return Source(
            rawObject[0],
            rawObject[1]
        )
    }
    //TODO:
    // 1. Test adding news to favorites
    // 2. Tryna list them and delete some

}