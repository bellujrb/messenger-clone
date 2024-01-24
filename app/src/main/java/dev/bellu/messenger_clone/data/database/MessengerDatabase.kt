package dev.bellu.messenger_clone.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.bellu.messenger_clone.data.contracts.MessengerDao
import dev.bellu.messenger_clone.data.entity.MessageEntity
import dev.bellu.messenger_clone.data.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class MessengerDatabase: RoomDatabase(){
    abstract fun messengerDao(): MessengerDao

    companion object{
        fun getDatabase(context: Context): MessengerDatabase {
            return Room.databaseBuilder(
                name = "msg_db",
                context = context.applicationContext,
                klass = MessengerDatabase::class.java
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}