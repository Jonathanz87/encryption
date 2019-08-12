package com.jonathanz.tool.crypto;

import com.jonathanz.tool.crypto.decryption.Decrypter;
import com.jonathanz.tool.crypto.decryption.RSADecrypter;
import com.jonathanz.tool.crypto.encryption.Encrypter;
import com.jonathanz.tool.crypto.encryption.RSAEncrypter;
import com.jonathanz.tool.crypto.key.AsymmetricKeyGenerator;
import com.jonathanz.tool.crypto.key.RSAKeyPairGenerator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RSACrypto {
    private static final Map<String, Command> commandMap = new HashMap<>();

    static {
        commandMap.put("keygen", sArray -> {
            AsymmetricKeyGenerator keyGenerator = new RSAKeyPairGenerator();
            System.out.println("Public Key: " + keyGenerator.getPublicKey());
            System.out.println("Private Key: " + keyGenerator.getPrivateKey());
        });
        commandMap.put("encript", sArray -> {
            Encrypter encrypter = new RSAEncrypter(sArray[0]);
            System.out.println(encrypter.encrypt(sArray[1].getBytes()));
        });

        commandMap.put("decript", sArray -> {
            Decrypter decrypter = new RSADecrypter(sArray[0]);
            System.out.println(new String(decrypter.decrypt(sArray[1])));
        });

    }

    public static void main(String[] args) throws Exception {
        try {
            Command command = commandMap.get(args[0]);
            command.runCommand(Arrays.copyOfRange(args, 1, args.length));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static interface Command {
        void runCommand(String[] args) throws Exception;
    }
}
