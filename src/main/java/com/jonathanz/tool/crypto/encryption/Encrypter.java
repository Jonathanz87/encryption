package com.jonathanz.tool.crypto.encryption;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

public interface Encrypter {
    String encrypt(byte[] plainText) throws BadPaddingException, IllegalBlockSizeException;
}
