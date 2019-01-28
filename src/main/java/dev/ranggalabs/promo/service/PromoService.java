package dev.ranggalabs.promo.service;

import dev.ranggalabs.promo.dto.PromoRequestDto;
import dev.ranggalabs.promo.dto.PromoResponseDto;
import io.reactivex.Single;

/**
 * Created by erlangga on 13/01/19.
 */
public interface PromoService {
    Single<PromoResponseDto> process(PromoRequestDto dto);
}
