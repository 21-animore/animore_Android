package org.techtown.animore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CalendarAdapter: RecyclerView.Adapter<CalendarAdapter.CalendarRvHolder>()  {
    val items = mutableListOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarRvHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.calendar_rv_item, parent, false)
        return CalendarRvHolder(view)
    }

    override fun onBindViewHolder(holder: CalendarRvHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class CalendarRvHolder(view: View): RecyclerView.ViewHolder(view){

        val txt_calendar_rv_item: TextView = itemView.findViewById(R.id.txt_calendar_rv_item)

        fun bind(item: Int){

            if(item == 0){
                txt_calendar_rv_item.background = itemView.resources.getDrawable(R.drawable.calendar_dotted_line)
                txt_calendar_rv_item.text="얍"
            }
            else{
                //실선 뷰 보여주기
                txt_calendar_rv_item.background = itemView.resources.getDrawable(R.drawable.calendar_solid_line)
            }
            txt_calendar_rv_item.text = item.toString()
        }
    }
}