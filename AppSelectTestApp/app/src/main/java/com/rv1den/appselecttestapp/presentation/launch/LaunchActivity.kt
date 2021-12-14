package com.rv1den.appselecttestapp.presentation.launch

import android.os.Bundle
import androidx.activity.viewModels
import com.rv1den.appselecttestapp.R
import com.rv1den.appselecttestapp.presentation.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LaunchActivity: BaseActivity(R.layout.activity_launch) {

    private val viewModel: LaunchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel
    }
}