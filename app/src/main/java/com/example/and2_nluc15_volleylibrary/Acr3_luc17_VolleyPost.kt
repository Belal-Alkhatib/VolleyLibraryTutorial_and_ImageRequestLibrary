package com.example.and2_nluc15_volleylibrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.example.and2_nluc15_volleylibrary.app.MySingnletion
import com.example.and2_nluc15_volleylibrary.databinding.ActivityAcr3Luc17VolleyPostBinding
import kotlinx.android.synthetic.main.activity_acr3_luc17_volley_post.*
import org.json.JSONObject

class Acr3_luc17_VolleyPost : AppCompatActivity() {

    val URL_OBJ = "https://jsonplaceholder.typicode.com/posts"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acr3_luc17_volley_post)



        btnPost.setOnClickListener {
            postToServer()
        }
        btnLuc18.setOnClickListener {
            val i = Intent(this,Luc18_RetryPolicy::class.java)
            startActivity(i)
        }

    }

    fun postToServer(){
        val stringRequest = object: StringRequest(Request.Method.POST,URL_OBJ,
            { response ->
                Log.e("hzm",response)
                val obj = JSONObject(response)
                    tvUserId.text = obj.getString("userId")
                    tvTitle.text = obj.getString("title")
                    tvBody.text = obj.getString("body")
            },
            { error ->
                Log.e("hzm",error.message.toString())
            }

        ){
            override fun getParams(): MutableMap<String, String>? {
                val map = HashMap<String,String>()
                    map["userId"] = "A"
                    map["title"] = "Bilal"
                    map["body"] = "Hello World"
                return map
            }

            override fun getHeaders(): MutableMap<String, String> {
                val map = HashMap<String,String>()
                    map["Content-Type"] = "any" //اسماء الكي انا مفترضهم ولكنهم ياتوا بالdoc
                    map["apiKey"] = "any"
                    map["Access-Token"] = "any"
                return map

            }
            override fun getPriority(): Priority {
                return Priority.HIGH
            }
        }
        MySingnletion.getInstence()!!.addToRequestQueue(stringRequest,"BI")

    }

    override fun onStop() {
        super.onStop()
        MySingnletion.getInstence()!!.cancelPendingRequests("BI")
    }
}