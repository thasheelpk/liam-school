package com.ahmedtikiwa.liam.ui.videolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ahmedtikiwa.liam.R
import com.ahmedtikiwa.liam.databinding.FragmentVideoListBinding
import com.ahmedtikiwa.liam.domain.VideoItem

class VideoListFragment : Fragment() {

    private lateinit var binding: FragmentVideoListBinding

    private var videoListAdapter : VideoListAdapter? = null

    private val viewModel: VideoListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentVideoListBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner

        binding.viewModel = viewModel

        videoListAdapter = VideoListAdapter(VideoListAdapter.VideoListItemAdapterListener {
            viewModel.displayVideoDetail(it)
        })

        binding.root.findViewById<RecyclerView>(R.id.recyclerview_video_list).apply {
            layoutManager = LinearLayoutManager(context).apply {
                orientation = LinearLayoutManager.VERTICAL
            }
            adapter = videoListAdapter
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.videoList.observe(viewLifecycleOwner, Observer<List<VideoItem>> {
            videoListAdapter?.videos = it
        })

        viewModel.navigateToSelectedVideo.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController().navigate(
                    VideoListFragmentDirections.actionVideoListFragmentToVideoDetailFragment(it)
                )
                viewModel.displayVideoDetailComplete()
            }
        })
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.title_videos)
    }
}