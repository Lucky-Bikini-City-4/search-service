package com.dayaeyak.search.domain.search.repository.feign.exhibition;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ExhibitionFeignFallbackFactory implements FallbackFactory<ExhibitionFeignClient> {

    @Override
    public ExhibitionFeignClient create(Throwable cause) {
        return null;
    }
}
