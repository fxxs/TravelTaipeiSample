package com.example.traveltaipei.usecase

import com.example.model.TourResponse
import com.example.traveltaipei.pojo.FileBO
import com.example.traveltaipei.pojo.TourThemeBO
import javax.inject.Inject

class ConvertTourThemeUseCase @Inject constructor(
) {
    operator fun invoke(attractions: List<TourResponse>): List<TourThemeBO> {
        return attractions.map {
            TourThemeBO(
                id = it.id,
                title = it.title,
                seasons = convertSeasons(it.seasons),
                months = convertMonths(it.months),
                days = it.days,
                author = it.author,
                description = it.description,
                consume = it.consume,
                remark = it.remark,
                note = it.note,
                url = it.url,
                category = it.category,
                transport = it.transport,
                users = it.users,
                modified = it.modified,
                files = it.files?.map { file ->
                    FileBO(
                        src = file.src,
                        subject = file.subject,
                        ext = file.ext
                    )
                },
            )
        }
    }

    private fun convertSeasons(seasons: List<String>?): String {
        val stringBuilder = StringBuilder()
        seasons?.forEach {
            stringBuilder.append(convertSeason(it))
            stringBuilder.append(", ")
        }

        if (stringBuilder.isNotEmpty()) {
            stringBuilder.deleteCharAt(stringBuilder.length - 1)
        } else {
            stringBuilder.append("None")
        }

        return stringBuilder.toString()
    }

    private fun convertSeason(season: String?): String {
        season?.let {
            when (it) {
                "1" -> {
                    return "Spring"
                }

                "2" -> {
                    return "Summer"
                }

                "3" -> {
                    return "Autumn"
                }

                "4" -> {
                    return "Winter"
                }

                else -> {
                    return ""
                }
            }
        }

        return ""
    }

    private fun convertMonths(seasons: List<String>?): String {
        val stringBuilder = StringBuilder()
        seasons?.forEach {
            stringBuilder.append(convertMonth(it))
            stringBuilder.append(", ")
        }

        if (stringBuilder.isNotEmpty()) {
            stringBuilder.deleteCharAt(stringBuilder.length - 1)
        } else {
            stringBuilder.append("None")
        }

        return stringBuilder.toString()
    }

    private fun convertMonth(month: String?): String {
        month?.let {
            when (it) {
                "01" -> {
                    return "January"
                }

                "02" -> {
                    return "February"
                }

                "03" -> {
                    return "March"
                }

                "04" -> {
                    return "April"
                }

                "05" -> {
                    return "May"
                }

                "06" -> {
                    return "June"
                }

                "07" -> {
                    return "July"
                }

                "08" -> {
                    return "August"
                }

                "09" -> {
                    return "September"
                }

                "10" -> {
                    return "October"
                }

                "11" -> {
                    return "November"
                }

                "12" -> {
                    return "December"
                }

                else -> {
                    return ""
                }
            }
        }

        return ""
    }
}