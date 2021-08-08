package com.example.ktdemo.mvp.presenter

import com.example.ktdemo.mvp.view.MvpView

class MvpPresenter : BasePresenter<MvpView>() {

    fun setData(data: String) {
        getBaseView().setData(data)
    }

}