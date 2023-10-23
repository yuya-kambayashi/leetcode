package yuya.kambayashi;

public class LC151 {
    public String reverseWords(String s) {

        String[] sa = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for(int i = sa.length - 1; i >= 0; i--) {
            if (sa[i].equals(" ") || sa[i].equals("")){
                continue;
            }
            sb.append(sa[i]);

            sb.append(" ");
        }

        return sb.toString().trim();
    }
}
