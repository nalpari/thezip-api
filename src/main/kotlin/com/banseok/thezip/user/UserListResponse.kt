package com.banseok.thezip.user

import com.banseok.thezip.domain.user.User
import com.fasterxml.jackson.annotation.JsonIgnore

class UserListResponse(
    val users: List<UserResponse>
) {
    val size: Int
        @JsonIgnore
        get() = users.size

    companion object {
        fun of(userList: List<User>) = UserListResponse(userList.map(UserResponse.Companion::of))
    }
}