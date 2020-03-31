package com.ahmedtikiwa.liam.ui.videodetail

import android.app.Application
import androidx.lifecycle.*
import com.ahmedtikiwa.liam.domain.VideoItem

class VideoDetailViewModel(
    application: Application,
    videoItem: VideoItem
) : AndroidViewModel(application) {

    private val _video = MutableLiveData<VideoItem>()

    val video: LiveData<VideoItem>
        get() = _video

    init {
        _video.postValue(videoItem)
    }

    class Factory(
        val app: Application,
        private val videoItem: VideoItem
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(VideoDetailViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return VideoDetailViewModel(
                    app,
                    videoItem
                ) as T
            }
            throw IllegalArgumentException("Unable to construct viewModel")
        }
    }
}