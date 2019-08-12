package com.jonathanz.tool.crypto.key;

public interface AsymmetricKeyGenerator extends KeyGenerator {
    String getPublicKey();

    String getPrivateKey();
}
