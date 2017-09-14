package br.com.wobbu.desafioandroid

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.fragment_github.view.*

/**
 * Created by eduardoewerton on 13/09/17.
 */
class GitHubFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_github, container, false)

        view.recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        view.recyclerView.adapter = GitHubAdapter()
        return view
    }

}