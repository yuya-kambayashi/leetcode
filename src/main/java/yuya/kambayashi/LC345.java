package yuya.kambayashi;

public class LC345 {
    public String reverseVowels(String s) {

        int start = 0, end = s.length()-1;

        char[] ca = s.toCharArray();

        while(start < end){
            while (start < s.length() && !isVowel(ca[start])){
                start++;
            }
            while (end >= 0 && !isVowel(ca[end])){
                end--;
            }

            if (start < end){
                swap(ca, start, end);
                start++;
                end--;
            }
        }


        return new String(ca);
    }
    boolean isVowel(char c){
        return c == 'a' || c == 'i' || c == 'u' || c == 'e' || c == 'o' ||
                c == 'A' || c == 'I' || c == 'U' || c == 'E' || c == 'O';

    }

    void swap(char[] chars, int x, int y){
        char t = chars[x];
        chars[x] = chars[y];
        chars[y] = t;
    }
}
