package br.com.wobbu.desafioandroid.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.OnScrollListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import br.com.wizsolucoes.copa_prototipo.utils.MyFragmentManager
import br.com.wobbu.desafioandroid.R
import br.com.wobbu.desafioandroid.adapters.GitHubAdapter
import br.com.wobbu.desafioandroid.controllers.GitHubController
import br.com.wobbu.desafioandroid.models.Repositories
import kotlinx.android.synthetic.main.fragment_github.*
import kotlinx.android.synthetic.main.fragment_github.view.*
import kotlinx.android.synthetic.main.view_alert.view.*

/**
 * Created by eduardoewerton on 13/09/17.
 */
class GitHubFragment : Fragment() {

    lateinit var controller: GitHubController
    lateinit var mView: View
    lateinit var mLayoutManager: LinearLayoutManager
    lateinit var repositoriesList: ArrayList<Repositories.RepositoryItems>
    lateinit var adapter: GitHubAdapter

    var loading: Boolean = true
    var pastVisiblesItems: Int = 0
    var visibleItemCount: Int = 0
    var totalItemCount: Int = 0
    var pageCount: Int = 1

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater!!.inflate(R.layout.fragment_github, container, false)

        controller = GitHubController(activity)
        repositoriesList = ArrayList<Repositories.RepositoryItems>()

        mLayoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        mView.recyclerView.layoutManager = mLayoutManager
        mView.recyclerView.addOnScrollListener(endlessRecyclerView)

        mView.bt_ok.setOnClickListener(okClick)

        getRepositories(pageCount)

        return mView
    }

    fun getRepositories(pageCount: Int) {
        mView.viewAlert.visibility = View.GONE
        controller.getRepositoriesAPI(pageCount) { result ->
            if (result.items!!.isNotEmpty()) {
                txt_empty_list.visibility = View.GONE
                if (pageCount > 1) {
                    addListToAdapter(result)
                } else {
                    setResultRecyclerView(result)
                }
            } else {
                txt_empty_list.visibility = View.VISIBLE
            }
        }
    }

    fun setResultRecyclerView(result: Repositories) {
        repositoriesList = result.items!!
        adapter = GitHubAdapter(context, result.items!!) {
            click ->
            MyFragmentManager(activity, R.id.fragmentContainer).addFragment(PullRequestFragment(click.name, click.owner!!.login))
        }
        mView.recyclerView.adapter = adapter
        mView.loading.hide()
        loading = true
    }

    fun addListToAdapter(result: Repositories) {
        adapter.addList(result.items!!)
        mView.loading.hide()
        loading = true
    }

    val okClick = View.OnClickListener {
        mView.viewAlert.visibility = View.GONE
    }

    val endlessRecyclerView = object : OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
            if (dy > 0) {
                visibleItemCount = mLayoutManager.getChildCount();
                totalItemCount = mLayoutManager.getItemCount();
                pastVisiblesItems = mLayoutManager.findFirstVisibleItemPosition();

                if (loading) {
                    if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                        loading = false;
                        mView.loading.show()
                        pageCount += 1
                        getRepositories(pageCount)
                    }
                }
            }
        }
    }


}