package com.daftmobile.a4bhomework1

import java.util.regex.Pattern

object EmailValidator {
    private val pattern = Pattern.compile("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}")

    fun isValidEmail(email: String) = pattern.matcher(email).matches()
}