package com.dayaeyak.search.domain.search.repository.feign.exhibition.response;

import lombok.Getter;


@Getter
public class ExhibitionFinalResponseDto {
    private String message;
    private ExhibitionInfoResponseDto data;
}