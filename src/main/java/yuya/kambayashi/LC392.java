package yuya.kambayashi;

public class LC392 {
    public boolean isSubsequence(String s, String t) {

        int tindex = 0;
        for(char cs : s.toCharArray()){
            boolean find = false;
            for(int i = tindex; i < t.length(); i++ ){
                char ct = t.charAt(i);
                if (cs == ct){
                    tindex = i;
                    tindex++;
                    find = true;
                    break;
                }
            }
            if (!find){
                return false;
            }

        }

        return true;
    }
}
