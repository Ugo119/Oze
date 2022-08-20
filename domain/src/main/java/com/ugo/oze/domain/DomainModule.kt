package com.ugo.oze.domain

import com.ugo.oze.domain.mapper.MapperModule
import com.ugo.oze.network.NetworkModule
import com.ugo.oze.persistence.PersistenceModule
import com.ugo.oze.utility.UtilityModule
import dagger.Module

@Module(
    includes = [
        MapperModule::class,
        NetworkModule::class,
        PersistenceModule::class,
        UtilityModule::class,
    ]
)
class DomainModule
