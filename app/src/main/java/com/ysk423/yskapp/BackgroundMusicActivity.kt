package com.ysk423.yskapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class BackgroundMusicActivity : AppCompatActivity() {

    //MediaPlayerを用意
    private lateinit var mp:MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_background_music)

        //viewを取得
        val tv: TextView = findViewById(R.id.tvBackgroundMusic)
        val btnStart: Button = findViewById(R.id.btnBackgroundMusicStart)
        val btnStop: Button = findViewById(R.id.btnBackgroundMusicStop)

        //ボタン押した時の操作
        btnStart.setOnClickListener {
            tv.text = "Music"
            mp.start()
            btnStart.isEnabled = false
            btnStop.isEnabled = true
        }

        btnStop.setOnClickListener {
            tv.text = "Music Stop"
            mp.pause()
            btnStart.isEnabled = true
            btnStop.isEnabled = false
        }

        //MediaPlayerを再生
        mp = MediaPlayer.create(this, R.raw.frog_piano)
        mp.isLooping = true
        mp.start()

        //アクティビティ起動直後はStartボタンをDisableに
        btnStart.isEnabled = false
    }

    //再開
    override fun onResume() {
        super.onResume()
        mp.start()
    }

    //一時停止
    override fun onPause() {
        super.onPause()
        mp.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mp.start()//終了、停止
        mp.release()//リリース
    }

}
