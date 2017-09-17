package br.com.wobbu.desafioandroid

import br.com.wobbu.desafioandroid.models.PullRequest
import org.junit.Assert
import org.junit.Test

/**
 * Created by eduardoewerton on 17/09/17.
 */
class PullRequestUnitTest {

    @Test()
    fun requestResultCantBeNull() {
        Assert.assertNotNull(mockPullRequest())
    }

    @Test()
    fun requestURLCantBeNullOrEmpty() {
        Assert.assertNotNull(mockPullRequest()[0].url)
    }

    @Test()
    fun requestURLCantBeEmpty() {
        Assert.assertTrue(mockPullRequest()[0].url.isNotEmpty())
    }

    @Test()
    fun requestListCantBeEmpty() {
        Assert.assertTrue(mockPullRequest().isNotEmpty())
    }

    // MOCKS PARA TESTE
    fun mockPullRequest(): ArrayList<PullRequest> {
        var request = PullRequest()
        var requestList = ArrayList<PullRequest>()
        request.title = "Desafio Android"
        request.body = "Mock para Testes"
        request.url = "http://google.com"
        request.user = mockUser()
        request.authorAssociation = "ADMIN"
        request.closedIssues = "10"
        request.openIssues = "20"
        requestList.add(request)

        return requestList
    }

    fun mockUser(): PullRequest.User {
        var owner = PullRequest.User()
        owner.login = "Wobbu"
        owner.id = "1"
        return owner
    }
}