package com.banseok.thezip.service.user

import com.banseok.thezip.user.UserRequest
import com.banseok.thezip.domain.user.User
import com.banseok.thezip.domain.user.UserRepository
import org.springframework.data.domain.Sort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
@Transactional(readOnly = true)
class UserService(
    private val userRepository: UserRepository
) {
    fun findAll(): List<User> = userRepository.findAll(Sort.by(Sort.Direction.DESC, "id"))

    fun findById(id: Long): User = userRepository.findByIdOrNull(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    @Transactional
    fun create(request: UserRequest): User {
        checkNotNull(request) { "TodoRequest is null" }

        val user = User(
            name = request.name,
            loginId = request.loginId,
            loginPw = request.loginPw,
            kind = request.kind,
        )

        return userRepository.save(user)
    }

    @Transactional
    fun update(id: Long, request: UserRequest): User {
        checkNotNull(request) { "TodoRequest is null" }

        return findById(id).let {
            it.update(request.name, request.loginPw, request.kind)
            userRepository.save(it)
        }
    }

    @Transactional
    fun deleteById(id: Long) = userRepository.deleteById(id)
}