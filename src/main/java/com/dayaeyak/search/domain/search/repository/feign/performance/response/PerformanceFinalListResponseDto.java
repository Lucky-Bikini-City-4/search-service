package com.dayaeyak.search.domain.search.repository.feign.performance.response;

import lombok.Getter;


@Getter
public class PerformanceFinalListResponseDto {
    private String message;
    private PerformanceInfoListResponseDto data;
}