package com.ahmedtikiwa.liam.ui.videodetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.ahmedtikiwa.liam.databinding.FragmentVideoDetailBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


class VideoDetailFragment : Fragment() {

    private lateinit var binding: FragmentVideoDetailBinding

    private lateinit var youTubePlayerView: YouTubePlayerView

    val args by navArgs<VideoDetailFragmentArgs>()

    private val viewModel: VideoDetailViewModel by lazy {
        val activity = requireNotNull(activity) {
            "You can only access the viewModel after onActivityCreated"
        }
        ViewModelProviders.of(
            this,
            VideoDetailViewModel.Factory(activity.application, args.videoItem)
        ).get(VideoDetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentVideoDetailBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner

        binding.viewModel = viewModel

        youTubePlayerView = binding.youtubePlayerView
        viewLifecycleOwner.lifecycle.addObserver(youTubePlayerView)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        youTubePlayerView.release()
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.title = args.videoItem.name
    }
}