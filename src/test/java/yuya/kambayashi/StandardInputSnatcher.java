/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuya.kambayashi;

import java.io.IOException;
import java.io.InputStream;
/**
 *
 * @author kamba
 */
public class StandardInputSnatcher extends InputStream {
       
    private StringBuilder buffer = new StringBuilder();
    private static String crlf = System.getProperty("line.separator");

    public void inputln(String str) {
        buffer.append(str).append(crlf);
    }

    @Override
    public int read() throws IOException {
        if (buffer.length() == 0) {
            return -1;
        }
        int result = buffer.charAt(0);
        buffer.deleteCharAt(0);
        return result;
    }
}
