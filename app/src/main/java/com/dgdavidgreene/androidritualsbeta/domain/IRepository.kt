package com.dgdavidgreene.androidritualsbeta.domain

import appdb.RitualSentimentEntity

interface IRepository {
    //getAllRitualSentiments
    //suspend fun submitEmail(email: String): Resource<Unit>
    suspend fun getRitualSentimentEntityById(id: Long): RitualSentimentEntity?
    //suspend fun getAllRitualSentimentsByCategory(category: Long): RitualSentimentEntity?
}
