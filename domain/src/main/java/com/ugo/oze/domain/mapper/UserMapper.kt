package com.ugo.oze.domain.mapper

import co.windly.limbo.utility.mapping.ExtendedMapper
import com.ugo.oze.domain.model.base.Meta
import com.ugo.oze.domain.model.user.User
import com.ugo.oze.network.dto.UserDto
import com.ugo.oze.network.dto.base.MetaDto
import com.ugo.oze.persistence.database.entity.UserEntity
import org.mapstruct.*

@Mapper(
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface UserMapper : ExtendedMapper<UserDto, UserEntity, User> {

    // Meta

    fun mapDtoToDomain(dto: MetaDto): Meta

    // endregion

    // region PastPaper

//    @Mapping(source = "downloaded", target = "downloaded")
override fun mapDtoToEntity(dto: UserDto): UserEntity

//    @Mapping(source = "downloaded", target = "downloaded")
//    fun mapDomainToEntity(domain: User, downloaded: Boolean = false): PastPaperEntity

    // endregion


}