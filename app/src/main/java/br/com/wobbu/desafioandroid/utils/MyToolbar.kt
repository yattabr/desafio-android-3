package br.com.wizsolucoes.copa_prototipo.utils

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import kotlinx.android.synthetic.main.toolbar.view.*

/**
 * Created by eduardoewerton on 14/09/17.
 */

class MyToolbar {

    fun initToolbar(context: Context, toolbar: Toolbar, title: String) {
        var act = context as AppCompatActivity
        act.setSupportActionBar(toolbar)
        act.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        act.title = ""

        toolbar.setNavigationOnClickListener({ context.finish() })

        toolbar.txt_title_toolbar.text = title
    }

    fun initToolbar(context: Fragment, toolbar: Toolbar, title: String) {
        var act = context.activity as AppCompatActivity
        act.setSupportActionBar(toolbar)
        act.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        act.title = ""

        toolbar.setNavigationOnClickListener({ context.activity.supportFragmentManager.popBackStack() })

        toolbar.txt_title_toolbar.text = title
    }

    fun initToolbar(context: Context, toolbar: Toolbar) {
        var act = context as AppCompatActivity
        act.setSupportActionBar(toolbar)
        act.supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        if (context is AppCompatActivity) {
            toolbar.setNavigationOnClickListener({ context.finish() })
        } else if (context is Fragment) {
            toolbar.setNavigationOnClickListener({ context.supportFragmentManager.popBackStack() })
        }
    }

}