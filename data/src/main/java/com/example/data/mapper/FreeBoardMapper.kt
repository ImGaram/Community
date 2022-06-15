package com.example.data.mapper

import com.example.data.entity.freeboard.response.BaseFreeBoardResponse
import com.example.domain.model.freeboard.DomainBaseFreeBoardResponse

object FreeBoardMapper {
//    data -> domain
    fun toDomainBaseFreeBoardResponse(
        dataResponse: BaseFreeBoardResponse?
    ): DomainBaseFreeBoardResponse? {
        return if (dataResponse != null) {
                DomainBaseFreeBoardResponse(
                id = dataResponse.id,
                title = dataResponse.title,
                context = dataResponse.context,
                img1 = dataResponse.img1,
                img2 = dataResponse.img2,
                img3 = dataResponse.img3,
                img4 = dataResponse.img4,
                img5 = dataResponse.img5,
                createUser = dataResponse.createUser,
                createDate = dataResponse.createDate,
                correctionDate = dataResponse.correctionDate
            )
        } else dataResponse
    }
}