package com.gildedrose.qualitycalculationtemplate;

public class DefaultQualityDecreasing extends QualityCalculationTemplate{

    @Override
    int calculateQuality(int sellIn, int quality) {
        return sellIn > 0 ? quality - 1 : quality - 2;
    }
}
