package com.tv.springbootwork.model.vo;

import java.util.List;
import java.util.stream.Collectors;
/**
 * @param <S> 原始物件類型
 * @param <T> 目標 DTO 類型
 */
public abstract class BaseDTO<S, T> {

    /**
     * 每個繼承子類實作
     */
    protected abstract T convert(S source);

    /**
     * 轉換
     */
    public List<T> convertList(List<S> sourceList) {
        return sourceList.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}

