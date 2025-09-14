package com.dayaeyak.search.domain.search.repository.feign.performance;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class PerformanceFeignFallbackFactory implements FallbackFactory<PerformanceFeignClient> {

    @Override
    public PerformanceFeignClient create(Throwable cause) {
        return null;
    }
}
