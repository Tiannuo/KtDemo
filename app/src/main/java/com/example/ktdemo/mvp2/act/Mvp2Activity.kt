package com.example.ktdemo.mvp2.act

import com.example.ktdemo.databinding.ActivityMvp2Binding
import com.example.ktdemo.mvp2.model.Mvp2Model
import com.example.ktdemo.mvp2.presenter.Mvp2Presenter
import com.example.ktdemo.mvp2.view.Mvp2View


class Mvp2Activity : BaseMvpActivity<Mvp2View, Mvp2Model, Mvp2Presenter, ActivityMvp2Binding>(),
    Mvp2View {
    override fun init() {
        getBinding()!!.tv.setOnClickListener {
            println("=== onClick")
            getPresenter()!!.setData("Test")
        }
    }

    override fun initData() {

    }

    override fun createBinding(): ActivityMvp2Binding? = ActivityMvp2Binding.inflate(layoutInflater)

    override fun createPresenter(): Mvp2Presenter? = Mvp2Presenter()

    override fun setData(data: String) {
        println("===$data")
    }
}