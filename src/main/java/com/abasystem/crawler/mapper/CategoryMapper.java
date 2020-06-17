package com.abasystem.crawler.mapper;

import java.util.HashMap;
import java.util.Map;

public class CategoryMapper {
    protected final Integer DEFAULT_MAX_PAGE = 1;

    /**
     * Map <카테고리 Link, 긁어올 maxPage>
     */
    protected Map<String, Integer> map;

    public CategoryMapper() {
        this.map = new HashMap<>();
    }
}
