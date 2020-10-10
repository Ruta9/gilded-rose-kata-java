package com.gildedrose;

import com.gildedrose.qualitycalculationtemplate.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class QualityCalculationAlgorithmFactory {

    private interface AlgorithmFactory {
        QualityCalculationTemplate createAlgorithm();
    }

    private static final Map<String, AlgorithmFactory> algorithmsMap = createMap();

    private static Map<String, AlgorithmFactory> createMap () {
        Map<String, AlgorithmFactory> map = new HashMap<>();
        map.put("Sulfuras, Hand of Ragnaros", SulfurasQuality::new);
        map.put("Aged Brie", DefaultQualityIncreasing::new);
        map.put("Backstage passes to a TAFKAL80ETC concert", BackstagePassesQuality::new);
        return Collections.unmodifiableMap(map);

    }

    public QualityCalculationTemplate getAlgorithm(String itemName){
        AlgorithmFactory factory = algorithmsMap.get(itemName);
        if (factory == null) {
            return new DefaultQualityDecreasing();
        }
        else return factory.createAlgorithm();
    }
}
