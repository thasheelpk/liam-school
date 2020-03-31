package com.ahmedtikiwa.liam.ui.signup

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SignUpViewModel(application: Application) : AndroidViewModel(application) {

    private val _navigateToDashboard = MutableLiveData<Boolean>()

    private val _navigateToLogin = MutableLiveData<Boolean>()

    val navigateToDashboard: LiveData<Boolean>
        get() = _navigateToDashboard

    val navigateToLogin: LiveData<Boolean>
        get() = _navigateToLogin

    fun navigateToDashboardComplete() {
        _navigateToDashboard.value = false
    }

    fun onSignUpClick() {
        _navigateToDashboard.value = true
    }

    fun onLoginClick() {
        _navigateToLogin.value = true
    }

    fun navigateToLoginComplete() {
        _navigateToLogin.value = false
    }
}