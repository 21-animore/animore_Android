package org.techtown.animore

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class HomeMoreCardAdapter(val context: Context): RecyclerView.Adapter<HomeMoreCardAdapter.Holder>(){
    var homemoreitems = mutableListOf<HomeMoreCardData>()

    override fun getItemCount(): Int {
        return homemoreitems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.more_card_layout, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(homemoreitems[position], context)
    }

    inner class Holder(itemView: View):RecyclerView.ViewHolder(itemView) {

        var frontcard = itemView.findViewById<RelativeLayout>(R.id.more_card_view_front)
        var backcard = itemView.findViewById<RelativeLayout>(R.id.more_card_view_back)

        var mSetRightOut = AnimatorInflater.loadAnimator(itemView.context, R.animator.out_ani) as AnimatorSet
        var mSetLeftIn = AnimatorInflater.loadAnimator(itemView.context, R.animator.in_ani) as AnimatorSet


        /*원 그리기*/
        val calendarView: RecyclerView = itemView.findViewById(R.id.more_card_circle_recyclerview)
        val CircleAdapter = HomeMoreCardCircleAdapter()

        fun createCircle(count: Int, type:Int){

            var int = 1;
            var typestring = "";

            if(type === 0){
                typestring = "0-"
            }else if(type === 1){
                typestring = "1-"
            }else if(type === 2){
                typestring = "2-"
            }else if(type === 3){
                typestring = "3-"
            }else if(type === 4){
                typestring = "4-"
            }

            for(i in 0 until count){
                Log.d("타입이 안먹혀????", ""+typestring)
                CircleAdapter.items.add(""+typestring + int.toString())
                int ++;
            }

            for(i in 1..21-count){
                CircleAdapter.items.add(""+typestring + (int+50).toString())
                int ++;
            }

            calendarView.adapter = CircleAdapter
        }


        fun bind(HomeMoreCardData: HomeMoreCardData, context: Context) {

            /*-----------------------------------------뒤집는 애니메이션------------------------------------------*/

            backcard.visibility=View.GONE;

            frontcard.setOnClickListener {
                backcard.visibility=View.VISIBLE
                mSetRightOut.setTarget(frontcard)
                mSetLeftIn.setTarget(backcard)
                mSetRightOut.start()
                mSetLeftIn.start()
                val distance = 8000
                val scale: Float = context.resources.displayMetrics.density * distance
                frontcard.setCameraDistance(scale)
            }

            backcard.setOnClickListener {
                frontcard.visibility=View.VISIBLE
                mSetRightOut.setTarget(backcard)
                mSetLeftIn.setTarget(frontcard)
                mSetRightOut.start()
                mSetLeftIn.start()
                val distance = 8000
                val scale: Float = context.resources.displayMetrics.density * distance
                backcard.setCameraDistance(scale)
            }


            /*----------------------------------미션마다 다른 정보 우선 배정--------------------------------------------*/

            //HomeMoreCardData.어쩌구로 아래들에 대입(아마 뒷장도 있어서 더 많이 필요할 것)
            /*
            //카드에 보이게 되는 정보들
            tv_mission_name.text = MainCardData.mission_name
            tv_achieve_count.text = MainCardData.count.toString()
            tv_totalCount.text = "/"+MainCardData.dayDuring.toString()
            tv_index_count_num.text = MainCardData.count.toString()
            tv_start_date.text = MainCardData.start_date
            tv_end_date.text = MainCardData.end_date

            tv_mission_name.text = ""
            tv_achieve_count.text = ""
            tv_totalCount.text = ""
            tv_index_count_num.text = ""
            tv_start_date.text = ""
            tv_end_date.text = ""
             */

            /*----------------------------------타입마다 다른 정보 나중 배정--------------------------------------------*/

            if(HomeMoreCardData.flag === true){
                createCircle(HomeMoreCardData.count, HomeMoreCardData.index)
            }else if(HomeMoreCardData.flag === false){
                //캘린더 그리기
            }

            //유형별 달라지는 부분
            if(HomeMoreCardData.index === 0){

            }else if(HomeMoreCardData.index === 1){

            }else if(HomeMoreCardData.index === 2){

            }else if(HomeMoreCardData.index === 3){

            }else if(HomeMoreCardData.index === 4){

            }

            //다른 바뀌는 정보들은 앞 카드에서 받아와서 바꾸면 되나??
        }
    }
}