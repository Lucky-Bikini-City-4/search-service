package com.dayaeyak.search.domain.search.repository.feign.performance.response;

import com.dayaeyak.search.domain.search.repository.feign.performance.enums.Grade;
import com.dayaeyak.search.domain.search.repository.feign.performance.enums.Type;
import lombok.Builder;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Builder
public record PerformanceInfoResponseDto (
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
    Timestamp ticketCloseAt
) {

}