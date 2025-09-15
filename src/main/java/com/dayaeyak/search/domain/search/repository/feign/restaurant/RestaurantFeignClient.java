package com.dayaeyak.search.domain.search.repository.feign.restaurant;

import com.dayaeyak.search.domain.search.repository.feign.performance.PerformanceFeignFallbackFactory;
import com.dayaeyak.search.domain.search.repository.feign.performance.response.PerformanceFinalListResponseDto;
import com.dayaeyak.search.domain.search.repository.feign.performance.response.PerformanceFinalResponseDto;
import com.dayaeyak.search.domain.search.repository.feign.restaurant.response.RestaurantFinalListResponseDto;
import com.dayaeyak.search.domain.search.repository.feign.restaurant.response.RestaurantFinalResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
//
//@FeignClient
//public class RestaurantFeignClient {
//}



@FeignClient(
        name = "restaurants",
        url = "192.168.50.176:8083",
        path = "/restaurants",
        fallbackFactory = RestaurantFeignFallbackFactory.class)
public interface RestaurantFeignClient {

    @GetMapping(value= "/{id}")
    RestaurantFinalResponseDto findRestaurantInfoByRestaurantId(@PathVariable("id") Long id,
                                                                @RequestHeader("X-User-Id") Long userId,
                                                                @RequestHeader("X-Role") String role);

    @GetMapping()
    RestaurantFinalListResponseDto findRestaurantInfoList(@RequestHeader("X-User-Id") Long userId,
                                                          @RequestHeader("X-Role") String role);

}
