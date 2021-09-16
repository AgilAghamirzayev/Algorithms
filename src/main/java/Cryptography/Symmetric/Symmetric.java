package Cryptography.Symmetric;

import java.security.SecureRandom;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.xml.bind.DatatypeConverter;

public class Symmetric {

    private static final String AES = "AES";

    // We are using a Block cipher(CBC mode)
    private static final String AES_CIPHER_ALGORITHM = "AES/CBC/PKCS5PADDING";


    // Function to create a secret key
    public static SecretKey createAESKey() throws Exception {
        SecureRandom securerandom = new SecureRandom();
        KeyGenerator keygenerator = KeyGenerator.getInstance(AES);

        keygenerator.init(256, securerandom);
        return keygenerator.generateKey();
    }

    // Function to initialize a vector with an arbitrary value
    public static byte[] createInitializationVector() {

        // Used with encryption
        byte[] initializationVector = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(initializationVector);
        return initializationVector;
    }

    // This function takes plaintext,  the key with an initialization
    // vector to convert plainText into CipherText.
    public static byte[] doAESEncryption(String plainText, SecretKey secretKey, byte[] initializationVector) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);

        IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);

        return cipher.doFinal(plainText.getBytes());
    }

    // This function performs the  reverse operation of the  do_AESEncryption function.
    // It converts ciphertext to  the plaintext using the key.
    public static String doAESDecryption(byte[] cipherText, SecretKey secretKey, byte[] initializationVector) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);

        IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);

        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);

        byte[] result = cipher.doFinal(cipherText);

        return new String(result);
    }

    // Driver code
    public static void main(String[] args) throws Exception {
        Scanner message = new Scanner(System.in);

        SecretKey symmetricKey = createAESKey();

        System.out.println("Simmetrik açar : " + DatatypeConverter.printHexBinary(symmetricKey.getEncoded()));

        byte[] initializationVector = createInitializationVector();

        System.out.print("Mesajı daxil edin: ");
        String plainText = message.nextLine();

        byte[] cipherText = doAESEncryption(plainText, symmetricKey, initializationVector);

        System.out.println("Enkript olunmuş mesaj : " + DatatypeConverter.printHexBinary(cipherText));

        String decryptedText = doAESDecryption(cipherText, symmetricKey, initializationVector);

        System.out.println("Sənin əsil mesajın : " + decryptedText);

    }
}