package com.booker.core.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class EncryptUtils {
    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);         // 배열에 랜덤한 바이트 값 채우기
        return Base64.getEncoder().encodeToString(salt);  // Base64로 인코딩해서 문자열로 변환
    }

    public static String encryptSHA256WithSalt(String input, String salt) {
        StringBuilder sb = new StringBuilder();
        String saltedInput = sb.append(input).append(salt).toString(); // saltedInput 문자열을 생성
        try {
            // SHA3-256 해시를 계산하여 바이트 배열로 반환
            MessageDigest digest = MessageDigest.getInstance("SHA3-256");
            byte[] hash = digest.digest(saltedInput.getBytes());
            return byteToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // 바이트 배열을 16진수 문자열로 변환
    private static String byteToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = String.format("%02x", b);
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
