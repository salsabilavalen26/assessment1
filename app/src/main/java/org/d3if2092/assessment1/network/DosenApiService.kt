package org.d3if2092.assessment1.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if2092.assessment1.model.Dosen
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/" +
        "indraazimi/galeri-hewan/static-api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface DosenApiService {
    @GET("static-api.json")
    suspend fun getDosen(): List<Dosen>
}

object DosenApi {
    val service: DosenApiService by lazy {
        retrofit.create(DosenApiService::class.java)
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }