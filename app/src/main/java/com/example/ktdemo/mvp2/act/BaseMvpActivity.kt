package com.example.ktdemo.mvp2.act

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.ktdemo.mvp2.model.BaseModel
import com.example.ktdemo.mvp2.model.IMode
import com.example.ktdemo.mvp2.presenter.BasePresenter
import com.example.ktdemo.mvp2.view.BaseView

abstract class BaseMvpActivity<V : BaseView, M : BaseModel, P : BasePresenter<V, M>, B : ViewBinding> :
    AppCompatActivity(), BaseView {

    private var mPresenter: P? = null
    private var mViewBinding: B? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (mPresenter == null) {
            mPresenter = createPresenter()
        }

        if (mViewBinding == null) {
            mViewBinding = createBinding()
            setContentView(getBinding()!!.root)
        }
        mPresenter!!.bindView(this)

        init()

        initData()
    }

    abstract fun init()

    abstract fun initData()

    fun getBinding() = mViewBinding

    fun getPresenter() = mPresenter

    abstract fun createBinding(): B?

    abstract fun createPresenter(): P?

    override fun onDestroy() {
        super.onDestroy()
        mPresenter!!.unBindView()
    }
}