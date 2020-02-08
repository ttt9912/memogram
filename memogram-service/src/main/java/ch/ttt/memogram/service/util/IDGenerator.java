package ch.ttt.memogram.service.util;

import java.util.UUID;

public final class IDGenerator {

    public static String random() {
        return UUID.randomUUID().toString();
    }
}
