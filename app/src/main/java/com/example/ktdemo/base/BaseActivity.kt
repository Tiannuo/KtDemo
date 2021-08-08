package com.example.ktdemo.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.ktdemo.mvp.presenter.BasePresenter
import com.example.ktdemo.mvp.view.BaseView
import com.example.ktdemo.mvp.view.MvpView

abstract class BaseActivity<V:MvpView, P : BasePresenter<V>, B:ViewBinding> : AppCompatActivity(), BaseView {
    private var mPresenter: P? = null
    private var mBinding: B? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (mPresenter == null) {
            mPresenter = createPresenter()
        }
        if (mBinding == null) {
            mBinding = createBinding()
            setContentView(getBinding()!!.root)
        }
        mPresenter!!.bindView(this as V)
        init()
        initData()
    }

    abstract fun createBinding(): B?

    protected abstract fun initData()

    protected abstract fun init()

    protected abstract fun createPresenter(): P


    fun getPresenter() = mPresenter

    fun getBinding() = mBinding

    override fun onDestroy() {
        super.onDestroy()
        mPresenter!!.unBindView()
    }

}