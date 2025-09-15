package com.dayaeyak.search.domain.search.repository.feign.performance;

import com.dayaeyak.search.domain.search.repository.feign.performance.response.PerformanceFinalListResponseDto;
import com.dayaeyak.search.domain.search.repository.feign.performance.response.PerformanceFinalResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "performance-service",
        url = "192.168.50.176:8081",
        path = "/performances",
        fallbackFactory = PerformanceFeignFallbackFactory.class)
public interface PerformanceFeignClient {

    @GetMapping(value= "/{performanceId}")
    PerformanceFinalResponseDto findPerformanceInfoByPerformanceId(@PathVariable("performanceId") Long performanceId);

    @GetMapping()
    PerformanceFinalListResponseDto findPerformanceInfoList();

}
