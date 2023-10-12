package com.example.traveltaipei.usecase

import com.example.model.ActivityResponse
import com.example.traveltaipei.pojo.EventActivityBO
import com.example.traveltaipei.pojo.FileBO
import com.example.traveltaipei.pojo.LinkBO
import javax.inject.Inject

class ConvertEventActivityUseCase @Inject constructor(
) {
    operator fun invoke(attractions: List<ActivityResponse>): List<EventActivityBO> {
        return attractions.map {
            EventActivityBO(
                id = it.id,
                title = it.title,
                description = it.description,
                begin = it.begin,
                end = it.end,
                posted = it.posted,
                modified = it.modified,
                url = it.url,
                district = it.district,
                address = it.address,
                latitude = it.latitude,
                longitude = it.longitude,
                organizer = it.organizer,
                coOrganizer = it.coOrganizer,
                contact = it.contact,
                tel = it.tel,
                fax = it.fax,
                ticket = it.ticket,
                traffic = it.traffic,
                parking = it.parking,
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