package ru.gb.android.homework3.presentation.product.di

import dagger.Subcomponent
import ru.gb.android.homework3.di.FeatureScope
import ru.gb.android.homework3.presentation.product.ProductListFragment

@FeatureScope
@Subcomponent
interface ProductComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(
//            productDomainMapper: ProductDomainMapper,
//            productDataMapper: ProductDataMapper,
        ): ProductComponent
    }

    fun inject(productFragment: ProductListFragment)


}