package br.com.wobbu.desafioandroid.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import br.com.wizsolucoes.copa_prototipo.utils.MyFragmentManager
import br.com.wizsolucoes.copa_prototipo.utils.MySharedPreference
import br.com.wobbu.desafioandroid.R
import br.com.wobbu.desafioandroid.adapters.GitHubAdapter
import br.com.wobbu.desafioandroid.controllers.GitHubController
import br.com.wobbu.desafioandroid.models.Repositories
import br.com.wobbu.desafioandroid.utils.MyConstants
import kotlinx.android.synthetic.main.fragment_github.view.*
import kotlinx.android.synthetic.main.view_alert.view.*

/**
 * Created by eduardoewerton on 13/09/17.
 */
class GitHubFragment : Fragment() {

    lateinit var controller: GitHubController
    lateinit var mView: View

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater!!.inflate(R.layout.fragment_github, container, false)

        controller = GitHubController(activity)
        mView.recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        mView.bt_ok.setOnClickListener(okClick)

        getRepositories()

        return mView
    }

    fun getRepositories() {
        val cache = MySharedPreference(activity).getString(MyConstants().LIST_REPOSITORIES_CACHE)
        if (cache.isNotEmpty()) {
            mView.viewAlert.visibility = View.VISIBLE
            controller.getListFromCache(cache) { result ->
                setResultRecyclerView(result)
            }
        } else {
            mView.viewAlert.visibility = View.GONE
            controller.getRepositoriesAPI { result ->
                setResultRecyclerView(result)
            }
        }
    }

    fun setResultRecyclerView(result: Repositories) {
        mView.recyclerView.adapter = GitHubAdapter(context, result.items!!) {
            click ->
            MyFragmentManager(activity, R.id.fragmentContainer).addFragment(PullRequestFragment(click.name, click.owner!!.login))
        }
        mView.loading.hide()
    }

    val okClick = View.OnClickListener {
        mView.viewAlert.visibility = View.GONE
    }

}