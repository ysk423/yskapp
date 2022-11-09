package com.ysk423.yskapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PaintActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paint)

        val paintMyView: PaintMyView=findViewById(R.id.paintMyView)
        val btnPaintClear: Button =findViewById(R.id.btnPaintClear)

        btnPaintClear.setOnClickListener{
            paintMyView.clearCanvas()
        }
    }
}