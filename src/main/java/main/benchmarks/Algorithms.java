package main.benchmarks;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Algorithms {

    public void run() {
        List<BigInteger> testValue2 = new ArrayList<>();
        testValue2.add(BigInteger.valueOf(1));
        testValue2.add(BigInteger.valueOf(2));
        testValue2.add(BigInteger.valueOf(5));
        testValue2.add(BigInteger.valueOf(7));
        testValue2.add(BigInteger.valueOf(13));
        testValue2.add(BigInteger.valueOf(20));
        testValue2.add(BigInteger.valueOf(25));
        testValue2.add(BigInteger.valueOf(30));
        testValue2.add(BigInteger.valueOf(35));
        testValue2.add(BigInteger.valueOf(40));
        testValue2.add(BigInteger.valueOf(60));
        testValue2.add(BigInteger.valueOf(70));
        testValue2.add(BigInteger.valueOf(80));

        int size = testValue2.size();

        for(int i = 0; i < size; ++i) {
            System.out.println(testValue2.get(i) + ": " + fibonacci(testValue2.get(i)));
        }
    }

    static BigInteger fibonacci(BigInteger n)
    {
        BigInteger num1 = BigInteger.valueOf(0), num2 = BigInteger.valueOf(1);
        BigInteger num3 = BigInteger.valueOf(0);

        int size = n.intValue();

        for (int i = 0; i < size; ++i) {
            num3 = num2.add(num1);
            num1 = num2;
            num2 = num3;
        }
        return num3;
    }
}