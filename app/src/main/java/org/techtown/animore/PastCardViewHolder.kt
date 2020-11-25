package org.techtown.animore

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PastCardViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    val card_success_flag = itemView.findViewById<TextView>(R.id.tv_successFlag)
    val card_name = itemView.findViewById<TextView>(R.id.tv_cardName)
    val achieve_count = itemView.findViewById<TextView>(R.id.tv_achieveCount)
    val total_count = itemView.findViewById<TextView>(R.id.tv_totalCount)
    val period = itemView.findViewById<TextView>(R.id.tv_totalCount)
    val card_category = itemView.findViewById<TextView>(R.id.img_card_category)

    fun bind(PastCardData: PastCardData) {
        if (PastCardData.card_success_flag === 0) {
            card_success_flag.text = "FAIL"
        } else if (PastCardData.card_success_flag === 1) {
            card_success_flag.text = "COMPLETE"
        }

        card_name.text = PastCardData.card_name;
        achieve_count.text = PastCardData.achieve_count.toString();
        total_count.text = PastCardData.total_count.toString();

        period.text = PastCardData.start_date.toString() + "/" + PastCardData.end_date.toString();
    }
}