package com.ahmedtikiwa.liam.ui.videolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ahmedtikiwa.liam.R
import com.ahmedtikiwa.liam.databinding.VideoListItemBinding
import com.ahmedtikiwa.liam.domain.VideoItem

class VideoListAdapter(val listener: VideoListItemAdapterListener) :
    RecyclerView.Adapter<VideoListAdapter.ViewHolder>() {

    var videos: List<VideoItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val withDataBinding : VideoListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            ViewHolder.LAYOUT,
            parent,
            false
        )
        return ViewHolder(withDataBinding)
    }

    override fun getItemCount(): Int = videos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.video = videos[position]
            it.listener = listener
        }
    }

    class VideoListItemAdapterListener(val block: (VideoItem) -> Unit) {
        fun onClick(videoItem: VideoItem) = block(videoItem)
    }

    class ViewHolder(val viewDataBinding: VideoListItemBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {
        companion object {
            @LayoutRes
            val LAYOUT = R.layout.video_list_item
        }
    }
}