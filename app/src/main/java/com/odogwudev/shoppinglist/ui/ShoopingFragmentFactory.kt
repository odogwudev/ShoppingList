package com.odogwudev.shoppinglist.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.odogwudev.shoppinglist.adapters.ImageAdapter
import javax.inject.Inject

class ShoopingFragmentFactory @Inject constructor(
    private val imageAdapter: ImageAdapter
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            ImagePickFragment::class.java.name -> ImagePickFragment(imageAdapter)
            else -> super.instantiate(classLoader, className)
        }
        return super.instantiate(classLoader, className)
    }
}