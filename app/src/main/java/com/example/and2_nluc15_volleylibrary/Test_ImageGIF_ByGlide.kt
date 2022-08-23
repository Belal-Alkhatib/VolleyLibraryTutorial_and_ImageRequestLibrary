package com.example.and2_nluc15_volleylibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_luc19_image_request.*
import kotlinx.android.synthetic.main.activity_test_image_gif_by_glide.*

class Test_ImageGIF_ByGlide : AppCompatActivity() {
    val IMAGE_URL_GIF = "https://i.gifer.com/origin/cb/cba2e88b9187d3dfefe497008d317147.gif"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_image_gif_by_glide)

        Glide.with(this).load(IMAGE_URL_GIF).into(imgGlideGIF)

    }
}