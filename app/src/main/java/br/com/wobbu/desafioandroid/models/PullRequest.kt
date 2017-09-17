package br.com.wobbu.desafioandroid.models

import com.google.gson.annotations.SerializedName

/**
 * Created by eduardoewerton on 14/09/17.
 */
class PullRequest {

    @SerializedName("html_url")
    var url: String = ""
    @SerializedName("title")
    var title: String = ""
    @SerializedName("body")
    var body: String = ""
    @SerializedName("open_issues")
    var openIssues: String = ""
    @SerializedName("closed_issues")
    var closedIssues: String = ""
    @SerializedName("user")
    var user: User? = null
    @SerializedName("author_association")
    var authorAssociation: String = ""

    class User {
        @SerializedName("login")
        var login: String = ""
        @SerializedName("id")
        var id: String = ""
        @SerializedName("avatar_url")
        var avatarUrl: String = ""
    }

}