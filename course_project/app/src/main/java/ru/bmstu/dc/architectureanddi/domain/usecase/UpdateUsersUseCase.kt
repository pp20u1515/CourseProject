package ru.bmstu.dc.architectureanddi.domain.usecase

import ru.bmstu.dc.architectureanddi.domain.repository.IUserRepository

class UpdateUsersUseCase(private val userRepository: IUserRepository) {
    suspend operator fun invoke() {
        userRepository.update()
    }
}