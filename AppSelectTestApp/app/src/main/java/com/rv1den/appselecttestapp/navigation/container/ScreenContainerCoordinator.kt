package com.rv1den.appselecttestapp.navigation.container

import android.app.Activity
import javax.inject.Inject

open class ScreenContainerCoordinator (
    private val screenContainerMapper: ScreenContainerMapper
) {

    private var currentActivity: Activity? = null

    open fun bind(activity: Activity) {
        currentActivity = activity
    }

    open fun unbind(activity: Activity) {
        if (currentActivity === activity) {
            currentActivity = null
        }
    }

    open fun launchContainer(screenContainer: ScreenContainer) {
        currentActivity?.let { activity ->
            activity.startActivity(
                screenContainerMapper.map(activity, screenContainer)
            )
        }
    }

    open fun replace(screenContainer: ScreenContainer) {
        val previousActivity = currentActivity
        launchContainer(screenContainer)
        previousActivity?.finish()
    }
}