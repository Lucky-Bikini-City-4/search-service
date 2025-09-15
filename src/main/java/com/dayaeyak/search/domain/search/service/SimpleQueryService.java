package com.dayaeyak.search.domain.search.service;

import com.dayaeyak.search.domain.search.repository.feign.exhibition.ExhibitionFeignClient;
import com.dayaeyak.search.domain.search.repository.feign.exhibition.enums.Region;
import com.dayaeyak.search.domain.search.repository.feign.exhibition.enums.SearchType;
import com.dayaeyak.search.domain.search.repository.feign.exhibition.response.ExhibitionFinalListResponseDto;
import com.dayaeyak.search.domain.search.repository.feign.exhibition.response.ExhibitionFinalResponseDto;
import com.dayaeyak.search.domain.search.repository.feign.exhibition.response.ExhibitionInfoResponseDto;
import com.dayaeyak.search.domain.search.repository.feign.performance.PerformanceFeignClient;
import com.dayaeyak.search.domain.search.repository.feign.performance.enums.Grade;
import com.dayaeyak.search.domain.search.repository.feign.performance.response.PerformanceFinalListResponseDto;
import com.dayaeyak.search.domain.search.repository.feign.performance.response.PerformanceFinalResponseDto;
import com.dayaeyak.search.domain.search.repository.feign.performance.response.PerformanceInfoResponseDto;
import com.dayaeyak.search.domain.search.repository.feign.restaurant.RestaurantFeignClient;
import com.dayaeyak.search.domain.search.repository.feign.restaurant.response.RestaurantFinalListResponseDto;
import com.dayaeyak.search.domain.search.repository.feign.restaurant.response.RestaurantFinalResponseDto;
import com.dayaeyak.search.domain.search.repository.feign.restaurant.response.RestaurantInfoResponseDto;
import com.dayaeyak.search.domain.search.repository.response.AllFinalResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SimpleQueryService {

    private final PerformanceFeignClient performanceFeignClient;
    private final ExhibitionFeignClient exhibitionFeignClient;
    private final RestaurantFeignClient restaurantFeignClient;

    // 공연 단건 조회
    public PerformanceFinalResponseDto getPerformance(Long performanceId){
        PerformanceFinalResponseDto performance =
                performanceFeignClient.findPerformanceInfoByPerformanceId(performanceId);
        return performance;
    }

    // 공연 목록 조회
    public PerformanceFinalListResponseDto getPerformances(){

        PerformanceFinalListResponseDto performances =
                performanceFeignClient.findPerformanceInfoList();
        return performances;
    }

    // 전시회 단건 조회
    public ExhibitionFinalResponseDto getExhibition(Long exhibitionId){

        ExhibitionFinalResponseDto exhibition =
                exhibitionFeignClient.findExhibitionInfoByExhibitionId(exhibitionId);
        return exhibition;
    }


    // 전시회 목록 조회
    public ExhibitionFinalListResponseDto getExhibitions(
            int page,
            int size,
            Region region,
            Grade grade,
            LocalDate startDate,
            LocalDate endDate,
            String keyword,
            SearchType searchType
    ){

        ExhibitionFinalListResponseDto exhibitions =
                exhibitionFeignClient.findExhibitionInfoList(
                        page,
                        size,
                        region,
                        grade,
                        startDate,
                        endDate,
                        keyword,
                        searchType);
        return exhibitions;
    }

    // 음식점 단건 조회
    public RestaurantFinalResponseDto getRestaurant(Long restaurantId, Long userId, String role){
        RestaurantFinalResponseDto restaurant =
                restaurantFeignClient.findRestaurantInfoByRestaurantId(restaurantId, userId, role);
        return restaurant;
    }

    // 음식점 목록 조회
    public RestaurantFinalListResponseDto getRestaurants(Long userId, String role, String type){
        var dto = restaurantFeignClient.findRestaurantInfoList(userId, role);
        System.out.println(type);
        var cmp = Comparator.comparing(
                RestaurantInfoResponseDto::openTime,
                Comparator.nullsLast(Comparator.naturalOrder())
        );
        if ("desc".equalsIgnoreCase(type)) {
            cmp = cmp.reversed();
            dto.getData().getContent().sort(cmp);
        }
        if ("asc".equalsIgnoreCase(type)) {
            dto.getData().getContent().sort(cmp);
        }
        return dto;
    }





    // 전체 목록 조회
    public List<AllFinalResponseDto> getAlls(Long userId, String role, String type,
                                       int page,
                                       int size,
                                       Region region,
                                       Grade grade,
                                       LocalDate startDate,
                                       LocalDate endDate,
                                       String keyword,
                                       SearchType searchType
                                           ){

        var dtoRestaurant = restaurantFeignClient.findRestaurantInfoList(userId, role);

        var dtoExhibitions =
                exhibitionFeignClient.findExhibitionInfoList(
                        page,
                        size,
                        region,
                        grade,
                        startDate,
                        endDate,
                        keyword,
                        searchType);
        var dtoPerformances =
                performanceFeignClient.findPerformanceInfoList();

        List<AllFinalResponseDto> dtoRawPerformance = new ArrayList<>();
        for(PerformanceInfoResponseDto x: dtoPerformances.getData().getPerformances()) {
            dtoRawPerformance.add(AllFinalResponseDto.fromPerformance(x));
        }
        for(ExhibitionInfoResponseDto x: dtoExhibitions.getData()) {
            dtoRawPerformance.add(AllFinalResponseDto.fromExhibition(x));
        }
        for(RestaurantInfoResponseDto x: dtoRestaurant.getData().getContent()) {
            dtoRawPerformance.add(AllFinalResponseDto.fromRestaurant(x));
        }
        return dtoRawPerformance;

//        var dto = restaurantFeignClient.findRestaurantInfoList(userId, role);
//        System.out.println(type);
//        var cmp = Comparator.comparing(
//                RestaurantInfoResponseDto::getOpenTime,
//                Comparator.nullsLast(Comparator.naturalOrder())
//        );
//        if ("desc".equalsIgnoreCase(type)) {
//            cmp = cmp.reversed();
//            dto.getData().getContent().sort(cmp);
//        }
//        if ("asc".equalsIgnoreCase(type)) {
//            dto.getData().getContent().sort(cmp);
//        }
//        return dto;
    }
}
