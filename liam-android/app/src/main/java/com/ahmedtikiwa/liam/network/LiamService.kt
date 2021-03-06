package com.ahmedtikiwa.liam.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface LiamService {

    @GET("login")
    fun loginAsync(
        @Query("username") username: String = "SidTheKidz",
        @Query("password") password: String = "SidTheKid"
    ): Deferred<Any>

    @GET("getAllAssets")
    fun getAllAssetsAsync(): Deferred<List<NetworkAllAssetsResponse>>
}

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

object LiamNetwork {
    private const val BASE_URL = "https://liam-cripto.herokuapp.com"

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient().newBuilder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val liamApi: LiamService = retrofit.create(LiamService::class.java)
}