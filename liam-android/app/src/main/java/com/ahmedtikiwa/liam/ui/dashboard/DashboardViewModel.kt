package com.ahmedtikiwa.liam.ui.dashboard

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ahmedtikiwa.liam.repository.LiamRepository
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class DashboardViewModel(application: Application) : AndroidViewModel(application) {

    private val viewModelJob = SupervisorJob()

    private val liamRepository = LiamRepository()

    init {
        viewModelScope.launch {
            liamRepository.getMockUserDetails()
        }
    }

    val userDetails = liamRepository.userDetails

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}