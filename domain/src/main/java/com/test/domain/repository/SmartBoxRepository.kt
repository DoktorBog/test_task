package com.test.domain.repository

import com.test.domain.model.DataDomain
import io.reactivex.Single

interface SmartBoxRepository {

    fun getData(): Single<List<DataDomain>>

}