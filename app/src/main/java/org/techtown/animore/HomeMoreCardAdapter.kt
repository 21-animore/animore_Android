package org.techtown.animore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class HomeMoreCardAdapter: RecyclerView.Adapter<HomeMoreCardAdapter.Holder>(){
    var homemoreitems = mutableListOf<HomeMoreCardData>()

    override fun getItemCount(): Int {
        return homemoreitems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.more_card_front_layout, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(homemoreitems[position])
    }

    inner class Holder(itemView: View):RecyclerView.ViewHolder(itemView) {

        /*-----------------근데 여기서 카드 이외의 것들을 가리면 적용이 안 되는거 아녀?---------------*/

        /*삭제 관련 부분*/
        val home_more_card_tv_deletefin = itemView.findViewById<TextView>(R.id.home_more_card_tv_deletefin)
        val home_more_card_btn_cancle = itemView.findViewById<ImageButton>(R.id.home_more_card_btn_cancle)
        val home_more_card_btn_reallygiveup = itemView.findViewById<ImageButton>(R.id.home_more_card_btn_reallygiveup)
        val home_more_card_tv_reallydelete = itemView.findViewById<TextView>(R.id.home_more_card_tv_reallydelete)
        val home_more_card_reallydelete = itemView.findViewById<ImageView>(R.id.home_more_card_reallydelete)

        /*상단바 관련 부분*/
        val home_more_card_topbar = itemView.findViewById<ImageView>(R.id.home_more_card_topbar)
        val home_more_card_tv_mission_name = itemView.findViewById<TextView>(R.id.home_more_card_tv_mission_name)
        val home_more_card_back_btn_to_add_frag = itemView.findViewById<ImageView>(R.id.home_more_card_back_btn_to_add_frag)


        fun bind(HomeMoreCardData: HomeMoreCardData) {

            /*-----------------포기하기 버튼 누르기 전까지 가리기---------------*/
            home_more_card_tv_deletefin.visibility = View.GONE      //삭제 완료 화면
            home_more_card_btn_cancle.visibility = View.GONE      //삭제 취소 버튼
            home_more_card_btn_reallygiveup.visibility = View.GONE      //삭제하기 버튼
            home_more_card_tv_reallydelete.visibility = View.GONE      //정말 삭제하시겠습니까?
            home_more_card_reallydelete.visibility = View.GONE      //삭제 불투명 창

            //유형별 달라지는 부분
            if(HomeMoreCardData.index === 0){

                /*상단바 관련 부분*/
                home_more_card_topbar.setImageResource(R.drawable.ic_top_bar_guanicoe)
                home_more_card_tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))     //내용변경
                home_more_card_back_btn_to_add_frag.setImageResource(R.drawable.ic_back_btn_guanicoe)

            }else if(HomeMoreCardData.index === 1){

                /*상단바 관련 부분*/
                home_more_card_topbar.setImageResource(R.drawable.ic_top_bar_illipika)
                home_more_card_tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))     //내용변경
                home_more_card_back_btn_to_add_frag.setImageResource(R.drawable.ic_back_btn_illipika)

            }else if(HomeMoreCardData.index === 2){

                /*상단바 관련 부분*/
                home_more_card_topbar.setImageResource(R.drawable.ic_top_bar_harpseal)
                home_more_card_tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))     //내용변경
                home_more_card_back_btn_to_add_frag.setImageResource(R.drawable.ic_back_btn_harpseal)

            }else if(HomeMoreCardData.index === 3){

                /*상단바 관련 부분*/
                home_more_card_topbar.setImageResource(R.drawable.ic_top_bar_javahornhawk)
                home_more_card_tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))     //내용변경
                home_more_card_back_btn_to_add_frag.setImageResource(R.drawable.ic_back_btn_java)

            }else if(HomeMoreCardData.index === 4){

                /*상단바 관련 부분*/
                home_more_card_topbar.setImageResource(R.drawable.ic_top_bar_bengaltiger)
                home_more_card_tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))     //내용변경
                home_more_card_back_btn_to_add_frag.setImageResource(R.drawable.ic_back_btn_bengal)

            }
        }
    }
}