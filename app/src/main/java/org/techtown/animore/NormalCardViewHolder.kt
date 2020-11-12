package org.techtown.animore

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NormalCardViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    val mission_name = itemView.findViewById<TextView>(R.id.tv_mission_name)
    val achieve_count = itemView.findViewById<TextView>(R.id.tv_achieve_count)
    val count_num = itemView.findViewById<TextView>(R.id.tv_count_num)
    val start_date = itemView.findViewById<TextView>(R.id.tv_start_date)
    val end_date = itemView.findViewById<TextView>(R.id.tv_end_date)

    fun bind(NormalCardData: NormalCardData) {
        mission_name.text = NormalCardData.mission_name;
        achieve_count.text = NormalCardData.achieve_count.toString();
        count_num.text = NormalCardData.count_num.toString();
        start_date.text = NormalCardData.start_date.toString();
        end_date.text = NormalCardData.end_date.toString();
    }
}