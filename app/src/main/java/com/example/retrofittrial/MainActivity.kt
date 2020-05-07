package com.example.retrofittrial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var photoAdapter: PhotoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.layoutManager = LinearLayoutManager(this)
        photoAdapter = PhotoAdapter(this, listOf())
        recycler_view.adapter = photoAdapter

        getFromApi()
    }

    private fun getFromApi() {
        val service = RetrofitClient.retrofit.create(JsonPlaceHolderAPI::class.java)
        val callApi = service.getAllPhotos()
        callApi.enqueue(object : Callback<List<Photo>> {
            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                //hide loading
                Toast.makeText(this@MainActivity, "Koneksi bermasalah", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                //hide loading
                photoAdapter.setData(response.body()!!)

                recycler_view.layoutManager = LinearLayoutManager(this@MainActivity)
                photoAdapter = PhotoAdapter(this@MainActivity, response.body()!!)
                recycler_view.adapter = photoAdapter
            }
        })
    }
}
