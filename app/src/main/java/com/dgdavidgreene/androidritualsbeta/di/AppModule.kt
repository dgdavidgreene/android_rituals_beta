package com.dgdavidgreene.androidritualsbeta.di

import android.app.Application
import com.dgdavidgreene.androidritualsbeta.AppDatabase
import com.dgdavidgreene.androidritualsbeta.data.Repository
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.android.AndroidSqliteDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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

}