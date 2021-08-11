package com.example.ktdemo.atc

import com.example.ktdemo.base.BaseActivity
import com.example.ktdemo.databinding.ActivityMvpBinding
import com.example.ktdemo.mvp.model.BaseModel
import com.example.ktdemo.mvp.model.TestModel
import com.example.ktdemo.mvp.presenter.MvpPresenter
import com.example.ktdemo.mvp.view.MvpView

class MvpActivity : BaseActivity<MvpView, MvpPresenter, ActivityMvpBinding>(),MvpView {

    override fun createBinding(): ActivityMvpBinding? = ActivityMvpBinding.inflate(layoutInflater)

    override fun initData() {

    }

    override fun init() {
        getBinding()!!.btnGetData.setOnClickListener {
            println("====onClick")
            getPresenter()!!.getTest()
        }
    }

    override fun createPresenter() = MvpPresenter()

    override fun <T> setData(data: T) {
        println("====$data")
        var model: T = data

        getBinding()!!.btnGetData.text = "$data"
    }

    override fun setError(err: String) {
    }
}