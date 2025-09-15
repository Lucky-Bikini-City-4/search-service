package com.dayaeyak.search.domain.search.repository.feign.performance.response;

import lombok.Getter;

import java.util.List;

@Getter
public class PerformanceInfoListResponseDto {
    PageInfoDto pageInfo;
    List<PerformanceInfoResponseDto> performances;
}
