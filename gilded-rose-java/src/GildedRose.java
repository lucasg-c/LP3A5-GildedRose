

class GildedRose {
	final int MAX_QUALITY = 50;
	final int SELLING_DATE_TEN = 10;
	final int SELLING_DATE_FIVE = 5;
	
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
    	
    	for(Item item : items) {
    		
    		switch (item.name) 
    		{
	    		case "Aged Brie":
	    			item.quality += 1;
	    			break;
	    		case "Sulfuras, Hand of Ragnaros":
	    			break;
    		}
 
            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        //item.quality = item.quality - 1;
                        item.quality -= 1;
                    }
                }
            } else {
                if (item.quality < MAX_QUALITY) {
                    item.quality = item.quality + 1;

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn <= SELLING_DATE_TEN) {
                            if (item.quality < MAX_QUALITY) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn <= SELLING_DATE_FIVE) {
                            if (item.quality < MAX_QUALITY) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    if (item.quality < MAX_QUALITY) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }

    public void updateSellIn() {
    	for(Item item : items) {
    		 if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
    			 item.sellIn = item.sellIn - 1;
    		 } 
        }

    }
}