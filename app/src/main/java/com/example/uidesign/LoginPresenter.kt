package com.example.uidesign

class LoginPresenter(private val view: MainActivity) : LoginContract.Presenter {
    override fun login(username: String, password: String) {
        // Perform validation
        if (username.isEmpty() || password.isEmpty()) {
            view.showValidationError("Username and password are required.")
            return
        }

        // Perform login logic
        if (username == "123" && password == "123") {
            view.navigateToHomePage()
        } else {
            view.showLoginError("Invalid username or password.")
        }
    }
}

