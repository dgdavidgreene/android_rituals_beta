package com.dgdavidgreene.androidritualsbeta.data

import appdb.RitualSentimentEntity
import com.dgdavidgreene.androidritualsbeta.AppDatabase
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

import javax.inject.Inject

class Repository @Inject constructor(private val db: AppDatabase) {

    private val queries = db.ritualSentimentEntityQueries

    fun getAllRitualSentiments() = queries.getAllRitualSentiments().asFlow().mapToList()

    suspend fun getRitualSentimentEntityById(id: Long): RitualSentimentEntity? {
        return withContext(Dispatchers.IO) {
            queries.getRitualSentimentById(id).executeAsOneOrNull()
        }
    }

    suspend fun insertRitualSentimentEntity(category: Long, sentiment: String, created: String, modified: String, id: Long? = null) {
        withContext(Dispatchers.IO) {
            val trimmedSentiment = sentiment.trim()
            queries.insertRitualSentiment(id, category, trimmedSentiment, created, modified)
        }
    }

    suspend fun deleteRitualSentimentEntityById(id: Long) {
        withContext(Dispatchers.IO) {
            queries.deleteRitualSentimentById(id)
        }
    }

    fun searchRitualSentimentEntity(keyword: String): Flow<List<RitualSentimentEntity>> {
        return queries.searchRitualSentiments(keyword).asFlow().mapToList()

    }

    suspend fun getRitualSentimentEntityByCategory(category: Long): Flow<List<RitualSentimentEntity>> {
        return withContext(Dispatchers.IO) {
            queries.getRitualSentimentById(category).asFlow().mapToList()
        }
    }
}