package com.banseok.thezip.api

import com.banseok.thezip.user.UserKind
import com.banseok.thezip.user.UserRequest
import com.banseok.thezip.service.user.UserService
import org.springframework.web.bind.annotation.RestController
import javax.annotation.PostConstruct

@RestController
class InitController(
    private val userService: UserService
) {

    @PostConstruct
    fun init() {
        userService.create(UserRequest("테스터", "test", "qwer1234", UserKind.ADMIN))
    }
}