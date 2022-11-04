package com.ysk423.yskapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class UranaiActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uranai)

        //要素の取得
        var tvUranaiResult:TextView = findViewById(R.id.tvUranaiResult)
        var btnUranai :Button = findViewById(R.id.btnUranai)

        //クリック処理
        btnUranai.setOnClickListener{

            var uranai = arrayOf("大吉","中吉","小吉","吉","末吉","凶","大凶","スカ",)

            //乱数用意
            var num = Random().nextInt(uranai.count())

            //結果を入力
            tvUranaiResult.text =uranai.get(num)
        }



    }
}