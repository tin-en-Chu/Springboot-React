package com.tv.springbootwork.util;

import java.util.Locale;

public interface MessageResolvableEnum {
    String getMessageKey();

    default String getMessage() {
        return MessageUtil.getMessage(getMessageKey());
    }

    default String getMessage(Locale locale) {
        return MessageUtil.getMessage(getMessageKey(), locale);
    }
}
