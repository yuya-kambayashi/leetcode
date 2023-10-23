package yuya.kambayashi;

public class LC342 {
    public boolean isPowerOfFour(int n) {

        if (n == 1){
            return true;
        }
        if (n == 0){
            return false;
        }

        while(n % 4 == 0){
            n /= 4;
        }


        return n == 1;
    }
}
