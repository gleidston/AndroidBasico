package com.venturus.basicrecycler2.data.network


import com.venturus.basicrecycler2.data.DataList
import retrofit2.http.GET

interface TheDataApi {
    @GET("filter.php?a=Non_Alcoholic")
    suspend fun getDatas(): DataList
}