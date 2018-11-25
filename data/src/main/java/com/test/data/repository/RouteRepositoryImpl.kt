package com.test.data.repository

import com.test.data.remote.RoutesApi
import com.test.domain.repository.RoutesRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RouteRepositoryImpl @Inject constructor(private val api: RoutesApi) : RoutesRepository {


}

