package com.dayaeyak.search.domain.search.repository.response;

import com.dayaeyak.search.domain.search.repository.feign.exhibition.enums.Region;
import com.dayaeyak.search.domain.search.repository.feign.exhibition.response.ExhibitionFindArtistResponseDto;
import com.dayaeyak.search.domain.search.repository.feign.exhibition.response.ExhibitionInfoResponseDto;
import com.dayaeyak.search.domain.search.repository.feign.performance.enums.Grade;
import com.dayaeyak.search.domain.search.repository.feign.performance.enums.Type;
import com.dayaeyak.search.domain.search.repository.feign.performance.response.CastDto;
import com.dayaeyak.search.domain.search.repository.feign.performance.response.PerformanceInfoResponseDto;
import com.dayaeyak.search.domain.search.repository.feign.restaurant.enums.ActivationStatus;
import com.dayaeyak.search.domain.search.repository.feign.restaurant.enums.ClosedDays;
import com.dayaeyak.search.domain.search.repository.feign.restaurant.enums.RestaurantType;
import com.dayaeyak.search.domain.search.repository.feign.restaurant.enums.WaitingStatus;
import com.dayaeyak.search.domain.search.repository.feign.restaurant.response.RestaurantInfoResponseDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public record AllFinalResponseDto(
    // performance
    Long performanceId,
    Long sellerId,
    String performanceName,
    Long hallId,
    List<CastDto> castList,
    String description,
    Type type,
    Grade grade,
    Date startDate,
    Date endDate,
    Timestamp ticketOpenAt,
    Timestamp ticketCloseAt,
    
    
    // exhibition
    Long exhibitionId,

    Integer price,

//    String name,

    String place,

//    String address,

    Region region,

//    Grade grade,

//    @JsonFormat(pattern = "yyyy년 MM월 dd일")
//    LocalDate startDate,
//
//    @JsonFormat(pattern = "yyyy년 MM월 dd일")
//    LocalDate endDate,

    @JsonFormat(pattern = "HH시 mm분")
    LocalTime startTime,

    @JsonFormat(pattern = "HH시 mm분")
    LocalTime endTime,

//    @JsonFormat(pattern = "yyyy년 MM월 dd일 HH시 mm분")
//    LocalDateTime ticketOpenAt,
//
//    @JsonFormat(pattern = "yyyy년 MM월 dd일 HH시 mm분")
//    LocalDateTime ticketCloseAt,

    Boolean isActivated,

    List<ExhibitionFindArtistResponseDto> artists,

    // restaurant
     Long id,
     String name,
//     Long sellerId,
     String address,
     String phoneNumber,
    @Enumerated(EnumType.STRING)
     ClosedDays closedDay,       // 기본 휴무일
    @JsonFormat(pattern = "HH:mm")
     LocalTime openTime,        // 영업 시작 시간
    @JsonFormat(pattern = "HH:mm")
     LocalTime closeTime,      // 영업 종료 시간
//    @Enumerated(EnumType.STRING)
     RestaurantType restaurantType,
     int capacity,              // 총 좌석 수
    @Enumerated(EnumType.STRING)
     ActivationStatus isActivation,  // 영업 활성 상태
     String city,
    @Enumerated(EnumType.STRING)
     WaitingStatus waitingActivation  // 웨이팅 사용 유무

){
    public static AllFinalResponseDto fromPerformance(PerformanceInfoResponseDto dto) {
        return AllFinalResponseDto.builder()
                .performanceId(dto.performanceId())
                .sellerId(dto.sellerId())
                .performanceName(dto.performanceName())
                .hallId(dto.hallId())
                .castList(dto.castList())
                .description(dto.description())
                .type(dto.type())
                .grade(dto.grade())
                .startDate(dto.startDate())
                .endDate(dto.endDate())
                .ticketOpenAt(dto.ticketOpenAt())
                .ticketCloseAt(dto.ticketCloseAt())
                .build(); // 나머지는 null
    }

    public static AllFinalResponseDto fromExhibition(ExhibitionInfoResponseDto dto) {

        // TODO
        LocalDate ld = dto.startDate();
        ZoneId zone = ZoneId.of("Asia/Seoul");
        Date utilDate = Date.from(ld.atStartOfDay(zone).toInstant());

        LocalDate ed = dto.startDate();
        Date utilDate_e = Date.from(ed.atStartOfDay(zone).toInstant());
        return AllFinalResponseDto.builder()
                .exhibitionId(dto.exhibitionId())
                .price(dto.price())
                .name(dto.name())
                .place(dto.place())
                .address(dto.address())
                .region(dto.region())
                .grade(dto.grade())
                .startDate(utilDate) // TODO
                .endDate(utilDate_e) // TODO
                .startTime(dto.startTime())
                .endTime(dto.endTime())
                .ticketOpenAt(Timestamp.valueOf(dto.ticketOpenAt()))
                .ticketCloseAt(Timestamp.valueOf(dto.ticketCloseAt()))
                .isActivated(dto.isActivated())
                .artists(dto.artists())
                .build();
    }

    public static AllFinalResponseDto fromRestaurant(RestaurantInfoResponseDto dto) {
        return AllFinalResponseDto.builder()
                .id(dto.id())
                .name(dto.name())
                .sellerId(dto.sellerId())
                .address(dto.address())
                .phoneNumber(dto.phoneNumber())
                .closedDay(dto.closedDay())
                .openTime(dto.openTime())
                .closeTime(dto.closeTime())
                .restaurantType(dto.type())
                .capacity(dto.capacity())
                .isActivation(dto.isActivation())
                .city(dto.city())
                .waitingActivation(dto.waitingActivation())
                .build();
    }
}
