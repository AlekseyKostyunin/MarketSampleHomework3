package ru.gb.android.homework3.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.gb.android.homework3.data.promo.PromoDataMapper
import ru.gb.android.homework3.data.promo.PromoRepository
import ru.gb.android.homework3.domain.promo.PromoDomainMapper
import ru.gb.android.homework3.presentation.product.di.ProductComponent
import ru.gb.android.homework3.presentation.promo.PromoStateFactory
import ru.gb.android.homework3.presentation.promo.di.PromoComponentDependencies

@Component(
    modules = [
        NetworkModule::class,
        PersistenceModule::class,
        CoreModule::class,
        SubcomponentsModule::class
    ]
)
interface AppComponent : PromoComponentDependencies {

    fun productComponentFactory(): ProductComponent.Factory

    override fun getPromoRepository(): PromoRepository
    override fun getPromoDomainMapper(): PromoDomainMapper
    override fun getPromoDataMapper(): PromoDataMapper
    override fun getProvidePromoStateFactory(): PromoStateFactory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
}