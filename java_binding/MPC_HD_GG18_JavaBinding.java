// author: winston-wen 
// time: 2022.12.07 (三) 16:11:15
// Compile me with "javac -h . MPC_HD_GG18_JavaBinding.java"

class MPC_HD_GG18_JavaBinding {
    public static native void keygen(
        String addr, 
        String keysfile_path,
        String params,
        String code
    );

    public static native void sign(
        String addr,
        String keysfile_path,
        String params,
        String message,
        String code,
        String path
    );

    public static void sign(
        String addr,
        String keysfile_path,
        String params,
        String message,
        String code
    ) {
        sign(addr, keysfile_path, params, message, code, "");
    }

    public static String LIBRARY_PATH = null;

    static { // Execute on loading the class definition.
        if (LIBRARY_PATH == null) {
            LIBRARY_PATH = String.format("%s/libmpc_hd_gg18.so", System.getProperty("user.dir"));
        }
        System.load(LIBRARY_PATH);
        System.out.printf("\u001B[1;31mLoad libmpc_hd_gg18.so from \u001B[1;32m%s\u001B[0m%n", LIBRARY_PATH);
    }

    public static void main(String[] args) {
        if (args[0].equals("keygen")) {
            keygen(args[1], args[2], args[3], args[4]);
        }
        else if (args[0].equals("sign")) {
            if (args.length == 7) sign(args[1], args[2], args[3], args[4], args[5], args[6]);
            else if (args.length == 6) sign(args[1], args[2], args[3], args[4], args[5]);
        }
    }
}