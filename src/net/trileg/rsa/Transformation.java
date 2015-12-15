package net.trileg.rsa;

import java.math.BigInteger;

public class Transformation {
  public BigInteger Encrypt(BigInteger data, BigInteger N, BigInteger E) {
    return data.modPow(E, N);
  }


  public BigInteger Decrypt(BigInteger data, BigInteger N, BigInteger D) {
    return data.modPow(D, N);
  }
}
