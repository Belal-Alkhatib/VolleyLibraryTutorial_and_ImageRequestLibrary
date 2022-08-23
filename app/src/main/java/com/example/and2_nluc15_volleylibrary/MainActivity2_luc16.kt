package com.example.and2_nluc15_volleylibrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.example.and2_nluc15_volleylibrary.app.MySingnletion
import com.example.and2_nluc15_volleylibrary.databinding.ActivityMainActivity2Luc16Binding

class MainActivity2_luc16 : AppCompatActivity() {
lateinit var binding: ActivityMainActivity2Luc16Binding
    val URL_OBJ = "https://jsonplaceholder.typicode.com/posts/1"
    val URL_ARR = "https://api.androidhive.info/volley/person_array.json"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityMainActivity2Luc16Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnObj.setOnClickListener {
            getJSONObject()
        }
        binding.btmArr.setOnClickListener {
            getJSONArray()
        }

        binding.btnLuc17.setOnClickListener {
            val i = Intent(this,Acr3_luc17_VolleyPost::class.java)
            startActivity(i)
        }


    }

fun getJSONObject(){
    val objRequest = JsonObjectRequest(Request.Method.GET,URL_OBJ,null,
        Response.Listener { response ->
            binding.tvResult.text = response.toString()
        },
        Response.ErrorListener {
            binding.tvResult.text = "That did not Work"
        }
    )

    MySingnletion.getInstence()!!.addToRequestQueue(objRequest)

}

    fun getJSONArray(){
        val arrRequest = JsonArrayRequest(Request.Method.GET,URL_ARR,null,
            Response.Listener { response ->
                binding.tvResult.text = response.toString()
            },
            Response.ErrorListener {
                binding.tvResult.text = "That Didint Work"
            }
        )
        MySingnletion.getInstence()!!.addToRequestQueue(arrRequest,"jsonArray")

    }

}