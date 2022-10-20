package com.dev.jocey.testunsplash.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import butterknife.BindView
import butterknife.ButterKnife
import com.dev.jocey.testunsplash.R
import com.dev.jocey.testunsplash.api.models.CollectionModel
import com.dev.jocey.testunsplash.util.GlideLoader.Companion.showImageInGlide

class AdapterPhoto(private var clickListener: OnClickViewListener) :
    RecyclerView.Adapter<AdapterPhoto.VH>() {
    private val data: MutableList<CollectionModel> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_photo, parent, false)
        return VH(view, clickListener)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearAndAddAll(data: List<CollectionModel>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addAll(data: List<CollectionModel>) {
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    class VH(private val itemView: View, private var clickListener: OnClickViewListener) :
        ViewHolder(itemView) {
        @BindView(R.id.ll_all_item)
        lateinit var llAllItem: LinearLayout

        @BindView(R.id.iv_photo)
        lateinit var ivPhoto: ImageView

        @BindView(R.id.tv_user_name)
        lateinit var tvUserName: TextView

        init {
            ButterKnife.bind(this, itemView)
        }

        fun bind(model: CollectionModel) {
            var url = model.urls?.small
            showImageInGlide(ivPhoto, url)
            tvUserName.text = "${model.user?.first_name} ${model.user?.last_name ?: ""}"
            llAllItem.setOnClickListener { clickListener.click(model) }
        }

    }
}
