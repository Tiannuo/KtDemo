package com.example.ktdemo.atc

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ktdemo.databinding.ActStartBinding
import com.example.ktdemo.mvp2.act.Mvp2Activity

class StartActivity : AppCompatActivity() {

    private var binding: ActStartBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActStartBinding.inflate(layoutInflater);
        setContentView(binding!!.root)
        binding!!.ivStart.setOnClickListener {v->
            onClick(v);
        }


    }

    private fun onClick(v: View?) {
        var intent = Intent()
        intent.setClass(this,Mvp2Activity::class.java);
        startActivity(intent)
    }

}