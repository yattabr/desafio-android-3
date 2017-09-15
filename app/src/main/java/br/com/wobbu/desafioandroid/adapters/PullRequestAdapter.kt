package br.com.wobbu.desafioandroid.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import br.com.wobbu.desafioandroid.R
import br.com.wobbu.desafioandroid.models.PullRequest
import br.com.wobbu.desafioandroid.models.Repositories
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_repository.view.*

/**
 * Created by eduardoewerton on 13/09/17.
 */
class PullRequestAdapter(var context: Context, var items: Array<PullRequest>, var click: (PullRequest) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_pull_request, parent, false)
        return ViewHolder(context, view, click)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        var mHolder = holder as ViewHolder
        mHolder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(var context: Context, itemView: View, var click: (PullRequest) -> Unit) : RecyclerView.ViewHolder(itemView), OnClickListener {

        lateinit var item: PullRequest

        fun bind(item: PullRequest) {
            this.item = item

            itemView.txt_repository_name.text = item.user!!.login
            itemView.txt_repository_description.text = item.body

            itemView.txt_name.text = item.authorAssociation
            itemView.txt_username.text = item.user!!.login
            Glide.with(context).load(item.user!!.avatarUrl).into(itemView.img_profile)

            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            click(item)
        }
    }
}