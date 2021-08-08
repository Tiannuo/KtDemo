package com.example.ktdemo.mvp2.presenter

import com.example.ktdemo.mvp2.model.Mvp2Model
import com.example.ktdemo.mvp2.view.Mvp2View

class Mvp2Presenter : BasePresenter<Mvp2View, Mvp2Model>() {
    override fun createModule(): Mvp2Model? {
        return null
    }

    fun setData(data: String) {
        getView()!!.setData(data)
    }
}