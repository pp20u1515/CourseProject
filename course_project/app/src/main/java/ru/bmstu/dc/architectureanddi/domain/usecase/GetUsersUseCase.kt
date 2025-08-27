package ru.bmstu.dc.architectureanddi.domain.usecase

import kotlinx.coroutines.flow.Flow
import ru.bmstu.dc.architectureanddi.domain.repository.IUserRepository
import ru.bmstu.dc.architectureanddi.domain.model.User

class GetUsersUseCase(private val userRepository: IUserRepository) {
    operator fun invoke(): Flow<List<User>> = userRepository.getAll()
}