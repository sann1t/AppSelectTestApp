package com.rv1den.appselecttestapp.navigation.container

import android.content.Context
import android.content.Intent
import com.rv1den.appselecttestapp.presentation.main.MainActivity
import javax.inject.Inject

class ScreenContainerMapper {
    fun map(
        context: Context,
        screenContainer: ScreenContainer
    ): Intent {
        return when (screenContainer) {
            ScreenContainer.Main -> {
                Intent(context, MainActivity::class.java)
            }
        }
    }
}