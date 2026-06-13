package io.github.abdelrahmantanga.study.coding.arrays;

public class AdjacentFlowerBed {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1 && n > 0)
            return flowerbed[0] == 0;
        int remaining = n;
        if (remaining == 0)
            return true;
        for (int i=0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && canPlant(flowerbed, i)) {
                remaining--;
                flowerbed[i] = 1;
                if (remaining == 0)
                    return true;
            }
        }
        return false;
    }

    private boolean canPlant(int[] flowerbed, int i) {
        if (i == 0) {
            return flowerbed[i + 1] == 0;
        } else if (i == flowerbed.length - 1) {
            return flowerbed[i - 1] == 0;
        } else {
            return flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0;
        }
    }
}
