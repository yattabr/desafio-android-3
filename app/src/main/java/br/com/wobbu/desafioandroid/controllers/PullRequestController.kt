package br.com.wobbu.desafioandroid.controllers

import android.content.Context
import br.com.wizsolucoes.copa_prototipo.utils.MySharedPreference
import br.com.wizsolucoes.copa_prototipo.utils.ReadJson
import br.com.wobbu.desafioandroid.models.PullRequest
import br.com.wobbu.desafioandroid.models.Repositories
import br.com.wobbu.desafioandroid.utils.MyConstants
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by eduardoewerton on 15/09/17.
 */
class PullRequestController(var context: Context, var repositoryName: String, var repositoryOwner: String) {

    /*
     Busca a lista de Repositorios no GitHub
    Unit - A Activity que chama esse metodo espera um resultado (result)
    Após receber o retorno da API, populo um Objeto
    Uso o Unit para enviar o Objeto populado para a Activity
     */
    fun getPullRequestAPI(result: (Array<PullRequest>) -> Unit) {
        doAsync {
            // Busca a URL
            var url = String.format(MyConstants().GET_PULL_REQUEST, repositoryOwner, repositoryName)

            // Converte o resultado da API em Json String
            var json = ReadJson().readJsonGET(url)

            // Salva a lista do GitHub no SharedPreference para cache
            MySharedPreference(context).setString(MyConstants().PULL_REQUEST_CACHE, json)

            // Lê o Json e popula um Objeto
            var response = Gson().fromJson(json, Array<PullRequest>::class.java)

            // Deve-se usar o uiThread para voltar a trabalhar na Main thread.
            uiThread {
                // Envia o Objeto para a Activity.
                result(response)
            }
        }
    }

    //Busca lista salva na Cache
    fun getListFromCache(json: String, result: (ArrayList<PullRequest>) -> Unit) {
        doAsync {
            var response = Gson().fromJson(json, ArrayList<PullRequest>()::class.java)
            uiThread {
                result(response)
            }
        }
    }
}