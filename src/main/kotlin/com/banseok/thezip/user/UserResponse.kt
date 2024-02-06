package com.banseok.thezip.user

import com.banseok.thezip.domain.user.User

class UserResponse(
    val id: Long,
    val name: String,
    val loginId: String,
    val kind: UserKind,
) {

    companion object {
        fun of(user: User): UserResponse {
            checkNotNull(user.id)

            return UserResponse(
                id = user.id,
                name = user.name,
                loginId = user.loginId,
                kind = user.kind,
            )
        }
    }
}