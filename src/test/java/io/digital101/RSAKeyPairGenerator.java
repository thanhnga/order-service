package io.digital101;

import java.io.FileWriter;
import java.io.IOException;
import java.security.*;
import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RSAKeyPairGenerator {
    @Test
    public void generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // Độ dài của private key

        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        String privateKeyBase64 = Base64.encodeBase64String(privateKey.getEncoded());
        String privateKeyPEM = "-----BEGIN PRIVATE KEY-----\n" + privateKeyBase64 + "\n-----END PRIVATE KEY-----";
        System.out.println(privateKeyBase64);
        writeFile("src/main/resources/app.key",privateKeyPEM);

        String publicKeyBase64 = Base64.encodeBase64String(keyPair.getPublic().getEncoded());
        String publicKeyPEM = "-----BEGIN PUBLIC KEY-----\n" + publicKeyBase64 + "\n-----END PUBLIC KEY-----";
        writeFile("src/main/resources/app.key.pub",publicKeyPEM);
    }

    private void writeFile(String filePath, String content){
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            // Ghi chuỗi vào tệp
            fileWriter.write(content);
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}
