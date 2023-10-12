package com.example.traveltaipei.usecase

import com.example.model.AttractionsResponse
import com.example.traveltaipei.pojo.AttractionBO
import com.example.traveltaipei.pojo.FileBO
import com.example.traveltaipei.pojo.LinkBO
import javax.inject.Inject

class ConvertAttractionsUseCase @Inject constructor(
) {
    operator fun invoke(attractions: List<AttractionsResponse>): List<AttractionBO> {
        return attractions.map {
            AttractionBO(
                id = it.id,
                name = it.name,
                nameZH = it.nameZH,
                openStatus = it.openStatus,
                introduction = it.introduction,
                openTime = it.openTime,
                zipcode = it.zipcode,
                district = it.district,
                address = it.address,
                tel = it.tel,
                fax = it.fax,
                email = it.email,
                months = it.months,
                latitude = it.latitude,
                longitude = it.longitude,
                officialSite = it.officialSite,
                facebook = it.facebook,
                ticket = it.ticket,
                remind = it.remind,
                stayTime = it.stayTime,
                modified = it.modified,
                url = it.url,
                images = it.images?.map { image ->
                    image.src
                },
                files = it.files?.map { file ->
                    FileBO(
                        src = file.src,
                        subject = file.subject,
                        ext = file.ext
                    )
                },
                links = it.links?.map { link ->
                    LinkBO(
                        src = link.src,
                        subject = link.subject
                    )
                }
            )
        }
    }
}