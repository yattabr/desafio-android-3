package br.com.wobbu.desafioandroid.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import br.com.wizsolucoes.copa_prototipo.utils.MyToolbar
import br.com.wobbu.desafioandroid.R
import br.com.wobbu.desafioandroid.adapters.PullRequestAdapter
import br.com.wobbu.desafioandroid.controllers.PullRequestController
import br.com.wobbu.desafioandroid.models.PullRequest
import kotlinx.android.synthetic.main.fragment_github.view.*
import kotlinx.android.synthetic.main.toolbar.view.*
import kotlinx.android.synthetic.main.view_alert.view.*

/**
 * Created by eduardoewerton on 14/09/17.
 */
class PullRequestFragment(var repositoryName: String, var repositoryOwner: String) : Fragment() {

    lateinit var controller: PullRequestController
    lateinit var mView: View

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater!!.inflate(R.layout.fragment_pull_request, container, false)

        controller = PullRequestController(activity, repositoryName, repositoryOwner)
        mView.recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        mView.bt_ok.setOnClickListener(okClick)

        MyToolbar().initToolbar(this, mView.toolbar, repositoryName)



        getPullRequest()

        return mView
    }

    fun getPullRequest() {
        controller.getPullRequestAPI { result ->
            setResultRecyclerView(result)
        }
    }

    fun setResultRecyclerView(result: Array<PullRequest>) {
        mView.recyclerView.adapter = PullRequestAdapter(context, result)
        mView.loading.hide()
    }

    val okClick = View.OnClickListener {
        mView.viewAlert.visibility = View.GONE
    }

}