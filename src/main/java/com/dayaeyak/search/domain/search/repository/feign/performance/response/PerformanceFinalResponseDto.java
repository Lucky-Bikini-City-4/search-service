package com.dayaeyak.search.domain.search.repository.feign.performance.response;

import lombok.Getter;


@Getter
public class PerformanceFinalResponseDto {
    private String message;
    private PerformanceInfoResponseDto data;
}