package net.trileg.rsa;

import java.math.BigInteger;

public class Euclidean {

  public BigInteger euclidean(BigInteger a, BigInteger b) {
    BigInteger minus_one = new BigInteger(String.valueOf("-1"), 10);
      if (a.compareTo(b) == -1) {
      BigInteger tmp = a;
      a = b;
      b = tmp;
    }

    if (b.compareTo(BigInteger.ZERO) == 0 || b.compareTo(BigInteger.ZERO) == -1) return minus_one;
    if (a.mod(b).compareTo(BigInteger.ZERO) == 0) return b;
    return euclidean(b, a.mod(b));
  }


  public BigInteger extendedEuclidean(BigInteger l, BigInteger e) {
    BigInteger x1 = BigInteger.ONE;
    BigInteger y1 = BigInteger.ZERO;
    BigInteger z1 = l;
    BigInteger x2 = BigInteger.ZERO;
    BigInteger y2 = BigInteger.ONE;
    BigInteger z2 = e;
    BigInteger q = BigInteger.ZERO;
    BigInteger t = BigInteger.ZERO;

    while (!(z2.compareTo(BigInteger.ONE) == 0)) {
      if (z2.compareTo(BigInteger.ZERO) == 0) break;
      q = (z1.subtract((z1.mod(z2)))).divide(z2);

      x1 = x1.subtract((q.multiply(x2)));
      y1 = y1.subtract((q.multiply(y2)));
      z1 = z1.subtract((q.multiply(z2)));

      t = x1;
      x1 = x2;
      x2 = t;

      t = y1;
      y1 = y2;
      y2 = t;

      t = z1;
      z1 = z2;
      z2 = t;
    }

    if (y2.compareTo(BigInteger.ZERO) == -1) {
      return y2.add(l);
    } else {
      return y2;
    }
  }
}
