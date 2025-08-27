package ru.bmstu.dc.architectureanddi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.bmstu.dc.architectureanddi.data.datasource.remote.service.INetworkDaoService
import ru.bmstu.dc.architectureanddi.datasource.remote.api.NetworkApi
import ru.bmstu.dc.architectureanddi.datasource.remote.dao.NetworkDao
import ru.bmstu.dc.architectureanddi.datasource.remote.service.NetworkDaoService
import ru.bmstu.dc.architectureanddi.utils.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {
    @Singleton
    @Provides
    fun provideNetworkApi(): NetworkApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("localhost")
            .build()
        return retrofit.create(NetworkApi::class.java)
    }

    @Provides
    fun provideNetworkDao(networkApi: NetworkApi): NetworkDao {
        return NetworkDao(networkApi)
    }

    @Provides
    fun provideNetworkDaoService(networkDao: NetworkDao): INetworkDaoService {
        return NetworkDaoService(networkDao)
    }

}