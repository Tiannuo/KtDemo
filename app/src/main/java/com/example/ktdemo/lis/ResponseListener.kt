package com.example.ktdemo.lis

interface ResponseListener<T> {
    fun  onSuccess(t: T)
    fun onFail(msg: String)
}