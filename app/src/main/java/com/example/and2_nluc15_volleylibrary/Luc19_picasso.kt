package com.example.and2_nluc15_volleylibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.toolbox.ImageLoader
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_luc19_picasso.*

class Luc19_picasso : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val IMAGE_URL = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg" //رابط الصورة التي تريد قراءتها

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_luc19_picasso)
        /*
        * 1. تحتاج لاضافة رابط المكتبة اولا
        * 2. كتابة سطر الكود لتحميل الصورة فقط لا غير
        * 3. لاتحتاج لنوع معين من الimage فال imageView شغالة معها
        * 4. زور الموقع :ممكن عمل تحميل للصورة من الانترنت او ومن الاستس فولدر اللي في البليكيشن او تتعامل معها كملف
        * 5. يمكن تحميل المكتبة كملفjar او تضمنها عبر الرابط
        * */

        // (الimageView التي تريد عرض الصورة المحملة بها)   (رابط الصورة المراد تحميلها)
        Picasso.get().load(IMAGE_URL)     .into(imagePicasso)
    }
}