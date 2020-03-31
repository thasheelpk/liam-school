package com.ahmedtikiwa.liam.ui.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ahmedtikiwa.liam.R
import com.ahmedtikiwa.liam.databinding.FragmentStoreBinding
import com.ahmedtikiwa.liam.domain.StoreItem
import com.google.android.material.snackbar.Snackbar

class StoreFragment : Fragment() {

    private lateinit var binding: FragmentStoreBinding

    private var storeListAdapter: StoreListAdapter? = null

    private val viewModel: StoreViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentStoreBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner

        binding.viewModel = viewModel

        storeListAdapter = StoreListAdapter(
            StoreListAdapter.StoreListItemAdapterDownloadListener {
                viewModel.onDownloadClick(it)
            },
            StoreListAdapter.StoreListItemAdapterFavoriteListener {
                viewModel.onFavoriteClick(it)
            }
        )

        binding.root.findViewById<RecyclerView>(R.id.recyclerview_store_list).apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = storeListAdapter
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.storeList.observe(viewLifecycleOwner, Observer<List<StoreItem>> {
            storeListAdapter?.storeItems = it
        })

        viewModel.downloadItem.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                Snackbar.make(
                    binding.root,
                    getString(R.string.store_item_download_notification_text),
                    Snackbar.LENGTH_LONG
                ).show()
                viewModel.downloadItemComplete()
            }
        })

        viewModel.favoriteItem.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                Snackbar.make(
                    binding.root,
                    getString(R.string.store_item_favorite_notification_text),
                    Snackbar.LENGTH_LONG
                ).show()
                viewModel.favoriteItemComplete()
            }
        })
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.title_shop)
    }
}