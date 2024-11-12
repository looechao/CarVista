package com.example.cardemo.adapter

import android.content.Context
import android.media.tv.TvContract.Channels.Logo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cardemo.LogoActivity
import com.example.cardemo.R
import com.example.cardemo.bean.LogoBean
import com.example.cardemo.bean.Result
import com.example.cardemo.databinding.ItemLogoBinding
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.NonDisposableHandle
import kotlinx.coroutines.NonDisposableHandle.parent

class LogoAdapter(var ctx: Context, var mDatas:MutableList<Result>): RecyclerView.Adapter<LogoAdapter.LogoHolder>() {

    var inflater = LayoutInflater.from(ctx)

    class LogoHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var binding:ItemLogoBinding? = null

    }

    fun addDatas(list: List<Result>?){
        if (list!=null) {
            mDatas.addAll(list)
            notifyDataSetChanged()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogoHolder {
        val binding:ItemLogoBinding = DataBindingUtil
            .inflate(inflater, R.layout.item_logo, parent, false)
        val holder = LogoHolder(binding.root)

        holder.binding = binding

        return holder
    }

    override fun getItemCount(): Int {
        return mDatas.size
    }

    @OptIn(InternalCoroutinesApi::class)
    override fun onBindViewHolder(holder: LogoHolder, position: Int) {
        val bean = mDatas.get(position)
        holder.binding?.item = bean
    }
}