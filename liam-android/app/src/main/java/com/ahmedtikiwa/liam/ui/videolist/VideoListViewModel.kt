package com.ahmedtikiwa.liam.ui.videolist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ahmedtikiwa.liam.domain.VideoItem
import com.ahmedtikiwa.liam.repository.LiamRepository
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class VideoListViewModel(application: Application) : AndroidViewModel(application) {

    private val viewModelJob = SupervisorJob()

    private val liamRepository = LiamRepository()

    private val _navigateToSelectedVideo = MutableLiveData<VideoItem>()

    val navigateToSelectedVideo: LiveData<VideoItem>
        get() = _navigateToSelectedVideo

    init {
        viewModelScope.launch {
            liamRepository.getMockVideoList()
        }
    }

    val videoList = liamRepository.videoList

    fun displayVideoDetail(videoItem: VideoItem) {
        _navigateToSelectedVideo.value = videoItem
    }

    fun displayVideoDetailComplete() {
        _navigateToSelectedVideo.value = null
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}