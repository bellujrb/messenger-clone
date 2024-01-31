package dev.bellu.messenger_clone.data.contracts

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.bellu.messenger_clone.data.entity.ConversationEntity
import dev.bellu.messenger_clone.data.entity.MessageEntity
import dev.bellu.messenger_clone.data.entity.UserEntity

@Dao
interface MessengerDao {
    @Query("SELECT * FROM users")
    fun getAll(): List<UserEntity>

    @Query("SELECT * FROM messages")
    fun getAllMessages(): List<MessageEntity>

    @Query("SELECT * FROM conversations")
    fun getAllConversations(): List<ConversationEntity>

    @Insert
    fun addUser(userEntity: UserEntity)

    @Insert
    fun sendMessage(message: MessageEntity)

    @Insert
    fun createConversation(conversation: ConversationEntity)
}