package ru.bmstu.dc.architectureanddi.domain.usecase

import ru.bmstu.dc.architectureanddi.domain.repository.ICredentialRepository
import ru.bmstu.dc.architectureanddi.domain.model.Credential

class AuthenticateUseCase(private val credentialRepository: ICredentialRepository) {
    suspend operator fun invoke(credential: Credential) {
        credentialRepository.authenticate(credential)
    }
}