package com.example.retrofittrial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val list: MutableList<String> = ArrayList()
        list.add("list 1")
        list.add("list 2")
        list.add("list 3")
        val dataAdapter = ArrayAdapter(
                this,
        android.R.layout.simple_spinner_item, list
        )

        spinner.adapter = dataAdapter

        Glide.with(imageview.context).load("https://upload.wikimedia.org/wikipedia/id/5/5c/Spongebob-squarepants.png")
            .into(imageview)
    }
}
