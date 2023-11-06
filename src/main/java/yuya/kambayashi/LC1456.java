package yuya.kambayashi;

public class LC1456 {
    public int maxVowels(String s, int k) {

        int max = 0;
        for(int i = 0; i < k; i++){
            if (isVowel(s.charAt(i))){
                max++;
            }
        }

        int res = max;

        for(int i = k; i < s.length(); i++){
            if (isVowel(s.charAt(i - k))){
                max--;
            }

            if (isVowel(s.charAt(i))){
                max++;
            }
            res = Math.max(res, max);
        }

        return res;
    }
    public boolean isVowel(char c){
        return c == 'a' || c == 'i' || c == 'u' || c == 'e' || c == 'o';
    }
}
