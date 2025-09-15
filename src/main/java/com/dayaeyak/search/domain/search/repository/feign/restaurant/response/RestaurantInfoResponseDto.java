package com.dayaeyak.search.domain.search.repository.feign.restaurant.response;

import com.dayaeyak.search.domain.search.repository.feign.performance.enums.Grade;
import com.dayaeyak.search.domain.search.repository.feign.performance.response.CastDto;
import com.dayaeyak.search.domain.search.repository.feign.restaurant.enums.ActivationStatus;
import com.dayaeyak.search.domain.search.repository.feign.restaurant.enums.ClosedDays;
import com.dayaeyak.search.domain.search.repository.feign.restaurant.enums.RestaurantType;
import com.dayaeyak.search.domain.search.repository.feign.restaurant.enums.WaitingStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Builder
public record RestaurantInfoResponseDto (
        Long id,

        String name,

        Long sellerId,

        String address,

        String phoneNumber,

        @Enumerated(EnumType.STRING)
        ClosedDays closedDay,       // 기본 휴무일

        @JsonFormat(pattern = "HH:mm")
        LocalTime openTime,        // 영업 시작 시간

        @JsonFormat(pattern = "HH:mm")
        LocalTime closeTime,      // 영업 종료 시간

        @Enumerated(EnumType.STRING)
        RestaurantType type,

        int capacity,              // 총 좌석 수

        @Enumerated(EnumType.STRING)
        ActivationStatus isActivation,  // 영업 활성 상태

        String city,

        @Enumerated(EnumType.STRING)
        WaitingStatus waitingActivation   // 웨이팅 사용 유무
) { }

