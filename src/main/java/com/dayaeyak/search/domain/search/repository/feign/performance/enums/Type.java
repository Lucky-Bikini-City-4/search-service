package com.dayaeyak.search.domain.search.repository.feign.performance.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Type {
    CONCERT("콘서트"),
    MUSICAL("뮤지컬"),
    PLAY("연극");

    private final String type;
}
