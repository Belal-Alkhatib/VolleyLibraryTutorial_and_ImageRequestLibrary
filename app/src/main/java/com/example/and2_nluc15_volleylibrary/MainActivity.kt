package com.example.and2_nluc15_volleylibrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.and2_nluc15_volleylibrary.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStartRequest.setOnClickListener {
            getStringRequest()
        }
        binding.btnLuc16.setOnClickListener {
            val i = Intent(this,MainActivity2_luc16::class.java)
            startActivity(i)
        }


    }

    fun getStringRequest(){
        val queue = Volley.newRequestQueue(this)
        val url = "https://api.androidhive.info/volley/person_array.json"

        val stringRequest = StringRequest(Request.Method.GET, url,
            { response ->
                //Log.e("hzm",response.toString())
                tvMsg.text = response.toString()
            },
            {
                //Log.e("hzm","That Didint Work")
                tvMsg.text = "That Didint Work"
            }
            )

        queue.add(stringRequest)
    }
}