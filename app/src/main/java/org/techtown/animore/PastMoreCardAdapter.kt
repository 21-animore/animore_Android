package org.techtown.animore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class PastMoreCardAdapter(private val context : Context, var dataPasts: MutableList<PastMoreCardData>) : RecyclerView.Adapter<PastMoreCardAdapter.Holder>(){
    override fun getItemCount(): Int {
        //Log.w("태그", datas.size.toString())
        return dataPasts.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PastMoreCardAdapter.Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.pastcard_layout, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: PastMoreCardAdapter.Holder, position: Int) {
        holder?.bind(dataPasts[position], context)
        //Log.e("태그", position.toString())
    }

    inner class Holder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val cardview = itemView.findViewById<CardView>(R.id.past_card_more_view)
        val fail = itemView.findViewById<ImageView>(R.id.past_card_more_fail)
        val success = itemView.findViewById<ImageView>(R.id.past_card_more_success)


        /*
        //색만 바뀜
        val tv_achieve_count = itemView.findViewById<TextView>(R.id.어쩌구)
        val tv_start_date_title = itemView.findViewById<TextView>(R.id.어쩌구)
        val tv_end_date_title = itemView.findViewById<TextView>(R.id.어쩌구)

        //색 내용 다 바뀜
        val tv_mission_name = itemView.findViewById<TextView>(R.id.어쩌구)
        val tv_mission_category_eng = itemView.findViewById<TextView>(R.id.어쩌구)
        val tv_mission_category_kor = itemView.findViewById<TextView>(R.id.어쩌구)
        val tv_process = itemView.findViewById<TextView>(R.id.어쩌구)
        val tv_process_count = itemView.findViewById<TextView>(R.id.어쩌구)
        val tv_count_slash = itemView.findViewById<TextView>(R.id.어쩌구)
        val tv_total_count = itemView.findViewById<TextView>(R.id.어쩌구)
        val tv_mission_content = itemView.findViewById<TextView>(R.id.어쩌구)
        val tv_bottom_sentence = itemView.findViewById<TextView>(R.id.어쩌구)
        val tv_count_num_behind = itemView.findViewById<TextView>(R.id.어쩌구)

        //이미지 바뀜
        val stroke = itemView.findViewById<ImageView>(R.id.어쩌구)
        val im g= itemView.findViewById<ImageView>(R.id.어쩌구)

         */


        fun bind(PastMoreCardData: PastMoreCardData, context: Context) {
            if(PastMoreCardData.success_flag === true){
                //성공 카드일 경우
                fail.setVisibility(View.GONE)

                if(PastMoreCardData.index === 0){

                }else if(PastMoreCardData.index === 1){

                }else if(PastMoreCardData.index === 2){

                }else if(PastMoreCardData.index === 3){

                }else if(PastMoreCardData.index === 4){

                }

            }else{
                //실패 카드일 경우
                success.setVisibility(View.GONE)

                if(PastMoreCardData.index === 0){

                }else if(PastMoreCardData.index === 1){

                }else if(PastMoreCardData.index === 2){

                }else if(PastMoreCardData.index === 3){

                }else if(PastMoreCardData.index === 4){

                }
            }
        }
    }


}