package com.dayaeyak.search.domain.search.repository.feign.restaurant.response;

import lombok.Getter;


@Getter
public class RestaurantFinalListResponseDto {
    private String message;
    private RestaurantInfoListResponseDto data;
}