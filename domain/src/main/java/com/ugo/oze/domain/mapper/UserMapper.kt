package com.ugo.oze.domain.mapper

import co.windly.limbo.utility.mapping.ExtendedMapper
import com.ugo.oze.domain.model.base.Meta
import com.ugo.oze.domain.model.user.User
import com.ugo.oze.network.dto.UserDto
import com.ugo.oze.network.dto.base.MetaDto
import com.ugo.oze.network.dto.base.PageDto
import com.ugo.oze.persistence.database.entity.UserEntity
import org.mapstruct.*

@Mapper(
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface UserMapper : ExtendedMapper<UserDto, UserEntity, User> {

    // Meta

    fun mapDtoToDomain(dto: MetaDto): Meta<User>

    // endregion

    fun mapPageDtoToDomain(dto: PageDto<UserDto>): Meta<User>

    // region

    override fun mapDtoToEntity(dto: UserDto): UserEntity

    // endregion


}