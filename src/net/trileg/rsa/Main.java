package net.trileg.rsa;

import java.math.BigInteger;

public class Main {

  private static String mode = "e";

  public static void main(String[] args) {
    BigInteger p = BigInteger.valueOf(60549919L), q = BigInteger.valueOf(59513653L);
    Genkey genkey = new Genkey();
    BigInteger[] key = genkey.genkey(p, q);

    BigInteger data = BigInteger.valueOf(102210995L);

    if (mode.equals("e")) {
      Transformation transformation = new Transformation();
      BigInteger encrypted = transformation.Encrypt(data, key[0], key[2]);
      System.out.println("Encrypted: " + encrypted);
    } else {
      Transformation transformation = new Transformation();
      BigInteger decrypted = transformation.Decrypt(data, key[0], key[3]);
      System.out.println("Decrypted: "+decrypted);
    }
  }
}
