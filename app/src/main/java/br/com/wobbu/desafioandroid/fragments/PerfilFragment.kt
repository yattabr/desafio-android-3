package br.com.wobbu.desafioandroid.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.wobbu.desafioandroid.R.layout.fragment_my_profile

/**
 * Created by eduardoewerton on 13/09/17.
 */
class PerfilFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(fragment_my_profile, container, false)
    }
}