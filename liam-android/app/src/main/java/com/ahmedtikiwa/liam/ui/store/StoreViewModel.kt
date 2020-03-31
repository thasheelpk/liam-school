package com.ahmedtikiwa.liam.ui.store

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ahmedtikiwa.liam.domain.StoreItem
import com.ahmedtikiwa.liam.repository.LiamRepository
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class StoreViewModel(application: Application) : AndroidViewModel(application) {

    private val viewModelJob = SupervisorJob()

    private val liamRepository = LiamRepository()

    private val _navigateToSelectedStoreItem = MutableLiveData<StoreItem>()

    private val _downloadItem = MutableLiveData<StoreItem>()

    private val _favoriteItem = MutableLiveData<StoreItem>()

    val downloadItem: LiveData<StoreItem>
        get() = _downloadItem

    val navigateToSelectedShow: LiveData<StoreItem>
        get() = _navigateToSelectedStoreItem

    val favoriteItem: LiveData<StoreItem>
        get() = _favoriteItem

    init {
        viewModelScope.launch {
            liamRepository.getMockStoreList()
        }
    }

    val storeList = liamRepository.storeList

    fun displayStoreItemDetail(storeItem: StoreItem) {
        _navigateToSelectedStoreItem.value = storeItem
    }

    fun displayStoreItemDetailComplete() {
        _navigateToSelectedStoreItem.value = null
    }

    fun onDownloadClick(storeItem: StoreItem) {
        downloadItem(storeItem)
    }

    fun onFavoriteClick(storeItem: StoreItem) {
        favoriteItem(storeItem)
    }

    fun downloadItem(storeItem: StoreItem) {
        _downloadItem.value = storeItem
    }

    fun downloadItemComplete() {
        _downloadItem.value = null
    }

    fun favoriteItem(storeItem: StoreItem) {
        _favoriteItem.value = storeItem
    }

    fun favoriteItemComplete() {
        _favoriteItem.value = null
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}