package com.example.and2_nluc15_volleylibrary.app

import android.app.Application
import android.text.TextUtils
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.Volley
import com.example.and2_nluc15_volleylibrary.model.LruBitmapCache
import com.facebook.drawee.backends.pipeline.Fresco

class MySingnletion:Application() {
    val TAG = "hzm"
    private var mRequestQueue:RequestQueue? = null
    private var mImageLoader:ImageLoader? = null

    companion object{
        private var mInstence: MySingnletion?= null

        fun getInstence(): MySingnletion?{
            return mInstence
        }
    }

    override fun onCreate() {
        super.onCreate()
        //من المحاضرة19 جزئية الFresco لقراءة الصور
        Fresco.initialize(this)
        //*******
        mInstence = this
    }
    //****************
    private fun getRequestQueue():RequestQueue?{ // تعمل على انشاء طابور الطلبات في حال لم ينشأ
        if(mRequestQueue == null){
            mRequestQueue = Volley.newRequestQueue(applicationContext)
        }
        return mRequestQueue
    }
    //****************
    fun <T> addToRequestQueue(req:Request<T>,tag:String){
        req.tag = if(TextUtils.isEmpty(tag)) TAG else tag
        getRequestQueue()!!.add(req)
    }
    //****************
    fun <T> addToRequestQueue(req:Request<T>){
        req.tag = TAG
        getRequestQueue()!!.add(req)
    }
    //****************
    fun cancelPendingRequests(tag:Any?){
        if(mRequestQueue != null){
            mRequestQueue!!.cancelAll(tag)
        }

        }

    //*********** من المحاضرة19 طلب الصور عبر Network Image View
    fun getImageLoader():ImageLoader?{
        getRequestQueue()
        if(mImageLoader == null){
            mImageLoader = ImageLoader(mRequestQueue,LruBitmapCache())
        }
        return mImageLoader
    }



}