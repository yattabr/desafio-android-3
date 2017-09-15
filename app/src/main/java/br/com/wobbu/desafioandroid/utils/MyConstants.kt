package br.com.wobbu.desafioandroid.utils

/**
 * Created by eduardoewerton on 14/09/17.
 */
class MyConstants {

    var GET_REPOSITORIES = "https://api.github.com/search/repositories?q=language:Java&sort=stars&page=%d"
    var GET_PULL_REQUEST = "https://api.github.com/repos/%s/%s/pulls"

    var LIST_REPOSITORIES_CACHE = "listCache"
    var PULL_REQUEST_CACHE = "pullRequestCache"

}