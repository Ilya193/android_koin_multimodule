package ru.ikom.android_koin_multimodule

import org.koin.dsl.module
import ru.ikom.data.RepositoryImpl
import ru.ikom.domain.Repository

val appModule = module {
    factory<Repository> {
        RepositoryImpl()
    }
}