package ru.gb.android.homework3.presentation.promo.di

import dagger.Component
import ru.gb.android.homework3.data.promo.PromoDataMapper
import ru.gb.android.homework3.data.promo.PromoRepository
import ru.gb.android.homework3.di.FeatureScope
import ru.gb.android.homework3.domain.promo.PromoDomainMapper
import ru.gb.android.homework3.presentation.promo.PromoListFragment
import ru.gb.android.homework3.presentation.promo.PromoStateFactory

interface PromoComponentDependencies {
    fun getPromoRepository(): PromoRepository
    fun getPromoDomainMapper(): PromoDomainMapper
    fun getPromoDataMapper(): PromoDataMapper
    fun getProvidePromoStateFactory(): PromoStateFactory
}

@FeatureScope
@Component(dependencies = [PromoComponentDependencies::class])
interface PromoComponent {

    @Component.Factory
    interface Factory{
        fun create(dependencies: PromoComponentDependencies): PromoComponent
    }

    fun inject(promoListFragment: PromoListFragment)

}