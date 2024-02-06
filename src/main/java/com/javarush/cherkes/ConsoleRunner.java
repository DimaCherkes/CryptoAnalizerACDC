package com.javarush.cherkes;

import com.javarush.cherkes.actions.Decrypt;
import com.javarush.cherkes.actions.Encrypt;
import com.javarush.cherkes.constants.StaticSymbols;
import com.javarush.cherkes.util.Communication;

public class ConsoleRunner {
    public static void main(String[] args) {

        //Communication.start();
        Encrypt encryptor = new Encrypt(1);
        char[] input = "Hello, World!".toCharArray();
        char[] exp = encryptor.execute(input);


        Decrypt decrypt = new Decrypt(1);
        char[] ecp = decrypt.execute("Ifmmp-!Xpsme\"".toCharArray());
    }
}
