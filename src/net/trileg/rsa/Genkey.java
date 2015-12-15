package net.trileg.rsa;

import java.math.BigInteger;

public class Genkey {
  public BigInteger[] genkey(BigInteger p, BigInteger q) {
    Euclidean euclidean = new Euclidean();
    BigInteger m, L, gcd = BigInteger.ZERO;
    BigInteger N = p.multiply(q);
    BigInteger p_minus_one = p.subtract(BigInteger.valueOf(1));
    BigInteger q_minus_one = q.subtract(BigInteger.valueOf(1));

    // (p-1)と(q-1)の最大公約数を求める
    if ((m = euclidean.euclidean(p_minus_one, q_minus_one)).compareTo(BigInteger.ZERO) == 1) gcd = m;

    // (p-1)と(q-1)の最小公倍数を，(p-1) * (q-1) / gcd(p-1, q-1)で求める
    L = p_minus_one.multiply(q_minus_one).divide(gcd);

    // EとLの最大公約数が1（EとLが互いに素）なEを探す
    BigInteger E = BigInteger.valueOf(2L);
    while(true) {
      E = E.add(BigInteger.valueOf(1));
      if (euclidean.euclidean(E, L).compareTo(BigInteger.ONE) == 0) break;
    }

    // 拡張ユークリッドの互除法を用いて，E * D mod L = 1になるようなDを求める
    BigInteger D = euclidean.extendedEuclidean(L, E);
    return new BigInteger[]{N, L, E, D};
  }
}
