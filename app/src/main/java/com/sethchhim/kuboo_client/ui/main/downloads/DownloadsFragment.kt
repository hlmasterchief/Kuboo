package com.sethchhim.kuboo_client.ui.main.downloads

import android.os.Bundle
import android.view.View
import com.sethchhim.kuboo_client.Extensions.setConstraintBottomToTopOf
import com.sethchhim.kuboo_client.ui.main.downloads.adapter.DownloadListAdapter

class DownloadsFragment : DownloadsFragmentImpl1_Content() {

    init {
        isPathEnabled = false
        isPaginationEnabled = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        kubooRemote.addFetchListener(fetchListener)
    }

    override fun onButterKnifeBind(view: View) {
        super.onButterKnifeBind(view)
        contentSwipeRefreshLayout.setConstraintBottomToTopOf(downloadsTabLayout)
        contentSwipeRefreshLayout.setOnRefreshListener { populateDownloads() }
        contentRecyclerView.adapter = DownloadListAdapter(this)
        downloadsTabLayout.addOnTabSelectedListener(onTabSelectedListener)
    }

    override fun onStart() {
        super.onStart()
        populateDownloads()
    }

    override fun onDestroy() {
        super.onDestroy()
        kubooRemote.removeFetchListener(fetchListener)
    }
}