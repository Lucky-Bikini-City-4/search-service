package com.dayaeyak.search.domain.search.repository.feign.restaurant.response;

import lombok.Getter;

import java.util.List;


@Getter
public class RestaurantInfoListResponseDto {
    private List<RestaurantInfoResponseDto> content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
