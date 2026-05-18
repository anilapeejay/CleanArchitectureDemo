Kotlin Clean Architecture Project Setup (Step by Step)

This setup is for a modern Android app using:

Clean Architecture
MVVM
Hilt
Retrofit
Room DB
StateFlow
Repository Pattern
Coroutines
Error Handling
App-wide state management
Package management structure

Goal example:--------
Fetch list data from API
Save into Room DB
Show in UI
Handle loading/error/empty states properly

-Recommended Project Structure
com.example.cleanarchitecture
│
├── core
│   ├── common
│   ├── network
│   ├── database
│   ├── dispatcher
│   ├── utils
│   ├── state
│   └── error
│
├── di
│
├── data
│   ├── remote
│   │   ├── api
│   │   ├── dto
│   │   └── datasource
│   │
│   ├── local
│   │   ├── dao
│   │   ├── entity
│   │   └── datasource
│   │
│   ├── mapper
│   │
│   ├── repository
│   │   └── implementation
│   │
│   └── model
│
├── domain
│   ├── model
│   ├── repository
│   └── usecase
│
├── presentation
│   ├── ui
│   │   ├── home
│   │   └── components
│   │
│   ├── state
│   ├── intent
│   ├── viewmodel
│   └── navigation
│
└── MainApplication.kt

1. Recommended Projec
2. t Structure
3. 
