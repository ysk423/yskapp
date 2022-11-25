package com.ysk423.yskapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class BackgroundMusicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_background_music)

        //viewを取得->ボタンを押したら文字を赤色
        val tv: TextView = findViewById(R.id.tvBackgroundMusic)
        val btn: Button = findViewById(R.id.btnBackgroundMusic)

        btn.setOnClickListener {
            tv.setTextColor(Color.RED)
        }
    }
}
