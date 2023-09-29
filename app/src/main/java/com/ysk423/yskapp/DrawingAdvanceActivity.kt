package com.ysk423.yskapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class DrawingAdvanceActivity : AppCompatActivity() {

    private var drawingAdvanceView: DrawingAdvanceView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawing_advance)
        drawingAdvanceView = findViewById(R.id.drawingAdvanceView)
        drawingAdvanceView?.setSizeForBrush(20.toFloat())

        //ブラシサイズアイコンのクリック
        val ib_brush: ImageButton = findViewById(R.id.ibDrawingAdvanceBrush)
        ib_brush.setOnClickListener {
            showBrushSizeChooserDialog()
        }

    }

    private fun showBrushSizeChooserDialog(){
        var brushDialog = Dialog(this)
        brushDialog.setContentView(R.layout.dialog_drawing_advance_brush_size)
        brushDialog.setTitle("Brush size:")

        val smallBtn: ImageButton = brushDialog.findViewById(R.id.ib_drawing_advance_small_brush)
        smallBtn.setOnClickListener{
            drawingAdvanceView?.setSizeForBrush(10.toFloat())
            brushDialog.dismiss()
        }

        val mediumBtn: ImageButton = brushDialog.findViewById(R.id.ib_drawing_advance_medium_brush)
        mediumBtn.setOnClickListener{
            drawingAdvanceView?.setSizeForBrush(20.toFloat())
            brushDialog.dismiss()
        }

        val largeBtn: ImageButton = brushDialog.findViewById(R.id.ib_drawing_advance_large_brush)
        largeBtn.setOnClickListener{
            drawingAdvanceView?.setSizeForBrush(30.toFloat())
            brushDialog.dismiss()
        }

        brushDialog.show()

    }


}


