package ru.gb.android.homework3.domain.promo

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.gb.android.homework3.data.promo.PromoRepository
import ru.gb.android.homework3.di.FeatureScope
import javax.inject.Inject

@FeatureScope
class ConsumePromosUseCase @Inject constructor(
    private val promoRepository: PromoRepository,
    private val promoDomainMapper: PromoDomainMapper,
) {
    operator fun invoke(): Flow<List<Promo>> {
        return promoRepository.consumePromos()
            .map { promos -> promos.map(promoDomainMapper::fromEntity) }
    }
}