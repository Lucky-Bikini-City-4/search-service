package com.dayaeyak.search.domain.search.repository.feign.performance.response;

public record PageInfoDto(
        int page,
        int size,
        long totalElements,
        int totalPages,
        boolean last
) {
}
