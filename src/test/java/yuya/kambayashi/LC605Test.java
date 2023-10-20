package yuya.kambayashi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LC605Test {
    @Test
    void Case1() {

        int n = 1;
        int[]flowerbed = {1,0,0,0,1};

        var actual = new LC605().canPlaceFlowers(flowerbed, n);

        var expected = true;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void Case2() {

        int n = 2;
        int[]flowerbed = {1,0,0,0,1};

        var actual = new LC605().canPlaceFlowers(flowerbed, n);

        var expected = false;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void Case3() {

        int n = 1;
        int[]flowerbed = {0,0,0,1};

        var actual = new LC605().canPlaceFlowers(flowerbed, n);

        var expected = true;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void Case4() {

        int n = 2;
        int[]flowerbed = {0,0,0,1};

        var actual = new LC605().canPlaceFlowers(flowerbed, n);

        var expected = false;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void Case5() {

        int n = 1;
        int[]flowerbed = {1,0,0};

        var actual = new LC605().canPlaceFlowers(flowerbed, n);

        var expected = true;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void Case6() {

        int n = 2;
        int[]flowerbed = {1,0,0};

        var actual = new LC605().canPlaceFlowers(flowerbed, n);

        var expected = false;

        Assertions.assertEquals(expected, actual);
    }
}
