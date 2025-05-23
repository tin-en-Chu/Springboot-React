package com.tv.springbootwork.util;

import lombok.extern.slf4j.Slf4j;

public enum Action implements MessageResolvableEnum {

    RUNTIME("response.action.runtime"),
    INSERT("response.action.insert"),
    DELETE("response.action.delete"),
    UPDATE("response.action.update"),
    INQUIRE("response.action.inquire");

    private final String messageKey;

    Action(String messageKey) {
        this.messageKey = messageKey;
    }

    @Override
    public String getMessageKey() {
        return messageKey;
    }
}
