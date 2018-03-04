package com.slownett.discovertunisia

import android.content.Context
import android.content.Intent
import android.content.QuickViewConstants
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun buClick(view: View){
        var intent= Intent(this,second::class.java)
        startActivity(intent)
    }
}
