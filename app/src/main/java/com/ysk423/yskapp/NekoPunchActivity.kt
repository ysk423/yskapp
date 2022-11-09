package com.ysk423.yskapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.ImageView

class NekoPunchActivity : AppCompatActivity() {

    //ここは起動と同時に処理される
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_neko_punch)
    }

    //今回は起動タイミングで動く必要はない
    //画面タッチ
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        var iv :ImageView = findViewById(R.id.ivNekoPunch)

        //条件分岐
        when(event?.action) { //?でnull許容
            //処理
            MotionEvent.ACTION_DOWN -> iv.setImageResource(R.drawable.nekopunch02) //画面タッチ
            MotionEvent.ACTION_MOVE -> iv.setImageResource(R.drawable.nekopunch03) //画面動かす
            MotionEvent.ACTION_UP -> iv.setImageResource(R.drawable.nekopunch01) //画面離す
        }
        return super.onTouchEvent(event)
    }
}