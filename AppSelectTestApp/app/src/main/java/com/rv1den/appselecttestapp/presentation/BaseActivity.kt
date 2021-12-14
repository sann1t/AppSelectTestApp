package com.rv1den.appselecttestapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rv1den.appselecttestapp.navigation.container.ScreenContainerCoordinator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
abstract class BaseActivity(private val resId: Int) : AppCompatActivity() {

    @Inject
    lateinit var screenContainerCoordinator: ScreenContainerCoordinator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        screenContainerCoordinator.bind(this)
        setContentView(resId)
    }

    override fun onDestroy() {
        screenContainerCoordinator.unbind(this)
        super.onDestroy()
    }
}