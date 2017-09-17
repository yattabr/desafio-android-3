package br.com.wobbu.desafioandroid

import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import br.com.wobbu.desafioandroid.controllers.GitHubController
import br.com.wobbu.desafioandroid.fragments.GitHubFragment
import br.com.wobbu.desafioandroid.models.Repositories
import org.junit.Assert
import org.junit.Test
import java.util.ArrayList

/**
 * Created by eduardoewerton on 17/09/17.
 */
class GitHubUnitTest {

    @Test()
    fun repositoriesPageNumberCantBeLessThanOne() {
        var controller = GitHubController(FragmentActivity())
        Assert.assertTrue(controller.getRepositoriesAPI(1) {})
    }

    @Test()
    fun repositoriesResultCantBeNull() {
        Assert.assertNotNull(mockRepositories())

    }

    @Test()
    fun repositoriesItemsCantBeEmpty() {
        Assert.assertTrue(mockRepositories().items!!.isNotEmpty())
    }

    // MOCKS PARA TESTE
    fun mockRepositories(): Repositories {
        var repo = Repositories()
        repo.totalCount = "1"
        repo.incompleteResults = false
        repo.items = mockRepositoriesItems()

        return repo
    }

    fun mockRepositoriesItems(): ArrayList<Repositories.RepositoryItems> {
        var itemsList = ArrayList<Repositories.RepositoryItems>()
        var items = Repositories.RepositoryItems()
        items.name = "Eduardo Ewerton"
        items.stars = "5"
        items.owner = mockOwner()
        items.description = "Lorem Ipsum"
        items.forks = "10"
        items.fullName = "Eduardo Ewerton"

        itemsList.add(items)

        return itemsList
    }

    fun mockOwner(): Repositories.OwnerItem {
        var owner = Repositories.OwnerItem()
        owner.login = "Wobbu"
        owner.id = "1"
        return owner
    }
}