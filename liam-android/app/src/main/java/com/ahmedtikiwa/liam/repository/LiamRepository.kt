package com.ahmedtikiwa.liam.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ahmedtikiwa.liam.domain.StoreItem
import com.ahmedtikiwa.liam.domain.UserDetails
import com.ahmedtikiwa.liam.domain.VideoItem
import com.ahmedtikiwa.liam.network.LiamNetwork
import com.ahmedtikiwa.liam.network.asDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import timber.log.Timber

class LiamRepository {

    private val _storeList = MutableLiveData<List<StoreItem>>()

    val storeList: LiveData<List<StoreItem>>
        get() = _storeList

    private val _videosList = MutableLiveData<List<VideoItem>>()

    val videoList: LiveData<List<VideoItem>>
        get() = _videosList

    private val _userDetails = MutableLiveData<UserDetails>()

    val userDetails: LiveData<UserDetails>
        get() = _userDetails

    suspend fun getAllAssets() {
        withContext(Dispatchers.IO) {
            try {
                LiamNetwork.liamApi.loginAsync().await()
                val assetsList = LiamNetwork.liamApi.getAllAssetsAsync().await()
                _storeList.postValue(assetsList.asDomainModel())
            } catch (e: HttpException) {
                Timber.e(e)
            }
        }
    }

    suspend fun getMockUserDetails() {
        withContext(Dispatchers.IO) {
            try {
                val userDetails = UserDetails(
                    id = "Ahmed",
                    profileImageUrl = "https://images.unsplash.com/photo-1558981420-87aa9dad1c89?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80",
                    totalDownloads = "1000",
                    totalLiams = "L5000",
                    totalLikes = "1500"
                )
                _userDetails.postValue(userDetails)
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

    suspend fun getMockVideoList() {
        withContext(Dispatchers.IO) {
            try {
                val list = mutableListOf<VideoItem>()
                list.add(
                    VideoItem(
                        id = 1,
                        name = "Kids Coding - Introduction to HTML, CSS and JavaScript!",
                        description = "Your kid could be the next Zuckerberg!",
                        price = "L200",
                        imageUrl = "https://images.unsplash.com/photo-1517148815978-75f6acaaf32c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
                        videoUrl = "S0Q4gqBUs7c"
                    )
                )
                list.add(
                    VideoItem(
                        id = 1,
                        name = "Kids Sewing 101",
                        description = "A sewing course for children ages 6-14",
                        price = "L200",
                        imageUrl = "https://images.unsplash.com/photo-1573680156791-0b85133632b4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=632&q=80",
                        videoUrl = "S0Q4gqBUs7c"
                    )
                )
                list.add(
                    VideoItem(
                        id = 1,
                        name = "Easy piano for Kids",
                        description = "Become your kid's first piano instructor!Learn how to teach your kid play piano with this really easy-to-follow course.",
                        price = "L200",
                        imageUrl = "https://images.unsplash.com/photo-1514119412350-e174d90d280e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
                        videoUrl = "S0Q4gqBUs7c"
                    )
                )
                list.add(
                    VideoItem(
                        id = 1,
                        name = "Youth Basketball: How to Get Better at Basketball For Kids",
                        description = "Rise Above Your Competition in Boys Basketball and Girls Basketball and Move from Beginner to Well-Trained MVP.",
                        price = "L200",
                        imageUrl = "https://images.unsplash.com/photo-1562730533-9a58fab99222?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
                        videoUrl = "S0Q4gqBUs7c"
                    )
                )
                list.add(
                    VideoItem(
                        id = 1,
                        name = "Photography for Kids: Project-Based Beginner Photography",
                        description = "12 weeks of adventure projects make this the perfect course for kids and beginners to learn how to use a camera properly",
                        price = "L200",
                        imageUrl = "https://images.unsplash.com/photo-1516035069371-29a1b244cc32?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=80",
                        videoUrl = "S0Q4gqBUs7c"
                    )
                )
                list.add(
                    VideoItem(
                        id = 1,
                        name = "Kid Entrepreneurship - Business Launch Plan (3rd-5th grade)",
                        description = "K I D E N T R E P R E N E U R S H I P . C O M",
                        price = "L200",
                        imageUrl = "https://images.unsplash.com/photo-1524110405815-40f8cb1bf14d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1056&q=80",
                        videoUrl = "S0Q4gqBUs7c"
                    )
                )
                list.add(
                    VideoItem(
                        id = 1,
                        name = "Drawing for Kids: How to Draw Step-by-Step Interactive Art",
                        description = "Hey Friends! Let's Build This Course Together. Send Me Your Artsy Ideas: What Would You Like to Learn to Draw? Ages 5+.",
                        price = "L200",
                        imageUrl = "https://images.unsplash.com/photo-1513542789411-b6a5d4f31634?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=967&q=80",
                        videoUrl = "S0Q4gqBUs7c"
                    )
                )

                _videosList.postValue(list)
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

    suspend fun getMockStoreList() {
        withContext(Dispatchers.IO) {
            try {
                val list = mutableListOf<StoreItem>()
                list.add(
                    StoreItem(
                        likes = "100",
                        downloads = "100",
                        name = "Turquoise Abstract Landscape II",
                        price = "L200",
                        imageUrl = "https://images.unsplash.com/flagged/photo-1567934150921-7632371abb32?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80"
                    )
                )
                list.add(
                    StoreItem(
                        likes = "100",
                        downloads = "100",
                        name = "XBox One X",
                        price = "L300",
                        imageUrl = "https://game4u.co.za/wp-content/uploads/2020/02/standalone2.png"
                    )
                )
                list.add(
                    StoreItem(
                        likes = "100",
                        downloads = "100",
                        name = "Music Sheet",
                        price = "L200",
                        imageUrl = "https://images.unsplash.com/photo-1520446266423-6daca23fe8c7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80"
                    )
                )
                list.add(
                    StoreItem(
                        likes = "100",
                        downloads = "100",
                        name = "Mobile Phone",
                        price = "L250",
                        imageUrl = "https://images.unsplash.com/photo-1495434942214-9b525bba74e9?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80"
                    )
                )
                list.add(
                    StoreItem(
                        likes = "100",
                        downloads = "100",
                        name = "Mobile Phone",
                        price = "L400",
                        imageUrl = "https://images.unsplash.com/photo-1532456164788-984c62717cf8?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1000&q=80"
                    )
                )
                list.add(
                    StoreItem(
                        likes = "100",
                        downloads = "100",
                        name = "Camera",
                        price = "L300",
                        imageUrl = "https://images.unsplash.com/photo-1512024221064-95d1aca6dc81?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1189&q=80"
                    )
                )

                _storeList.postValue(list)
            } catch (e: Exception) {
                Timber.e(e)
            }
        }

    }
}