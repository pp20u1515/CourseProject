package ru.bmstu.dc.architectureanddi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.bmstu.dc.database.db.Database
import ru.bmstu.dc.architectureanddi.data.datasource.local.service.CredentialDaoService
import ru.bmstu.dc.architectureanddi.data.datasource.local.service.UserDaoService
import ru.bmstu.dc.database.DatabaseDependencies
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule: DatabaseDependencies {
    @Provides
    @Singleton
    override fun provideDatabase(): Database {
        return Database()
    }

    @Provides
    fun provideUserDaoService(database: Database): UserDaoService {
        return UserDaoService(database)
    }

    @Provides
    fun provideCredentialDaoService(database: Database): CredentialDaoService {
        return CredentialDaoService(database)
    }
}