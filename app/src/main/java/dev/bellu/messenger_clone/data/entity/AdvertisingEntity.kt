package dev.bellu.messenger_clone.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "advertising")
data class AdvertisingEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    val id: Int = 0,

    @ColumnInfo("name")
    val name: String,

    @ColumnInfo("subtitle")
    val subtitle: String,

    @ColumnInfo("photo")
    val photo: String
)