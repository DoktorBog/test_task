package com.test.domain.interactor

import com.test.domain.model.DataDomain
import com.test.domain.repository.SmartBoxRepository
import io.reactivex.Single
import javax.inject.Inject

class SmartBoxApiUseCase @Inject constructor(private val repository: SmartBoxRepository) {

    fun get() : Single<List<DataDomain>> = repository.getData()
}
