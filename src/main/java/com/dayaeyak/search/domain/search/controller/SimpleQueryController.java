package com.dayaeyak.search.domain.search.controller;

import com.dayaeyak.search.domain.search.repository.feign.exhibition.enums.Region;
import com.dayaeyak.search.domain.search.repository.feign.exhibition.enums.SearchType;
import com.dayaeyak.search.domain.search.repository.feign.exhibition.response.ExhibitionFinalListResponseDto;
import com.dayaeyak.search.domain.search.repository.feign.exhibition.response.ExhibitionFinalResponseDto;
import com.dayaeyak.search.domain.search.repository.feign.performance.enums.Grade;
import com.dayaeyak.search.domain.search.repository.feign.performance.response.PerformanceFinalListResponseDto;
import com.dayaeyak.search.domain.search.repository.feign.performance.response.PerformanceFinalResponseDto;
import com.dayaeyak.search.domain.search.repository.feign.restaurant.response.RestaurantFinalListResponseDto;
import com.dayaeyak.search.domain.search.repository.feign.restaurant.response.RestaurantFinalResponseDto;
import com.dayaeyak.search.domain.search.repository.response.AllFinalResponseDto;
import com.dayaeyak.search.domain.search.service.SimpleQueryService;
import com.dayaeyak.search.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/searches")
public class SimpleQueryController {

    private final SimpleQueryService simpleQueryService;

    // 공연 단건 조회
    @GetMapping("/performance/{performanceId}")
    public ResponseEntity<ApiResponse<PerformanceFinalResponseDto>> getPerformance (
            @Validated
            @PathVariable Long performanceId){
        PerformanceFinalResponseDto responseDto = simpleQueryService.getPerformance(performanceId);
        return ApiResponse.success(200, "공연 단건이 조회되었습니다. ", responseDto);
    }

    // 공연 목록 조회
    @GetMapping("/performances")
    public ResponseEntity<ApiResponse<PerformanceFinalListResponseDto>> getPerformances(){
        PerformanceFinalListResponseDto responseDto = simpleQueryService.getPerformances();
        return ApiResponse.success(200, "공연 목록이 조회되었습니다. ", responseDto);
    }


    // 전시회 단건 조회
    @GetMapping("/exhibition/{exhibitionId}")
    public ResponseEntity<ApiResponse<ExhibitionFinalResponseDto>> getExhibition (
            @Validated
            @PathVariable Long exhibitionId){
        ExhibitionFinalResponseDto responseDto = simpleQueryService.getExhibition(exhibitionId);
        return ApiResponse.success(200, "전시회 단건이 조회되었습니다. ", responseDto);
    }

    // 전시회 목록 조회
    @GetMapping("/exhibitions")
    public ResponseEntity<ApiResponse<ExhibitionFinalListResponseDto>> getExhibitions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) Region region,
            @RequestParam(required = false) Grade grade,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate,
            @RequestParam String keyword,
            @RequestParam SearchType searchType){
        ExhibitionFinalListResponseDto responseDto = simpleQueryService.getExhibitions(page, size, region, grade, startDate, endDate, keyword, searchType);
        return ApiResponse.success(200, "전시회 목록이 조회되었습니다. ", responseDto);
    }

    // 음식점 단건 조회
    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<ApiResponse<RestaurantFinalResponseDto>> getRestaurant (
            @RequestHeader("X-User-Id") Long userId,
            @RequestHeader("X-Role") String role,
            @Validated
            @PathVariable Long restaurantId){
        RestaurantFinalResponseDto responseDto = simpleQueryService.getRestaurant(restaurantId, userId, role);
        return ApiResponse.success(200, "음식점 단건이 조회되었습니다. ", responseDto);
    }

    // 음식점 목록 조회
    @GetMapping("/restaurants")
    public ResponseEntity<ApiResponse<RestaurantFinalListResponseDto>> getRestaurants(
            @RequestHeader("X-User-Id") Long userId,
            @RequestHeader("X-Role") String role,
            @RequestParam(required = false) String type
    ){
        RestaurantFinalListResponseDto responseDto = simpleQueryService.getRestaurants(userId, role, type);
        return ApiResponse.success(200, "음식점 목록이 조회되었습니다. ", responseDto);
    }

    // 공연+전시+음식점 통합 목록 조회
    @GetMapping("/alls")
    public ResponseEntity<ApiResponse<List<AllFinalResponseDto>>> getAlls(
            @RequestHeader("X-User-Id") Long userId,
            @RequestHeader("X-Role") String role,
            @RequestParam(required = false) String type,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) Region region,
            @RequestParam(required = false) Grade grade,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate,
            @RequestParam String keyword,
            @RequestParam SearchType searchType
    ){
        List<AllFinalResponseDto> responseDto = simpleQueryService.getAlls(userId, role, type, page, size, region, grade, startDate, endDate, keyword, searchType);
        return ApiResponse.success(200, "전체 목록이 조회되었습니다. ", responseDto);

    }



}
