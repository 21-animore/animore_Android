package org.techtown.animore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import org.techtown.animore.nework.PastcardDataList

class PastCardAdapter : RecyclerView.Adapter<PastCardAdapter.Holder>(){
    var datas = mutableListOf<PastcardDataList>()

    override fun getItemCount(): Int {
        //Log.w("태그", datas.size.toString())
        return datas.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pastcard_layout, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(datas[position])
        //Log.e("태그", position.toString())
    }

    inner class Holder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val cardview = itemView.findViewById<CardView>(R.id.pastcard_view)
        val fail_cover = itemView.findViewById<ImageView>(R.id.pastcard_fail_cover)
        val success_stroke = itemView.findViewById<ImageView>(R.id.pastcard_success_stroke)
        val img = itemView.findViewById<ImageView>(R.id.pastcard_img_card_category)
        val back = itemView.findViewById<ImageView>(R.id.pastcard_background)

        val successful_flag = itemView.findViewById<TextView>(R.id.pastcard_tv_successFlag)
        val tv_mission_name = itemView.findViewById<TextView>(R.id.pastcard_tv_cardName)
        val tv_achieve_count = itemView.findViewById<TextView>(R.id.pastcard_tv_achieveCount)
        val tv_totalCount = itemView.findViewById<TextView>(R.id.pastcard_tv_totalCount)
        val tv_period = itemView.findViewById<TextView>(R.id.pastcard_tv_period)

        val tv_continue_count = itemView.findViewById<TextView>(R.id.pastcard_tv_continuecount)




        fun bind(PastCardData: PastcardDataList) {

            /*----------------------------------데이터 바인딩 부분--------------------------------------------*/
            //MainCardData.어쩌구로 아래들에 대입
            var bundle_mission_name = PastCardData.mission_name   //미션 이름
            var bundle_mission_category = PastCardData.mission_category.toString()   //인덱스(유형 구분)
            var bundle_continue_flag = PastCardData.continue_flag.toString()   //연속/일반 구분
            var bundle_mission_acheive_count = PastCardData.mission_acheive_count.toString()   //카운트(달성 횟수)
            var bundle_mission_period = PastCardData.mission_period.toString() //총 횟수(7,14,21)
            var bundle_mission_start_date = PastCardData.mission_start_date  //시작 날짜
            var bundle_mission_end_date = PastCardData.mission_end_date    //끝 날짜
            var bundle_mission_content = PastCardData.mission_content //미션별 소개 글
            var bundle_success_flag = PastCardData.success_flag.toString()    //성공 여부



            /*----------------------------------미션마다 다른 정보 우선 배정--------------------------------------------*/

            tv_mission_name.text = PastCardData.mission_name
            tv_achieve_count.text = PastCardData.mission_acheive_count.toString()
            tv_totalCount.text = "/"+PastCardData.mission_period.toString()

            var start_date = PastCardData.mission_start_date
            var end_date = PastCardData.mission_end_date
            val WkwmdskwlsWk1 = start_date.split("-")
            val WkwmdskwlsWk2 = end_date.split("-")
            val a = WkwmdskwlsWk1[1]
            val b = WkwmdskwlsWk1[2]
            val c = WkwmdskwlsWk2[1]
            val d = WkwmdskwlsWk2[1]
            val result = a+"/"+b+"~"+c+"/"+d

            tv_period.text=result

            /*----------------------------------타입마다 다른 정보 나중 배정--------------------------------------------*/


            //연속 여부에 따라 뒷 배경 글자 바꿈
            if(PastCardData.continue_flag === 1){
                if(PastCardData.mission_period === 7){
                    tv_continue_count.text = "7"
                }else if(PastCardData.mission_period === 14){
                    tv_continue_count.text = "14"
                }else if(PastCardData.mission_period === 21){
                    tv_continue_count.text = "21"
                }
            }
            else{
                tv_continue_count.text = ""
            }

            if(PastCardData.success_flag === 1){
                //성공 카드일 경우
                successful_flag.text = "COMPLETE"
                fail_cover.setVisibility(View.GONE)

                if(PastCardData.mission_category === 0){
                    back.setImageResource(R.drawable.ic_pastcard_back_guanicoe)
                    successful_flag.setTextColor(ContextCompat.getColor(itemView.context, R.color.complete_guanicoe))
                    img.setImageResource(R.drawable.ic_past_card_guanicoe)
                    success_stroke.setImageResource(R.drawable.ic_pastcard_stroke_guanicoe)
                    tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    tv_totalCount.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    tv_period.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    tv_continue_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.blur_guanicoe))
                }else if(PastCardData.mission_category === 1){
                    back.setImageResource(R.drawable.ic_pastcard_back_illipika)
                    successful_flag.setTextColor(ContextCompat.getColor(itemView.context, R.color.complete_illipika))
                    img.setImageResource(R.drawable.ic_past_card_illipika)
                    success_stroke.setImageResource(R.drawable.ic_pastcard_stroke_illipika)
                    tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    tv_totalCount.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    tv_period.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    tv_continue_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.blur_illipika))
                }else if(PastCardData.mission_category === 2){
                    back.setImageResource(R.drawable.ic_pastcard_back_harpseal)
                    successful_flag.setTextColor(ContextCompat.getColor(itemView.context, R.color.complete_harpseal))
                    img.setImageResource(R.drawable.ic_past_card_harpseal)
                    success_stroke.setImageResource(R.drawable.ic_pastcard_stroke_harpseal)
                    tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    tv_totalCount.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    tv_period.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    tv_continue_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.blur_harpseal))
                }else if(PastCardData.mission_category === 3){
                    back.setImageResource(R.drawable.ic_pastcard_back_java)
                    successful_flag.setTextColor(ContextCompat.getColor(itemView.context, R.color.complete_java))
                    img.setImageResource(R.drawable.ic_past_card_java)
                    success_stroke.setImageResource(R.drawable.ic_pastcard_stroke_java)
                    tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    tv_totalCount.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    tv_period.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    tv_continue_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.blur_java))
                }else if(PastCardData.mission_category === 4){
                    back.setImageResource(R.drawable.ic_pastcard_back_bengal)
                    successful_flag.setTextColor(ContextCompat.getColor(itemView.context, R.color.complete_bengaltiger))
                    img.setImageResource(R.drawable.ic_past_card_bengaltiger)
                    success_stroke.setImageResource(R.drawable.ic_pastcard_stroke_bengal)
                    tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    tv_totalCount.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    tv_period.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    tv_continue_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.blur_bengal))
                }

            }else{
                //실패 카드일 경우
                successful_flag.text = ""
                success_stroke.setVisibility(View.GONE)

                if(PastCardData.mission_category === 0){
                    back.setImageResource(R.drawable.ic_pastcard_back_guanicoe)
                    img.setImageResource(R.drawable.ic_past_card_guanicoe)
                    tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    tv_totalCount.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    tv_period.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    tv_continue_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.blur_guanicoe))
                }else if(PastCardData.mission_category === 1){
                    back.setImageResource(R.drawable.ic_pastcard_back_illipika)
                    img.setImageResource(R.drawable.ic_past_card_illipika)
                    tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    tv_totalCount.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    tv_period.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    tv_continue_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.blur_illipika))
                }else if(PastCardData.mission_category === 2){
                    back.setImageResource(R.drawable.ic_pastcard_back_harpseal)
                    img.setImageResource(R.drawable.ic_past_card_harpseal)
                    tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    tv_totalCount.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    tv_period.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    tv_continue_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.blur_harpseal))
                }else if(PastCardData.mission_category === 3){
                    back.setImageResource(R.drawable.ic_pastcard_back_java)
                    img.setImageResource(R.drawable.ic_past_card_java)
                    tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    tv_totalCount.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    tv_period.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    tv_continue_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.blur_java))
                }else if(PastCardData.mission_category === 4){
                    back.setImageResource(R.drawable.ic_pastcard_back_bengal)
                    img.setImageResource(R.drawable.ic_past_card_bengaltiger)
                    tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    tv_totalCount.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    tv_period.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    tv_continue_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.blur_bengal))
                }
            }

            //클릭한 카드의 데이터 상세 뷰로 보내기
            val bundle = bundleOf(
                    "bundle_mission_name" to bundle_mission_name,
                    "bundle_mission_category" to bundle_mission_category,
                    "bundle_continue_flag" to bundle_continue_flag,
                    "bundle_mission_acheive_count" to bundle_mission_acheive_count,
                    "bundle_mission_period" to bundle_mission_period,
                    "bundle_mission_start_date" to bundle_mission_start_date,
                    "bundle_mission_end_date" to bundle_mission_end_date,
                    "bundle_mission_content" to bundle_mission_content,
                    "bundle_success_flag" to bundle_success_flag)
            cardview.setOnClickListener {
                Navigation.findNavController(cardview).navigate(R.id.action_past_fragment_to_pastmore_fragment, bundle)
            }

        }
    }


}