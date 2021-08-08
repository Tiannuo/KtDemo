package com.example.ktdemo.mvp2.presenter

import com.example.ktdemo.mvp2.view.IView

interface IPresenter<T : IView> {
    fun bindView(v: T)
    fun unBindView()
    fun isViewAttach():Boolean
}