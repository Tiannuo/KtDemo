package com.example.ktdemo.mvp2.model

import com.example.ktdemo.mvp2.utils.ModelUtils

open class BaseModel() : IMode {
    protected var mModelUtils: ModelUtils? = null

    init {
        mModelUtils = ModelUtils()
    }

    override fun bind() {
        mModelUtils!!.bind()
    }

    override fun unBind() {
        mModelUtils!!.unBind()
    }
}