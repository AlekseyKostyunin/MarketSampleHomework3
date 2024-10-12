package ru.gb.android.homework3.di

import dagger.Module
import dagger.Provides
import ru.gb.android.homework3.data.product.ProductDataMapper
import ru.gb.android.homework3.data.promo.PromoDataMapper
import ru.gb.android.homework3.domain.product.ProductDomainMapper
import ru.gb.android.homework3.domain.promo.PromoDomainMapper
import ru.gb.android.homework3.presentation.common.DiscountFormatter
import ru.gb.android.homework3.presentation.common.PriceFormatter
import ru.gb.android.homework3.presentation.product.di.ProductComponent
import ru.gb.android.homework3.presentation.promo.PromoStateFactory
import ru.gb.android.homework3.presentation.promo.di.PromoComponent

@Module(
    subcomponents = [
        ProductComponent::class,
        PromoComponent::class
    ]
)
object SubcomponentsModule {


    @Provides
    fun provideProductDomainMapper(): ProductDomainMapper {
        return ProductDomainMapper()
    }

    @Provides
    fun provideProductDataMapper(): ProductDataMapper {
        return ProductDataMapper()
    }

    @Provides
    fun providePromoDataMapper(): PromoDataMapper {
        return PromoDataMapper()
    }

    @Provides
    fun providePromoDomainMapper(): PromoDomainMapper {
        return PromoDomainMapper()
    }

    @Provides
    fun provideDiscountFormatter(): DiscountFormatter {
        var discountFormatterSingleton: DiscountFormatter? = null
        val local = discountFormatterSingleton
        return local ?: run {
            val newDiscountFormatter = DiscountFormatter()
            discountFormatterSingleton = newDiscountFormatter
            newDiscountFormatter
        }
    }

    @Provides
    fun providePriceFormatter(): PriceFormatter {
        var priceFormatterSingleton: PriceFormatter? = null
        val local = priceFormatterSingleton
        return local ?: run {
            val newPriceFormatter = PriceFormatter()
            priceFormatterSingleton = newPriceFormatter
            newPriceFormatter
        }
    }

    @Provides
    fun providePromoStateFactory(): PromoStateFactory {
        return PromoStateFactory()
    }


}
