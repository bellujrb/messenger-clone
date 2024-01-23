package dev.bellu.messenger_clone.data.entity

data class UserEntity(
    val id: Int,
    val name: String,
    val photo: String,
    val status: Status
)

enum class Status{
    OFFLINE, ONLINE
}