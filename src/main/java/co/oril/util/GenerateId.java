package co.oril.util;

import java.util.UUID;

public final class GenerateId {

    private GenerateId() {
    }

    public static String getGeneratedId() {
        return UUID.randomUUID().toString();
    }
}
