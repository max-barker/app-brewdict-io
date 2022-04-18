package io.brewdict.application.apis.brewdict.endpoints

import io.brewdict.application.api_consumption.CRUDEndpoint
import io.brewdict.application.api_consumption.Result
import io.brewdict.application.apis.brewdict.BrewdictAPI
import io.brewdict.application.apis.brewdict.models.Fermentation
import io.brewdict.application.apis.brewdict.models.Style
import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking
import java.io.IOException

object FermentationEndpoint : CRUDEndpoint<Fermentation>(BrewdictAPI, "fermentations", "fermentations") {
    override fun index(): Result<List<Fermentation>> {
        var result: Result<List<Fermentation>>

        runBlocking {
            result = try {
                val style: List<Fermentation> = api.client.get {
                    url("${api.host}/users/${BrewdictAPI.loggedInUser!!.user.id}/${route}")
                }

                Result.Success(style)
            } catch (e: Throwable) {
                Result.Error(IOException("Error retrieving fermentations:", e))
            }
        }

        return result
    }

    override fun get(id: Int): Result<Fermentation> {
        TODO("Not yet implemented")
    }

    override fun create(model: Fermentation): Result<Fermentation> {
        TODO("Not yet implemented")
    }

    override fun update(id: Int?, model: Fermentation): Result<Fermentation> {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int): Result<Fermentation?> {
        TODO("Not yet implemented")
    }
}