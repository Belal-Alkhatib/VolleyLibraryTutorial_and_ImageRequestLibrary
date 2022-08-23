package com.example.and2_nluc15_volleylibrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.RetryPolicy
import com.android.volley.toolbox.StringRequest
import com.example.and2_nluc15_volleylibrary.app.MySingnletion
import com.example.and2_nluc15_volleylibrary.databinding.ActivityLuc18RetryPolicyBinding
import kotlinx.android.synthetic.main.activity_luc18_retry_policy.*


class Luc18_RetryPolicy : AppCompatActivity() {
    val URL_OBJ = "https://jsonplaceholder.typicode.com/posts"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_luc18_retry_policy)

        btnLuc19.setOnClickListener {
            val i = Intent(this,Luc19_ImageRequest::class.java)
            startActivity(i)
        }
        val stringRequest = object: StringRequest(
            Request.Method.GET,URL_OBJ,
            { response ->
                Log.e("hzm",response)
            },
            { error ->
                Log.e("hzm",error.message.toString())
            }

        ){
            override fun getRetryPolicy(): RetryPolicy {
                return DefaultRetryPolicy(10*1000,2,2F)
            }
        }
        MySingnletion.getInstence()!!.addToRequestQueue(stringRequest,"BI")
    }
}