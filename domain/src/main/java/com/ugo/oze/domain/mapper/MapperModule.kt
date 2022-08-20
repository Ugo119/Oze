package com.ugo.oze.domain.mapper

import dagger.Module
import dagger.Provides
import org.mapstruct.factory.Mappers
import javax.inject.Singleton

@Module
class MapperModule {


    //region User

    @Provides
    @Singleton
    internal fun provideUserMapper(): UserMapper =
        Mappers
            .getMapper(UserMapper::class.java)

    //endregion

}
