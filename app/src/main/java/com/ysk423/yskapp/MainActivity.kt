package com.ysk423.yskapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    //recyclerViewの変数を用意
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //recyclerViewの表示
        recyclerView = findViewById(R.id.rvMainMenu)
        recyclerView.adapter = MainRecyclerAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}

/*

ネーミングルール
ID名：
ローワーキャメルケースを使うこと
nameNameName

drawable,layout名:
スネークケースを使うこと
layout_layout_layout

*/
