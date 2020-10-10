package com.gildedrose;


/**
 * Both SellInDaysCalculationAlgorithmFactory and QualityCalculationAlgorithmFactory
 * should be injected into GildedRose.
 */
class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void update() {
        for (Item item : items) {
            updateSellInDays(item);
            updateQuality(item);
        }
    }

    private void updateSellInDays(Item item){
        item.sellIn = new SellInDaysCalculationAlgorithmFactory()
                .getAlgorithm(getItemType(item.name))
                .calculateSellInDays(item.sellIn);
    }

    private void updateQuality(Item item){
        item.quality = new QualityCalculationAlgorithmFactory()
                .getAlgorithm(getItemType(item.name))
                .calculate(item.sellIn, item.quality);
    }

    private ItemType getItemType (String name){
        return ItemType.fromString(name);
    }
}