package com.avs.autoValidationSystem.autoValidationLib;

public class NativeAutoValidation {

    static {
        System.loadLibrary("libtest");
    }

    public native String startNimo(String str);

}
