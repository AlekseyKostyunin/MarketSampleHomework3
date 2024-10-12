package ru.gb.android.homework3.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.gb.android.homework3.presentation.product.di.ProductComponent
import ru.gb.android.homework3.presentation.promo.di.PromoComponent


@Component(
    modules = [
        NetworkModule::class,
        PersistenceModule::class,
        CoreModule::class,
        SubcomponentsModule::class
    ]
)
interface AppComponent {

    fun productComponentFactory(): ProductComponent.Factory

    fun promoComponentFactory(): PromoComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
}