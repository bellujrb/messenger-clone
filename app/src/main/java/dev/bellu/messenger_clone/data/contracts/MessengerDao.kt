package dev.bellu.messenger_clone.data.contracts

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.bellu.messenger_clone.data.entity.UserEntity

@Dao
interface MessengerDao {
    @Query("SELECT * FROM users")
    fun getAll(): List<UserEntity>

    @Insert
    fun addUser(user: UserEntity)
}