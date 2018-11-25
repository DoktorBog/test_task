package com.test.data.remote

import com.test.data.model.DataEntity
import io.reactivex.Single
import retrofit2.http.GET


interface SmartBoxApi {

    @GET("TT.json")
    fun getData() : Single<List<DataEntity>>

}
