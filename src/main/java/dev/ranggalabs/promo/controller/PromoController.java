package dev.ranggalabs.promo.controller;

import dev.ranggalabs.promo.dto.PromoRequestDto;
import dev.ranggalabs.promo.dto.PromoResponseDto;
import dev.ranggalabs.promo.service.PromoService;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by erlangga on 13/01/19.
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class PromoController {

    @Autowired
    private PromoService promoService;

    @PostMapping("/api/promo")
    public Single<PromoResponseDto> promo(@RequestBody PromoRequestDto request) {
        return promoService.process(request);
    }

}
