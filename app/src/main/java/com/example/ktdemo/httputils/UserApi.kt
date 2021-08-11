package com.example.ktdemo.httputils

import com.example.ktdemo.mvp.model.BaseModel
import com.example.ktdemo.mvp.model.TestModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface UserApi {
    @GET("index?type=top&key=2c1cb93f8c7430a754bc3ad62e0fac06")
    fun getTest():Observable<BaseModel<TestModel>>
}