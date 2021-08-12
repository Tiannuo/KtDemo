package com.example.ktdemo.mvp.presenter

import com.example.ktdemo.httputils.HttpUtils
import com.example.ktdemo.httputils.UserApi
import com.example.ktdemo.lis.ResponseListener
import com.example.ktdemo.mvp.model.BaseModel
import com.example.ktdemo.mvp.model.TestModel
import com.example.ktdemo.mvp.view.MvpView

class MvpPresenter : BasePresenter<MvpView,TestModel>() {

    fun getTest() {
        HttpUtils.sendHttp(HttpUtils.createApi(UserApi::class.java).getTest(),
            object : ResponseListener<BaseModel<TestModel>> {
                override fun onSuccess(t: BaseModel<TestModel>) {
                    getBaseView().setData(t.result)
                }

                override fun onFail(msg: String) {
                    getBaseView().setError(msg)
                }

            })
    }
}