package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

/*
* TDD 1장
*
* 1. 작은 테스트 작성
* 2. 모든 테스트 실행 후 실패하는지 확인
* 3. 실패한 테스트를 조금 수정한다.
* 4. 모든 테스트가 생공하는 것을 확인한다.
* 4. 중복 제거를 위해 리팩토링을 수행한다.
* */

@SpringBootTest
class DemoApplicationTests {

    @Test
    public void testMultiplication() {
        Money five = Money.dollar(5);
        assert Money.dollar(10).equals(five.times(2));
        assert Money.dollar(15).equals(five.times(3));
    }

    @Test
    public void testEquality(){
        assert Money.dollar(5).equals(Money.dollar(5));
        assert !(Money.dollar(5).equals(Money.dollar(6)));
        assert !(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    public void testCurrency(){
        assert "USD".equals(Money.dollar(1).currency());
        assert "CHF".equals(Money.franc(1).currency());
    }

    @Test
    public void testSimpleAddition(){
        Money sum = Money.dollar(5).plus(Money.dollar(5));
        assert Money.dollar(10).equals(sum);
    }
}

//팩토리 메서드 패턴
class Money{
    protected int amount;
    protected String currency;

    public Money(int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }

    static Money dollar(int amount){
        return new Money(amount, "USD");
    }

    static Money franc(int amount){
        return new Money(amount, "CHF");
    }

    public Money times(int multiplier) {
        return new Money(this.amount * multiplier, currency);
    }

    public Money plus(Money added){
        return new Money(this.amount + added.amount, currency);
    }

    String currency(){
        return currency;
    };

    @Override
    public boolean equals(Object o) {
        Money money = (Money) o;
        return this.amount == money.amount && this.currency().equals(money.currency());
    }
}
