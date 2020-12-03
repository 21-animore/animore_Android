package org.techtown.animore

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.cardview.widget.CardView
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

            /*-------------------------------------------여기까지!-------------------------------------------------*/

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