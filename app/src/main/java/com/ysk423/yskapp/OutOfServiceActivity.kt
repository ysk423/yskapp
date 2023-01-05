package com.ysk423.yskapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class OutOfServiceActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_out_of_service)

        //要素取得
        val btnOutOfService : Button = findViewById(R.id.btnOutOfService)

        //ボタン操作
        btnOutOfService.setOnClickListener {
            finish()
        }

    }

}