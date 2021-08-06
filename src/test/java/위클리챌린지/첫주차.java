package 위클리챌린지;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

public class 첫주차 {
    @Test
    public void main() {
        // int price = 2500;
        int count = 2500;

        BigInteger price = new BigInteger("2500");
        BigInteger sum = new BigInteger(String.valueOf(count * (count + 1) / 2 ));
        BigInteger charged = sum.multiply(price);
        System.out.println(charged);

    }
}
