package com.tv.springbootwork.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 統一的 API 回應封裝，支援 i18n 的訊息與狀態
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBean<T> {

    /**
     * 操作事件（如查詢、新增、更新）
     */
    private String action;

    /**
     * 執行狀態碼
     */
    private int statusCode;

    /**
     * 回應訊息（i18n）
     */
    private String message;

    /**
     * 回傳資料
     */
    private T datas;

    /**
     * Response 建構工具
     */
    public static class Builder {

        public static <T> ResponseBean<T> success(Action action , Code code,T data) {
            return build(action, code, data);
        }

        public static <T> ResponseBean<T> error(Action action , Code code) {
            return build(action, code, null);
        }

        public static <T> ResponseBean<T> build(Action action, Code code, T data) {
            return ResponseBean.<T>builder()
                    .action(MessageUtil.getMessage(action.getMessageKey()))
                    .statusCode(code.code())
                    .message(MessageUtil.getMessage(code.getMessageKey()))
                    .datas(data)
                    .build();
        }
    }
}
