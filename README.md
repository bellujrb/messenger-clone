# messeger-clone: Messenger App Clone 

> _ORIGIN APP: https://www.messenger.com


## 🌐 Introduction

I am creating a clone of an existing application to study Android development features

## 🙏 Important

The database used was the android's internal storage with SQL. Everything included was done as a means of studying android development.

## 📂 Project File Tree

```
messenger_clone/app/src/main/java/dev/bellu/messenger_clone
├── data
│   ├── contracts
│       └── MessengerDao.kt
│   ├── database
│       └── MessengerDatabase.kt
│   ├── entity
│       └── AdvertisingEntity.kt
│       └── ConversationEntity.kt
│       └── MessageEntity.kt
│       └── UserEntity.kt
│  
├── di
│   └── AppModule.kt
│   └── ViewModelModule.kt
│  
├── presentation
│   ├── composables
│       └── AppBar.kt
│       └── BottomBarCustom.kt
│       └── ChatPreview.kt
│       └── CircleAvatarCustom.kt
│       └── PersonView.kt
│       └── ReceiveMessage.kt
│       └── SendMessage.kt
│   ├── screens
│       ├── advertising
│           └── AdvertisingScreen.kt
│           └── AdvertisingViewModel.kt
│       ├── chat
│           └── ChatScreen.kt
│           └── ChatUiState.kt
│           └── ChatViewModel.kt
│       ├── friends
│           └── FriendsScreen.kt
│           └── FriendsViewModel.kt
│       ├── home
│           └── HomeScreen.kt
│       ├── settings
│           └── SettingsScreen.kt
│       ├── welcome
│           └── WelcomeScreen.kt
│   ├── shared
│       └── AppState.kt
│       └── BaseUiState.kt
│       └── BaseViewModel.kt
│   ├── theme
│       └── Color.kt
│       └── Theme.kt
│       └── Type.kt
│ 
├── AppNavGraph.kt
├── MainActivity.kt
├── MessengerApplication.kt
```

---

## 🧪 Use Cases 

### 1. Add Application User
The user of the application is automatically added with the first user in the database table must have a user in the database.
  1. Add to internal database.
  2. Open the application.

### 2. Add contacts from the app
Users need to be manually added to the database to become contacts in the application.
  1. Access the contacts section in the application.
  2. Add the desired contacts manually.
  3. Contacts are stored in Android's internal database.
     
### 3. Start a conversation with Contact
With all the contacts added, users can start conversations by accessing the conversations page and selecting the desired contact.
  1. Navigate to the friends section.
  2. Select the desired contact.
  3. Start the conversation.

### 4. Add Ads to the App
Ads need to be added to the database, similar to the process of adding users and contacts.
  1. Access the ads section in the app.
  2. Add the ad details manually.
  3. The ads are stored in Android's internal database.

---

## 🛠 Tech Stack

### Language 
- Kotlin with Jetpack Compose
- SQL

### External Packages 
- Navigation Compose
- Coil Compose
- Room (Database SQL)
- Livedata
- Koin (Injection Dependency)
- Datastore Preferences RXJAVA 
  
### Design Pattern
- MVVM
- Singleton
  
### Architecture 
- Clean Architecture
