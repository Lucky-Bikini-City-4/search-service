package com.dayaeyak.search.domain.search.repository.feign.exhibition.response;

import com.dayaeyak.search.domain.search.repository.feign.exhibition.enums.Region;
import com.dayaeyak.search.domain.search.repository.feign.performance.enums.Grade;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Builder
public record ExhibitionInfoResponseDto(
        Long exhibitionId,

        Integer price,

        String name,

        String place,

        String address,

        Region region,

        Grade grade,

        @JsonFormat(pattern = "yyyy년 MM월 dd일")
        LocalDate startDate,

        @JsonFormat(pattern = "yyyy년 MM월 dd일")
        LocalDate endDate,

        @JsonFormat(pattern = "HH시 mm분")
        LocalTime startTime,

        @JsonFormat(pattern = "HH시 mm분")
        LocalTime endTime,

        @JsonFormat(pattern = "yyyy년 MM월 dd일 HH시 mm분")
        LocalDateTime ticketOpenAt,

        @JsonFormat(pattern = "yyyy년 MM월 dd일 HH시 mm분")
        LocalDateTime ticketCloseAt,

        Boolean isActivated,

        List<ExhibitionFindArtistResponseDto> artists
) {

}
