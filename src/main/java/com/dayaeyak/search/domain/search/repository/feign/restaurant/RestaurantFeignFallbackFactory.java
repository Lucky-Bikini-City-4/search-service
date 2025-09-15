package com.dayaeyak.search.domain.search.repository.feign.restaurant;

import com.dayaeyak.search.domain.search.repository.feign.performance.PerformanceFeignClient;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class RestaurantFeignFallbackFactory implements FallbackFactory<RestaurantFeignClient> {

    @Override
    public RestaurantFeignClient create(Throwable cause) {
        return null;
    }
}
