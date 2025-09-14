package com.dayaeyak.search.domain.search.repository.feign.exhibition.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;

@Getter
public enum SearchType {

    NAME("name"), PLACE("place"), ARTIST("artist");
    private final String code;
    SearchType(String code){ this.code = code; }
    @Override public String toString(){ return code; }      // ← 쿼리 전송값
    public static SearchType of(String in){
        if (in == null) return null;
        String s = in.trim();
        return Arrays.stream(values())
                .filter(v -> v.code.equalsIgnoreCase(s) || v.name().equalsIgnoreCase(s))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNSUPPORTED_MEDIA_TYPE));
    }
}

//    NAME, PLACE, ARTIST;

//    NAME("name", QExhibition.exhibition.name),
//    PLACE("place", QExhibition.exhibition.place),
//    ARTIST("artist", QArtist.artist.name),
//    NAME("name", QExhibition.exhibition.name),
//    PLACE("place", QExhibition.exhibition.place),
//    ARTIST("artist", QArtist.artist.name),
//    ;

//    private final String type;
//    private final StringPath path;
//
//    public static SearchType of(String type) {
//        return Arrays.stream(SearchType.values())
//                .filter(searchType -> searchType.type.equalsIgnoreCase(type))
//                .findFirst()
//                .orElseThrow(() -> new CustomRuntimeException(ExhibitionExceptionType.INVALID_SEARCH_TYPE));
//    }

