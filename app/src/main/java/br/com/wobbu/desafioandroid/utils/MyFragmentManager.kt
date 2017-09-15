package br.com.wizsolucoes.copa_prototipo.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

/**
 * Created by eduardoewerton on 14/09/17.
 */
class MyFragmentManager(val context: FragmentActivity, val container: Int) {

    fun addFragment(fragment: Fragment) {
        context.supportFragmentManager.beginTransaction()
                .add(container, fragment).addToBackStack(fragment.toString())
                .commit()
    }

    fun closeFragment(fragment: Fragment) {
        fragment.childFragmentManager.popBackStack()
    }
}