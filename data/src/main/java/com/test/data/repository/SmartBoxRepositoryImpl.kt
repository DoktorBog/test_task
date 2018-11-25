package com.test.data.repository

import com.test.data.model.DataMapper
import com.test.data.remote.SmartBoxApi
import com.test.domain.model.DataDomain
import com.test.domain.repository.SmartBoxRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SmartBoxRepositoryImpl @Inject constructor(private val api: SmartBoxApi,
                                                 private val mapper: DataMapper) : SmartBoxRepository {

    override fun getData(): Single<List<DataDomain>> = api.getData().map { mapper.mapToDomain(it) }
}

