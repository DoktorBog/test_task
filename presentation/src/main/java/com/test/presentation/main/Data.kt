package com.test.presentation.main

import com.google.android.gms.maps.model.LatLng
import com.test.domain.model.DataDomain
import javax.inject.Inject

data class Data(val id: Int = 0,
                val type: PageFragment.Type,
                val title: String = "",
                val imageData: ImageData,
                val location: LatLng,
                val descriptionData: DescriptionData)

data class ImageData(val smallImage: String = "",  val bigImage: String = "")
data class DescriptionData(val shortDescription: String = "",  val description: String = "")


class DataMapper @Inject constructor() {
    fun mapToPresentation(list: List<DataDomain>): List<Data>? = list.map { mapToPresentation(it) }
    fun mapToPresentation(entity: DataDomain): Data = Data(id = entity.id,
            type = when(entity.type){
                "event" -> PageFragment.Type.EVENT
                "shop" -> PageFragment.Type.SHOP
                else -> PageFragment.Type.SHOP
            },
            title = entity.title, imageData = ImageData(entity.smallImage, entity.bigImage),
            location = LatLng(entity.latitude.toDouble(), entity.longitude.toDouble()),
            descriptionData = DescriptionData(entity.shortDescription, entity.description))
}