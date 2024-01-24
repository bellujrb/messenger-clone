package dev.bellu.messenger_clone.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    val id: Int,

    @ColumnInfo("name")
    val name: String,

    @ColumnInfo("photo")
    val photo: String,

    @ColumnInfo("status")
    val status: Boolean
)