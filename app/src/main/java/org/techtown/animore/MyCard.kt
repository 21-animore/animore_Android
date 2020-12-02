package com.min.flipanimation

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import org.techtown.animore.R


class MyCard(val context: Context, var mylist: MutableList<MyDATA>):
RecyclerView.Adapter<MyCard.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.front_layout, parent, false)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return mylist.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(mylist[position], context)

    }


    inner class Holder(itemView: View):RecyclerView.ViewHolder(itemView){

        var myback = itemView.findViewById<ConstraintLayout>(R.id.myfront_layout)
        var mytext = itemView.findViewById<TextView>(R.id.front_text)

        var myback2 = itemView.findViewById<ConstraintLayout>(R.id.back_layout)
        var mytext2 = itemView.findViewById<TextView>(R.id.back_text)

        var mSetRightOut = AnimatorInflater.loadAnimator(context, R.animator.out_ani) as AnimatorSet
        var mSetLeftIn = AnimatorInflater.loadAnimator(context, R.animator.in_ani) as AnimatorSet

        fun bind(mydata: MyDATA, context: Context){

            myback.setOnClickListener {
                myback2.visibility=View.VISIBLE
                mSetRightOut.setTarget(myback)
                mSetLeftIn.setTarget(myback2)
                mSetRightOut.start()
                mSetLeftIn.start()
                val distance = 8000
                val scale: Float = context.resources.displayMetrics.density * distance
                myback2.setCameraDistance(scale)
                //myback.setCameraDistance(scale)
            }

            myback2.setOnClickListener {
                myback.visibility=View.VISIBLE
                mSetRightOut.setTarget(myback2)
                mSetLeftIn.setTarget(myback)
                mSetRightOut.start()
                mSetLeftIn.start()
                val distance = 8000
                val scale: Float = context.resources.displayMetrics.density * distance
                myback2.setCameraDistance(scale)
                myback.setCameraDistance(scale)
            }

            if(mydata.index ==1 ){
                myback.setBackgroundColor(getColor(context, R.color.stroke_illipika))
                myback2.setBackgroundColor(getColor(context, R.color.stroke_harpseal))
            }

            if(mydata.index ==2 ){
                myback.setBackgroundColor(getColor(context, R.color.stroke_harpseal))
                myback2.setBackgroundColor(getColor(context, R.color.stroke_bengaltiger))
            }

            mytext.text = mydata.str
            mytext2.text = mydata.str

        }
    }
}