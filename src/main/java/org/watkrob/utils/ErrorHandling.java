package org.watkrob.utils;

/**
 * Created by robertwatkins on 1/8/17.
 */
public final class ErrorHandling {

    private ErrorHandling() {
    }

    public static void throwNPE(String msg) {
        System.out.println(msg);
        throw new NullPointerException();
    }

    public static void logMessage(String msg) {
        System.out.println(msg);
    }
}
