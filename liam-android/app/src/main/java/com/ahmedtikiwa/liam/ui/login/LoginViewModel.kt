package com.ahmedtikiwa.liam.ui.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val _navigateToDashboard = MutableLiveData<Boolean>()

    private val _navigateToSignUp = MutableLiveData<Boolean>()

    val navigateToDashboard: LiveData<Boolean>
        get() = _navigateToDashboard

    val navigateToSignUp: LiveData<Boolean>
        get() = _navigateToSignUp

    fun navigateToDashboardComplete() {
        _navigateToDashboard.value = false
    }

    fun onLoginClick() {
        _navigateToDashboard.value = true
    }

    fun onSignUpClick() {
        _navigateToSignUp.value = true
    }

    fun navigateToSignUpComplete() {
        _navigateToSignUp.value = false
    }
}