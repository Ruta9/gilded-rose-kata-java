package com.gildedrose.sellinstrategy;

public class DefaultSellInCalculation implements SellInDaysCalculationStrategy {

    @Override
    public int calculateSellInDays(int sellIn) {
        return sellIn - 1;
    }
}
