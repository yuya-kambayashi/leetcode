package yuya.kambayashi;

public class LC605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0){
            return true;
        }
        for(int i = 0; i < flowerbed.length; i++){

            if (i == 0){
                if (flowerbed[i] == 0 && flowerbed[i + 1] == 0){
                    flowerbed[i] = 1;
                    n--;
                }
            }
            else if (i == flowerbed.length - 1){
                    if (flowerbed[i-1] == 0 && flowerbed[i] == 0){
                        flowerbed[i] = 1;
                        n--;
                    }
            }
            else {
                if (flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0 ) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
            if (n == 0){
                return true;
            }
        }


        return false;
    }
}
