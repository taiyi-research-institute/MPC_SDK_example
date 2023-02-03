package com.luban;

/**
 * @author miller
 * @version 1.0.0
 * @date 2023/1/29
 */
public class MpchdLib {
    static {
        System.loadLibrary("mpc_hd_gg18");
    }

    public MpchdLib() {
    }

    public static native String mkeygen(String manager_url, String config, String code, String phrase, String passwd);

    public static native String sign(String manager_url, String keyshare, String config, String message, String code, String passwd);

}
