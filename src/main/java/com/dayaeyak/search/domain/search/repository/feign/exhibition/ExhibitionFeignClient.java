package com.dayaeyak.search.domain.search.repository.feign.exhibition;

import com.dayaeyak.search.domain.search.repository.feign.exhibition.enums.Region;
import com.dayaeyak.search.domain.search.repository.feign.exhibition.enums.SearchType;
import com.dayaeyak.search.domain.search.repository.feign.exhibition.response.ExhibitionFinalListResponseDto;
import com.dayaeyak.search.domain.search.repository.feign.exhibition.response.ExhibitionFinalResponseDto;
import com.dayaeyak.search.domain.search.repository.feign.performance.enums.Grade;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;


@FeignClient(
        name = "exhibition",
        url = "192.168.50.176:8082",
        path = "/",
        fallbackFactory = ExhibitionFeignFallbackFactory.class)
public interface ExhibitionFeignClient {

    @GetMapping("exhibitions/{exhibitionId}")
    ExhibitionFinalResponseDto findExhibitionInfoByExhibitionId(@PathVariable("exhibitionId") Long exhibitionId);

    @GetMapping("internal/exhibitions")
    ExhibitionFinalListResponseDto findExhibitionInfoList(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "10") int size,
                                                          @RequestParam(required = false) Region region,
                                                          @RequestParam(required = false) Grade grade,
                                                          @RequestParam(required = false) LocalDate startDate,
                                                          @RequestParam(required = false) LocalDate endDate,
                                                          @RequestParam String keyword,
                                                          @RequestParam SearchType searchType);

}
