package com.example.ttmarparis.desafioguiabolso.api

import com.example.ttmarparis.desafioguiabolso.Util.Constants
import com.example.ttmarparis.desafioguiabolso.models.Category
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceInterface {
    @GET("categories")
    fun getCategoriesList(): Observable<List<String>>

    @GET("random?category={name}")
    fun getCategory(@Path("name") name: String): Observable<Category>

    companion object Factory {
        fun create(): ApiServiceInterface {
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()

            return retrofit.create(ApiServiceInterface::class.java)
        }
    }
}