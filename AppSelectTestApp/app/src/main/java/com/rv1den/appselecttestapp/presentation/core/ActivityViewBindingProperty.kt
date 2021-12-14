package com.rv1den.appselecttestapp.presentation.core

import android.os.Handler
import android.os.Looper
import androidx.annotation.MainThread
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ActivityViewBindingProperty<T : ViewBinding>(
    private val viewBinder: (AppCompatActivity) -> T
) : ReadOnlyProperty<AppCompatActivity, T> {

    private var viewBinding: T? = null
    private val lifecycleObserver = BindingLifecycleObserver()

    @MainThread
    override fun getValue(thisRef: AppCompatActivity, property: KProperty<*>): T {
        this.viewBinding?.let { return it }
        thisRef.lifecycle.addObserver(lifecycleObserver)
        return viewBinder(thisRef).also { vb -> this.viewBinding = vb }
    }

    private inner class BindingLifecycleObserver : DefaultLifecycleObserver {

        private val mainHandler = Handler(Looper.getMainLooper())

        @MainThread
        override fun onDestroy(owner: LifecycleOwner) {
            owner.lifecycle.removeObserver(this)
            mainHandler.post {
                viewBinding = null
            }
        }
    }
}

@Suppress("unused")
inline fun <reified T : ViewBinding> AppCompatActivity.viewBinding(
    noinline viewBinder: (AppCompatActivity) -> T
): ReadOnlyProperty<AppCompatActivity, T> {
    return ActivityViewBindingProperty(viewBinder)
}
