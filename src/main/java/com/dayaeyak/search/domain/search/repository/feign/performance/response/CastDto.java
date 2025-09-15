package com.dayaeyak.search.domain.search.repository.feign.performance.response;

public record CastDto(
        Long castId,
        String name
) {
//    public static CastDto from(Cast cast) {
//        return new CastDto(cast.getCastId(), cast.getCastName());
//    }
}
