package com.banseok.thezip.user

data class UserRequest(
    val name: String,
    val loginId: String,
    val loginPw: String,
    val kind: UserKind,
)
