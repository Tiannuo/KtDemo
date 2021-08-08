package com.example.ktdemo.atc

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ktdemo.databinding.ActStartBinding

class StartActivity : AppCompatActivity() {

    private var binding: ActStartBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActStartBinding.inflate(layoutInflater);
        setContentView(binding!!.root)
        binding!!.iv.setOnClickListener {v->
            onClick(v);
        }


    }

    private fun onClick(v: View?) {
        var intent = Intent()
        intent.setClass(this,MvpActivity::class.java);
        startActivity(intent)
    }

}