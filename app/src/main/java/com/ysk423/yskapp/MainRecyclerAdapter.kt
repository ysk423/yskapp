package com.ysk423.yskapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainRecyclerAdapter(var mContext: Context):
    RecyclerView.Adapter<MainRecyclerAdapter.ViewHolderItem>() {

    //リストを用意
    val yskappMenu = listOf(
        "Sand box",//position 0
        "Uranai",//position 1
        "Neko Punch",//position 2
        "tool4",//position 3
        "tool5",//position 4
        "tool6",//position 5
        "tool7",//position 6
        "tool8",//position 7
        "tool9",//position 8
        "tool10",//position 9
        "tool11",//position 10
        "tool12",//position 11
        "tool13",//position 12
        "tool14",//position 13
        "tool15"//position 14
    )
    //ここで一行分のレイアウトを(View)を生成
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRecyclerAdapter.ViewHolderItem {
        //レイアウトを取得（インフレート）
        val itemXml = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_one_menu_layout, parent, false)
        return ViewHolderItem(itemXml)
    }

    //Position番目のデータをレイアウト(xml)に表示するようセット
    override fun onBindViewHolder(holder: MainRecyclerAdapter.ViewHolderItem, position: Int) {
        holder.itemName.text = yskappMenu[position]
    }

    //データが何件あるのかをカウント
    override fun getItemCount(): Int {
        return yskappMenu.size
    }

    //Viewのインナークラス
    inner class ViewHolderItem(itemView: View):RecyclerView.ViewHolder(itemView){
        val itemName: TextView = itemView.findViewById(R.id.tvMainOneMenuLayout)

        //リストがクリックされたらPostionの条件のIntentを投げて、リストのターゲットActivityに遷移
        init{
            itemView.setOnClickListener {
                val position:Int = adapterPosition
                when(position){
                    0 -> mContext.startActivity(Intent(mContext,SandboxActivity::class.java))
                    1 -> mContext.startActivity(Intent(mContext,UranaiActivity::class.java))
                    2 -> mContext.startActivity(Intent(mContext,NekoPunchActivity::class.java))
                    //position -> mContext.startActivity(Intent(mContext,ActivityName::class.java))
                    //else ->mContext.startActivity(Intent(mContext,MainActivity2::class.java))
                }

            }
        }
    }

}