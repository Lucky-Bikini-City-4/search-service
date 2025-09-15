package com.dayaeyak.search.domain.search.repository.feign.exhibition.response;

public record ExhibitionFindArtistResponseDto(
        Long artistId,
        String name
) {

//    public static ExhibitionFindArtistResponseDto from(ExhibitionFindArtistProjectionDto dto) {
//        return new ExhibitionFindArtistResponseDto(dto.artistId(), dto.name());
//    }
}
