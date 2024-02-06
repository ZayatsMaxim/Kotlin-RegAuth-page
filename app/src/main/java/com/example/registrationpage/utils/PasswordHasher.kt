package com.example.registrationpage.utils

import org.mindrot.jbcrypt.BCrypt

class PasswordHasher {

    fun hashPassword(password: String): String {
        val hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt())
        println("Password $password has been hashed into $hashedPassword")
        return hashedPassword
    }

    fun checkPassword(password: String, hashedPassword: String): Boolean {
        return BCrypt.checkpw(password, hashedPassword)
    }

}