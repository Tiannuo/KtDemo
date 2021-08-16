package com.example.ktdemo.mvp2.presenter

import com.example.ktdemo.mvp2.model.BaseModel
import com.example.ktdemo.mvp2.model.IMode
import com.example.ktdemo.mvp2.view.BaseView
import com.example.ktdemo.mvp2.view.IView
import java.lang.ref.WeakReference

abstract class BasePresenter<V : BaseView, M : BaseModel> : IPresenter<BaseView> {
    var mModel: M? = null
    var mWeakReference: WeakReference<V>? = null

    override fun bindView(v: BaseView) {
        mWeakReference = WeakReference<V>(v as V)
        if (this.mModel == null) {
            this.mModel = createModule()
        }
    }

    override fun unBindView() {
        if (isViewAttach()) {
            mWeakReference!!.clear()
            mWeakReference = null
        }
        if (mModel != null) {
            mModel = null
        }
    }

    fun showLoading(){
        if (isViewAttach()){
            getView()!!.showLoading()
        }
    }

    fun dismissLoading(){
        if (isViewAttach()){
            getView()!!.dismissLoading()
        }
    }

    fun getView() = mWeakReference!!.get()

    override fun isViewAttach(): Boolean {
        return mWeakReference!!.get() != null
    }

    abstract fun createModule(): M?
}