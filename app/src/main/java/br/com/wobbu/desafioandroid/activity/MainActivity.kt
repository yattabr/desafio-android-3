package br.com.wobbu.desafioandroid.activity

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import br.com.wizsolucoes.copa_prototipo.utils.MySharedPreference
import br.com.wobbu.desafioandroid.R
import br.com.wobbu.desafioandroid.adapters.MainViewPagerAdapter
import br.com.wobbu.desafioandroid.fragments.GitHubFragment
import br.com.wobbu.desafioandroid.fragments.PerfilFragment
import devlight.io.library.ntb.NavigationTabBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listFragments = ArrayList<Fragment>()
        listFragments.add(GitHubFragment())
        listFragments.add(PerfilFragment())
        var adapter = MainViewPagerAdapter(supportFragmentManager, listFragments)
        viewPager.adapter = adapter

        var models = ArrayList<NavigationTabBar.Model>()
        models.add(NavigationTabBar.Model.Builder(resources.getDrawable(R.drawable.github), Color.parseColor("#FFFFFF")).title(getString(R.string.github)).build())
        models.add(NavigationTabBar.Model.Builder(resources.getDrawable(R.drawable.user), Color.parseColor("#FFFFFF")).title(getString(R.string.profile)).build())

        ntb.models = models
        ntb.setViewPager(viewPager)

        ntb.titleMode = NavigationTabBar.TitleMode.ACTIVE
        ntb.badgeGravity = NavigationTabBar.BadgeGravity.BOTTOM
        ntb.badgePosition = NavigationTabBar.BadgePosition.CENTER
        ntb.setIsBadged(true)
        ntb.setIsTitled(true)
        ntb.setIsTinted(true)
        ntb.setIsBadgeUseTypeface(true)
        ntb.setIsSwiped(true)
        ntb.badgeSize = 10f
        ntb.titleSize = 10f
        ntb.iconSizeFraction = 0.5f
    }
}
