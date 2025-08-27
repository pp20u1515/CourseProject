package ru.bmstu.dc.architectureanddi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.bmstu.dc.architectureanddi.data.datasource.local.service.CredentialDaoService
import ru.bmstu.dc.architectureanddi.data.datasource.local.service.UserDaoService
import ru.bmstu.dc.architectureanddi.data.datasource.remote.service.INetworkDaoService
import ru.bmstu.dc.architectureanddi.data.repository.CredentialRepository
import ru.bmstu.dc.architectureanddi.data.repository.UserRepository
import ru.bmstu.dc.architectureanddi.domain.repository.ICredentialRepository
import ru.bmstu.dc.architectureanddi.domain.repository.IUserRepository
import ru.bmstu.dc.architectureanddi.domain.usecase.AuthenticateUseCase
import ru.bmstu.dc.architectureanddi.domain.usecase.GetUsersUseCase
import ru.bmstu.dc.architectureanddi.domain.usecase.UpdateUsersUseCase

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    fun provideUserRepository(
        userDaoService: UserDaoService,
        networkDaoService: INetworkDaoService
    ): IUserRepository {
        return UserRepository(userDaoService, networkDaoService)
    }

    @Provides
    fun provideCredentialRepository(
        credentialDaoService: CredentialDaoService,
        userDaoService: UserDaoService,
        networkDaoService: INetworkDaoService
    ): ICredentialRepository {
        return CredentialRepository(credentialDaoService, userDaoService, networkDaoService)
    }

    @Provides
    fun provideAuthenticateUseCase(
        credentialRepository: ICredentialRepository
    ): AuthenticateUseCase {
        return AuthenticateUseCase(credentialRepository)
    }

    @Provides
    fun provideGetUsersUseCase(
        userRepository: IUserRepository
    ): GetUsersUseCase {
        return GetUsersUseCase(userRepository)
    }

    @Provides
    fun provideUpdateUsers(
        userRepository: IUserRepository
    ): UpdateUsersUseCase {
        return UpdateUsersUseCase(userRepository)
    }
}