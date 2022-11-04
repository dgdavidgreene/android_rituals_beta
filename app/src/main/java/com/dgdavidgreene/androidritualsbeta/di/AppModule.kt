package com.dgdavidgreene.androidritualsbeta.di

import android.app.Application
import android.content.Context
import com.dgdavidgreene.androidritualsbeta.AppDatabase
import com.dgdavidgreene.androidritualsbeta.data.Repository
import com.dgdavidgreene.androidritualsbeta.ui.notifications.counter.CounterNotificationService
import com.dgdavidgreene.androidritualsbeta.ui.notifications.NotificationService
import com.dgdavidgreene.androidritualsbeta.ui.notifications.daily.DailyNotificationService
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.android.AndroidSqliteDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.Contexts.getApplication
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver {
        return AndroidSqliteDriver(
            schema = AppDatabase.Schema,
            context = app,
            name = "app.db"
        )
    }


    @Provides
    @Singleton
    fun provideRepository(driver: SqlDriver): Repository {
        return Repository(
            AppDatabase.invoke(driver)
        )
    }

    @Provides
    @Singleton
    fun provideNotificationService(application: Application): NotificationService {
        return NotificationService(application.applicationContext)
    }

    @Provides
    @Singleton
    fun provideCounterNotificationService(application: Application): CounterNotificationService {
        return CounterNotificationService(application.applicationContext)
    }

    @Provides
    @Singleton
    fun provideDailyNotificationService(application: Application): DailyNotificationService {
        return DailyNotificationService(application.applicationContext)
    }
}