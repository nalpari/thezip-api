package com.banseok.thezip.domain.user

import com.banseok.thezip.user.UserKind
import javax.persistence.*

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,

    @Column(name = "name")
    var name: String,

    @Column(name = "login_id")
    var loginId: String,

    @Column(name = "login_pw")
    var loginPw: String,

    @Column(name = "kind")
    @Enumerated(EnumType.STRING)
    var kind: UserKind,
) {
    fun update(name: String, loginPw: String, kind: UserKind) {
        this.name = name
        this.loginPw = loginPw
        this.kind = kind
    }
}