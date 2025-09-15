package com.dayaeyak.search.domain.search.repository.feign.exhibition.response;

import lombok.Getter;

import java.util.List;


@Getter
public class ExhibitionFinalListResponseDto {
    private PageInfoResponseDto pageInfo;
    private List<ExhibitionInfoResponseDto> data;
}