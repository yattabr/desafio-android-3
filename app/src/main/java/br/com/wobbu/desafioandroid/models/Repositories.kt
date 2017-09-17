package br.com.wobbu.desafioandroid.models

import com.google.gson.annotations.SerializedName

/**
 * Created by eduardoewerton on 14/09/17.
 */
class Repositories {

    @SerializedName("total_count")
    var totalCount: String = ""
    @SerializedName("incomplete_results")
    var incompleteResults: Boolean = false
    @SerializedName("items")
    var items: ArrayList<RepositoryItems>? = null

    class RepositoryItems {
        @SerializedName("id")
        var id: String = ""
        @SerializedName("name")
        var name: String = ""
        @SerializedName("description")
        var description: String = ""
        @SerializedName("full_name")
        var fullName: String = ""
        @SerializedName("owner")
        var owner: OwnerItem? = null
        @SerializedName("stargazers_count")
        var stars: String = ""
        @SerializedName("forks_count")
        var forks: String = ""
    }

    class OwnerItem {
        @SerializedName("login")
        var login: String = ""
        @SerializedName("id")
        var id: String = ""
        @SerializedName("avatar_url")
        var avatarUrl: String = ""
    }
}