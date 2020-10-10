package com.gildedrose.qualitycalculationtemplate;

public class TwiceAsFastQualityDecreasing extends QualityCalculationTemplate {

    @Override
    int calculateQuality(int sellIn, int quality) {
        return sellIn > 0 ? quality - 2 : quality - 4;
    }
}
