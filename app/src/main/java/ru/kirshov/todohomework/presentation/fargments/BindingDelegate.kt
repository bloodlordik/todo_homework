package ru.kirshov.todohomework.presentation.fargments

import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class BindingDelegate<BIDING : ViewBinding>(
    private val binder: (view: View) -> BIDING
) : ReadOnlyProperty<Fragment, BIDING> {
    private var viewBinding: BIDING? = null
    private val observer = BindingObserver()
    override fun getValue(thisRef: Fragment, property: KProperty<*>): BIDING {
        this.viewBinding?.let { return it }

        val view = thisRef.requireView()
        thisRef.lifecycle.addObserver(observer)
        return binder.invoke(view).also { vb -> this.viewBinding = vb }
    }

    private inner class BindingObserver() : DefaultLifecycleObserver {
        private val handler = Handler(Looper.getMainLooper())

        @MainThread
        override fun onDestroy(owner: LifecycleOwner) {
            owner.lifecycle.removeObserver(this)
            handler.post { viewBinding = null }
        }
    }
}