package com.gildedrose.qualitycalculationtemplate;

public class SulfurasQuality extends QualityCalculationTemplate{

    public SulfurasQuality(){
        super(0, 80);
    }

    @Override
    int calculateQuality(int sellIn, int quality) {
        return quality;
    }
}
