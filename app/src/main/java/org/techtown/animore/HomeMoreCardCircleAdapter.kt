package org.techtown.animore

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class HomeMoreCardCircleAdapter: RecyclerView.Adapter<HomeMoreCardCircleAdapter.CalendarRvHolder>()  {
    val items = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarRvHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.circle_item, parent, false)
        return CalendarRvHolder(view)
    }

    override fun onBindViewHolder(holder: CalendarRvHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class CalendarRvHolder(view: View): RecyclerView.ViewHolder(view){

        val circle_item: TextView = itemView.findViewById(R.id.circle_item)

        fun bind(item: String){

            Log.d("나오나?", item)
            var dlfjgrpRkwlgodiehlsi = item.split("-")  //text를 -를 기준으로 자름
            var type = dlfjgrpRkwlgodiehlsi[0].toInt()
            var num = dlfjgrpRkwlgodiehlsi[1].toInt()

            if(type === 0){
                if(num > 50){
                    circle_item.background = itemView.resources.getDrawable(R.drawable.circle_stroke_guanicoe)
                    circle_item.text = (num-50).toString();
                    circle_item.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                }
                else{
                    circle_item.background = itemView.resources.getDrawable(R.drawable.circle_full_guanicoe)
                    circle_item.text = num.toString()
                    circle_item.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_guanicoe))
                }
            }else if(type === 1){
                if(num > 50){
                    circle_item.background = itemView.resources.getDrawable(R.drawable.circle_stroke_illipika)
                    circle_item.text = (num-50).toString();
                    circle_item.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                }
                else{
                    circle_item.background = itemView.resources.getDrawable(R.drawable.circle_full_illipika)
                    circle_item.text = num.toString()
                    circle_item.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_illipika))
                }
            }else if(type === 2){
                if(num > 50){
                    circle_item.background = itemView.resources.getDrawable(R.drawable.circle_stroke_harpseal)
                    circle_item.text = (num-50).toString();
                    circle_item.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                }
                else{
                    circle_item.background = itemView.resources.getDrawable(R.drawable.circle_full_harpseal)
                    circle_item.text = num.toString()
                    circle_item.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_harpseal))
                }
            }else if(type === 3){
                if(num > 50){
                    circle_item.background = itemView.resources.getDrawable(R.drawable.circle_stroke_java)
                    circle_item.text = (num-50).toString();
                    circle_item.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                }
                else{
                    circle_item.background = itemView.resources.getDrawable(R.drawable.circle_full_java)
                    circle_item.text = num.toString()
                    circle_item.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_java))
                }
            }else if(type === 4){
                if(num > 50){
                    circle_item.background = itemView.resources.getDrawable(R.drawable.circle_stroke_bengal)
                    circle_item.text = (num-50).toString();
                    circle_item.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                }
                else{
                    circle_item.background = itemView.resources.getDrawable(R.drawable.circle_full_bengal)
                    circle_item.text = num.toString()
                    circle_item.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_bengaltiger))
                }
            }
        }
    }
}