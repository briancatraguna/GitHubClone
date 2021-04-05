package com.dicoding.githubclone.api

import com.dicoding.githubclone.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>
}