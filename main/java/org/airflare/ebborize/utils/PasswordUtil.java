package org.airflare.ebborize.utils;

import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class PasswordUtil {

    private static String seed = "qwertyuiopasdfghjklzxcvbnmMNBVCXZLKJHGFDSAPOIUYTREWQ1234567890";

    public static String generateSalt(){
        StringBuilder salt = new StringBuilder();
        Random random = new Random();
        for(int i = 0;i<8;i++){
            int index = random.nextInt(62);
            salt.append(seed.charAt(index));
        }
        return salt.toString();
    }

    private static String addSalt(String password,String salt){
        StringBuilder builder = new StringBuilder();
        for(int i = 0;i<8;i++){
             builder.append(password, i*8, i*8+8);
             builder.append(salt.charAt(i));
        }
        return builder.toString();
    }

    private static String getSHA256Str(String str){
        MessageDigest messageDigest;
        String encdeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(str.getBytes(StandardCharsets.UTF_8));
            encdeStr = Hex.encodeHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encdeStr;
    }

    public static String getFormedPassword(String pwd,String salt){
        return getSHA256Str(addSalt(pwd,salt));
    }
}
