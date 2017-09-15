package br.com.wobbu.desafioandroid.controllers

import android.content.Context
import br.com.wizsolucoes.copa_prototipo.utils.MySharedPreference
import br.com.wizsolucoes.copa_prototipo.utils.ReadJson
import br.com.wobbu.desafioandroid.models.Repositories
import br.com.wobbu.desafioandroid.utils.MyConstants
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by eduardoewerton on 14/09/17.
 */
class GitHubController(var context: Context) {

    /*
    Busca a lista de Repositorios no GitHub
    Unit - A Activity que chama esse metodo espera um resultado (result)
    Após receber o retorno da API, populo um Objeto
    Uso o Unit para enviar o Objeto populado para a Activity
     */
    fun getRepositoriesAPI(result: (Repositories) -> Unit) {
        doAsync {
            // Busca a URL
            var url = MyConstants().GET_REPOSITORIES

            // Converte o resultado da API em Json String
            var json = ReadJson().readJsonGET(url)

            // Salva a lista do GitHub no SharedPreference para cache
            MySharedPreference(context).setString(MyConstants().LIST_REPOSITORIES_CACHE, json)

            // Lê o Json e popula um Objeto
            var response = Gson().fromJson(json, Repositories::class.java)

            // Deve-se usar o uiThread para voltar a trabalhar na Main thread.
            uiThread {
                // Envia o Objeto para a Activity.
                result(response)
            }
        }
    }

    //Busca lista salva na Cache
    fun getListFromCache(json: String, result: (Repositories) -> Unit) {
        doAsync {
            var response = Gson().fromJson(json, Repositories::class.java)
            uiThread {
                result(response)
            }
        }
    }
}