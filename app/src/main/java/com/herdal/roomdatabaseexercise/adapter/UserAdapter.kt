package com.herdal.roomdatabaseexercise.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.herdal.roomdatabaseexercise.R
import com.herdal.roomdatabaseexercise.model.User
import kotlinx.android.synthetic.main.user_row.view.*

class UserAdapter : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.user_row,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = userList.get(position)
        holder.itemView.textView_id.text = user.id.toString()
        holder.itemView.textView_email.text = user.email
        holder.itemView.textView_username.text = user.userName
        holder.itemView.textView_age.text = user.age.toString()
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user: List<User>) {
        this.userList = user
        notifyDataSetChanged()
    }
}