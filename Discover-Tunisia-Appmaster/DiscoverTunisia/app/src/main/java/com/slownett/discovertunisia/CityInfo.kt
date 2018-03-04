package com.slownett.discovertunisia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_city_info.*

class CityInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_info)

        var bundle:Bundle=intent.extras
        var name=bundle.getString("name")
        var des=bundle.getString("des")
        var image=bundle.getInt("image")
        imageViewInfo.setImageResource(image)
        textViewInfo.text=name
        textViewDesInfo.text=des
    }
}

