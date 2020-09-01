package com.example.coba

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    open fun initlisteners() {}
    open fun layoutid(Id: Int) {
        setContentView(Id)
    }

}