package org.watkrob.utils;

/**
 * Created by robertwatkins on 1/8/17.
 */
public final class ErrorHandling {

    private ErrorHandling() {
    }

    public static String throwNPE(String msg) {
        System.out.println(msg);
        NullPointerException e = new NullPointerException();
        throw e;
    }
}
