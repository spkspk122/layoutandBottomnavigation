package com.example.uidesign

import android.content.Context

interface LoginContract {
    interface View {
        fun showValidationError(message: String)
        fun showLoginSuccess(message: String)
        fun showLoginError(message: String)
        fun navigateToHomePage()
    }

    interface Presenter {
        fun login(username: String, password: String)
    }
}
