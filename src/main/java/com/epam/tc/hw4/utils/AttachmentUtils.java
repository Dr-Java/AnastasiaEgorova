package com.epam.tc.hw4.utils;

import io.qameta.allure.Attachment;

public class AttachmentUtils {

    @Attachment(type = "image/png")
    public static byte[] makeScreenshotAttachment(final String name, final byte[] source) {
        return source;
    }
}
