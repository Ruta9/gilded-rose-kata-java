package com.gildedrose.qualitycalculationtemplate;

public abstract class QualityCalculationTemplate {

    private int defaultUpperQualityLimit = 50;
    private int defaultLowerQualityLimit = 0;

    QualityCalculationTemplate () {

    }

    QualityCalculationTemplate (int defaultLowerQualityLimit, int defaultUpperQualityLimit){
        this.defaultLowerQualityLimit = defaultLowerQualityLimit;
        this.defaultUpperQualityLimit = defaultUpperQualityLimit;
    }

    abstract int calculateQuality(int sellIn, int quality);

    private int applyLimit(int quality){
        if (quality > defaultUpperQualityLimit) return defaultUpperQualityLimit;
        else if (quality < defaultLowerQualityLimit) return defaultLowerQualityLimit;
        return quality;
    }

    public int calculate (int sellIn, int quality) {
        return applyLimit(calculateQuality(sellIn, quality));
    }
}
