package com.gildedrose;

import com.gildedrose.qualitycalculationtemplate.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class QualityCalculationAlgorithmFactory {

    private interface AlgorithmFactory {
        QualityCalculationTemplate createAlgorithm();
    }

    private static final Map<ItemType, AlgorithmFactory> algorithmsMap = createMap();

    private static Map<ItemType, AlgorithmFactory> createMap () {
        Map<ItemType, AlgorithmFactory> map = new HashMap<>();
        map.put(ItemType.SULFURAS, SulfurasQuality::new);
        map.put(ItemType.AGED_BRIE, DefaultQualityIncreasing::new);
        map.put(ItemType.BACKSTAGE_PASSES, BackstagePassesQuality::new);
        map.put(ItemType.CONJURED, TwiceAsFastQualityDecreasing::new);

        return Collections.unmodifiableMap(map);
    }

    public QualityCalculationTemplate getAlgorithm(ItemType itemType){
        AlgorithmFactory factory = algorithmsMap.get(itemType);
        if (factory == null) {
            return new DefaultQualityDecreasing();
        }
        else return factory.createAlgorithm();
    }
}
