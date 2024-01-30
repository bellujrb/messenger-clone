package dev.bellu.messenger_clone.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "conversations")
data class ConversationEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "user1_id")
    val user1Id: Int,

    @ColumnInfo(name = "user2_id")
    val user2Id: Int
)
