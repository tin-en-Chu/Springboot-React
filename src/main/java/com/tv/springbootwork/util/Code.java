package com.tv.springbootwork.util;

public enum Code implements MessageResolvableEnum {

    SUCCESS("response.code.success", 200),
    INSERT_SUCCESS("response.code.insert_success", 201),
    INQUIRE_SUCCESS("response.code.inquire_success", 202),
    DELETE_SUCCESS("response.code.delete_success", 203),
    UPDATE_SUCCESS("response.code.update_success", 204),
    FAIL("response.code.fail", 500),
    PARAM_ERROR("response.code.param_error", 400),
    UNAUTHORIZED("response.code.unauthorized", 401),
    FORBIDDEN("response.code.forbidden", 403),
    NOT_FOUND("response.code.not_found", 404),
    NO_USER_CODE("response.code.no_user_code", 405),
    DUPLICATE_USER_CODE("response.code.duplicate_user_code", 406),
    NO_DATA("response.code.no_data", 407);

    private final String messageKey;
    private final int code;

    Code(String messageKey, int code) {
        this.messageKey = messageKey;
        this.code = code;
    }

    public int code() {
        return this.code;
    }

    @Override
    public String getMessageKey() {
        return messageKey;
    }
}
