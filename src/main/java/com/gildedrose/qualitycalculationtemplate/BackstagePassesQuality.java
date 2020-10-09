package com.gildedrose.qualitycalculationtemplate;

public class BackstagePassesQuality extends QualityCalculationTemplate {

    @Override
    int calculateQuality(int sellIn, int quality) {
        if (sellIn == 0) return 0;
        if (sellIn <= 5) return quality + 3;
        if (sellIn <= 10) return quality + 2;
        return quality + 1;
    }
}
