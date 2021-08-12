package com.example.ktdemo.mvp.view

interface BaseView<M> {
    fun setData(data: M)
    fun setError(err: String)
}