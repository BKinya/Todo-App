package com.droidpwani.todoapp

import android.app.Application
import com.droidpwani.todoapp.di.appModules
import logcat.AndroidLogcatLogger
import logcat.LogPriority
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TodoApplication: Application() {

  override fun onCreate() {
    super.onCreate()
    // logcat
    AndroidLogcatLogger.installOnDebuggableApp(this, minPriority = LogPriority.VERBOSE)

    // koin
    startKoin {
      androidLogger()
      androidContext(this@TodoApplication)
      modules(appModules)

    }
  }
}