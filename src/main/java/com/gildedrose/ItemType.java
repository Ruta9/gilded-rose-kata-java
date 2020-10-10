package com.gildedrose;

public enum ItemType {

    SULFURAS("Sulfuras, Hand of Ragnaros"),
    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    DEFAULT_ITEM("");

    private final String name;

    ItemType (String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public static ItemType fromString (String name){
        for (ItemType type : ItemType.values()){
            if (type.name.equalsIgnoreCase(name)) {
                return type;
            }
        }
        return DEFAULT_ITEM;
    }
}
