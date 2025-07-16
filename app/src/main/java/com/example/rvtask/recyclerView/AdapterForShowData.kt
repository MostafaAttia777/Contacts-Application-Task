package com.example.rvtask.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.rvtask.R
import com.example.rvtask.model.UsersData
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class AdapterForShowData(var list: ArrayList<UsersData>) :
    RecyclerView.Adapter<AdapterForShowData.Custom_View_Holder_Box>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Custom_View_Holder_Box {
        return Custom_View_Holder_Box(
            LayoutInflater.from(parent.context).inflate(R.layout.custom_show_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Custom_View_Holder_Box, position: Int) {
        var position_of_item = list[position]

        holder.name.text = position_of_item.name.toString()
        holder.phone.text = position_of_item.phone.toString()
        holder.dsc.text = position_of_item.description.toString()
        Picasso.get().load(position_of_item.image_link).into(holder.image)
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context,"welcome ${position_of_item.name} ",Toast.LENGTH_LONG).show()
        }
    }

    class Custom_View_Holder_Box(itemView: View) : ViewHolder(itemView) {

        var name = itemView.findViewById<TextView>(R.id.custom_name_view)
        var phone = itemView.findViewById<TextView>(R.id.custom_phone_view)
        var dsc = itemView.findViewById<TextView>(R.id.custom_description_view)
        var image = itemView.findViewById<CircleImageView>(R.id.custom_image_view)


    }

}