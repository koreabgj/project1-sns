package com.example.nbc_sns.ui.createPost

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView

class SnapHelperOneByOne(
    private val imageLocationListener: ImageLocationListener,
): LinearSnapHelper() {

    override fun findTargetSnapPosition(
        layoutManager: RecyclerView.LayoutManager?,
        velocityX: Int,
        velocityY: Int
    ): Int {

        if (layoutManager !is RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return RecyclerView.NO_POSITION
        }
        val currentView = findSnapView(layoutManager) ?: return RecyclerView.NO_POSITION

        val myLayoutManager = layoutManager as LinearLayoutManager

        val firstPosition = myLayoutManager.findFirstVisibleItemPosition()
        val lastPosition = myLayoutManager.findLastVisibleItemPosition()

        var currentPosition = layoutManager.getPosition(currentView)

        if (velocityX > 400) {
            currentPosition = lastPosition
        } else if (velocityX < 400) {
            currentPosition = firstPosition
        }

        imageLocationListener.changedTo(currentPosition)
        return currentPosition
    }
}