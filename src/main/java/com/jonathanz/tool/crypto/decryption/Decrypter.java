package com.jonathanz.tool.crypto.decryption;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

public interface Decrypter {
    byte[] decrypt(String cipherText) throws BadPaddingException, IllegalBlockSizeException;
}
