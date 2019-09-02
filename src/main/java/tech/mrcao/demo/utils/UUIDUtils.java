package tech.mrcao.demo.utils;

import java.util.UUID;

/**
 * 生成 UUID 工具类
 */
public final class UUIDUtils {

    public static String generateUUID32(){

        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String generateUUID36(){

        return UUID.randomUUID().toString();
    }
}
