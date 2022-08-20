package com.ugo.oze.persistence

import com.ugo.oze.persistence.database.DatabaseModule
import dagger.Module

@Module(
    includes = [
        DatabaseModule::class
    ]
)
class PersistenceModule
