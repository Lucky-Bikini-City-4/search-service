package com.dayaeyak.search.domain.search.repository.feign.restaurant.response;

import com.dayaeyak.search.domain.search.repository.feign.performance.response.PerformanceInfoResponseDto;
import lombok.Getter;


@Getter
public class RestaurantFinalResponseDto {
    private String message;
    private RestaurantInfoResponseDto data;
}