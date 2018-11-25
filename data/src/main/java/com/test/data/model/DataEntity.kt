package com.test.data.model

import com.squareup.moshi.Json
import com.test.domain.model.DataDomain
import javax.inject.Inject

data class DataEntity(@Json(name = "smallImage") val smallImage: String = "",
                      @Json(name = "bigImage") val bigImage: String = "",
                      @Json(name = "latitude") val latitude: String = "",
                      @Json(name = "description") val description: String = "",
                      @Json(name = "id") val id: Int = 0,
                      @Json(name = "shortDescription") val shortDescription: String = "",
                      @Json(name = "type") val type: String = "",
                      @Json(name = "title") val title: String = "",
                      @Json(name = "longitude") val longitude: String = "")

class DataMapper @Inject constructor() {

    fun mapToDomain(list: List<DataEntity>): List<DataDomain>? = list.map { mapToDomain(it) }
    fun mapToDomain(entity: DataEntity) : DataDomain
            = DataDomain(smallImage = entity.smallImage, bigImage = entity.bigImage,
                         latitude = entity.latitude, longitude = entity.longitude,
                         description = entity.description, shortDescription = entity.shortDescription,
                         type = entity.type, id = entity.id, title = entity.title)


    fun mapToEntity(list: List<DataDomain>): List<DataEntity>? = list.map { mapToEntity(it) }
    fun mapToEntity(entity: DataDomain) : DataEntity
            = DataEntity(smallImage = entity.smallImage, bigImage = entity.bigImage,
                         latitude = entity.latitude, longitude = entity.longitude,
                         description = entity.description, shortDescription = entity.shortDescription,
                         type = entity.type, id = entity.id, title = entity.title)

}