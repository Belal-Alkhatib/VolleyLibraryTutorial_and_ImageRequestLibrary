package com.example.and2_nluc15_volleylibrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.android.volley.toolbox.ImageLoader
import com.bumptech.glide.Glide
import com.example.and2_nluc15_volleylibrary.app.MySingnletion
import kotlinx.android.synthetic.main.activity_luc19_image_request.*

class Luc19_ImageRequest : AppCompatActivity() {
    val IMAGE_URL = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg" //رابط الصورة التي تريد قراءتها
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_luc19_image_request)

        // على طريقة الNetwork
        val imageLoader:ImageLoader = MySingnletion.getInstence()!!.getImageLoader()!!
        img.setImageUrl(IMAGE_URL,imageLoader)

        btnPicasso.setOnClickListener {
            val i = Intent(this,Luc19_picasso::class.java)
            startActivity(i)
        }

        //********************************** Glide  ***********************************
        //1. نضيف الimplementation
        //2. نضيف imageView
        //3. نكتب سطر الكود

        Glide.with(this).load(IMAGE_URL).into(imgGlide)

        //********************************** Fresco  ***********************************
        /*
        * لو كنت تريد تحميل فقط صورة فالمكتبات الافضل
        هي السابقة اما هذه فيها امكانيات مثل الGIF والتعدبل على الصور
        1. نضيف ال implementation
        *2. عمل initialize في كلاس الapp وهو عندي ال Signletion
        3.SimpleDraweeView اضافة الصورة للتصميم وهي نوع خاص
           وعمل بليس هولدر
        * 4. سطر العرض
        * */

        imgFresco.setImageURI(IMAGE_URL)


        //**********************************  Kotlin Coroutines  ***********************************
        /*
        * نضيف رابط الimplementation
        * اضافة imageView عادية بالتصميم
        * السطر البرمجي
        * */

        imageCoil.load(IMAGE_URL)
    }
}