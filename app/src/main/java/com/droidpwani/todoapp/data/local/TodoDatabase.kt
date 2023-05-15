package com.droidpwani.todoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
  entities = [],
  version = 1
)
abstract class TodoDatabase: RoomDatabase() {}