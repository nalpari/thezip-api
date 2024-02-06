package com.banseok.thezip.api.user

import com.banseok.thezip.user.UserListResponse
import com.banseok.thezip.user.UserRequest
import com.banseok.thezip.user.UserResponse
import com.banseok.thezip.service.user.UserService
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.noContent
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = ["*"])
class UserController(
    private val userService: UserService
) {

    @GetMapping
    fun getAll() = ok(UserListResponse.of(userService.findAll()))

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long) = ok(UserResponse.of(userService.findById(id)))

    @PostMapping
    fun create(@RequestBody request: UserRequest) = ok(UserResponse.of(userService.create(request)))

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody request: UserRequest) = ok(UserResponse.of(userService.update(id, request)))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        userService.deleteById(id)
        return noContent().build()
    }
}