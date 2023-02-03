package com.luban;

/**
 * @author miller
 * @version 1.0.0
 * @date 2023/2/2
 */
public class MpcTest1 {
    static final String CODE = "9ba78785-6dc0-4a02-9297-d50a8e44d19b";
    static final String PHRASE = "xxxxxx xxxxxx xxxx xxxxx xxxxx xxxxx xxxxx xxxxx xxxxx xxxx xxx hand";

    public static void main(String[] args) {
        MpchdLib.mkeygen("http://xx.xx.xx.xx:8008", "1/2", CODE, PHRASE, "");
    }
}
