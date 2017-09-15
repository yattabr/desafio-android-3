package br.com.wobbu.desafioandroid.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.wobbu.desafioandroid.R
import br.com.wobbu.desafioandroid.models.Repositories
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_repository.view.*

/**
 * Created by eduardoewerton on 13/09/17.
 */
class GitHubAdapter(var context: Context, var items: ArrayList<Repositories.RepositoryItems>, var click: (Repositories.RepositoryItems) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_repository, parent, false)
        return ViewHolder(context, view, click)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        var mHolder = holder as ViewHolder
        mHolder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addList(list: ArrayList<Repositories.RepositoryItems>) {
        for (item in list) {
            items.add(item)
        }
        this.notifyDataSetChanged()
    }

    class ViewHolder(var context: Context, itemView: View, var click: (Repositories.RepositoryItems) -> Unit) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        lateinit var item: Repositories.RepositoryItems

        fun bind(item: Repositories.RepositoryItems) {
            itemView.txt_repository_name.text = item.name
            itemView.txt_repository_description.text = item.description
            itemView.txt_fork.text = item.forks
            itemView.txt_star.text = item.stars

            itemView.txt_name.text = item.name
            itemView.txt_username.text = item.owner!!.login
            Glide.with(context).load(item.owner!!.avatarUrl).into(itemView.img_profile)

            this.item = item

            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            click(item)
        }
    }
}