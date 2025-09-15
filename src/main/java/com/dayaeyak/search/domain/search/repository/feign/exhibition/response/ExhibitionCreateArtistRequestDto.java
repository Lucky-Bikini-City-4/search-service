package com.dayaeyak.search.domain.search.repository.feign.exhibition.response;

import jakarta.validation.constraints.NotBlank;

public record ExhibitionCreateArtistRequestDto (
        @NotBlank
        String name
) {
}
