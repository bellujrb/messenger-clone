package dev.bellu.messenger_clone.data.database

import AdvertisingEntity
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.bellu.messenger_clone.data.contracts.MessengerDao
import dev.bellu.messenger_clone.data.entity.ConversationEntity
import dev.bellu.messenger_clone.data.entity.MessageEntity
import dev.bellu.messenger_clone.data.entity.UserConversationCrossRefEntity
import dev.bellu.messenger_clone.data.entity.UserEntity

@Database(
    entities = [
        UserEntity::class,
        MessageEntity::class,
        ConversationEntity::class,
        UserConversationCrossRefEntity::class,
        AdvertisingEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class MessengerDatabase : RoomDatabase() {
    abstract fun messengerDao(): MessengerDao

    companion object {

        private const val DATABASE_NAME = "messenger_database.db"

        @Volatile
        private var instance: MessengerDatabase? = null
        fun getDatabase(context: Context): MessengerDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): MessengerDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                MessengerDatabase::class.java,
                DATABASE_NAME
            )
                .fallbackToDestructiveMigrationFrom()
                .build()
        }
    }
}