package com.ahmedtikiwa.liam.network

import com.ahmedtikiwa.liam.domain.StoreItem

data class NetworkAllAssetsResponse(
    val downloads: Int,
    val likes: String,
    val setLimasCost: Int,
    val url: String,
    val username: String
)

fun List<NetworkAllAssetsResponse>.asDomainModel() : List<StoreItem> {
    return map {
        StoreItem(
            name = null,
            price = it.setLimasCost.toString(),
            imageUrl = it.url,
            downloads = it.downloads.toString(),
            likes = it.likes
        )
    }
}