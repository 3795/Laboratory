package com.github.base.nowcoder;

/**
 * Created By Seven.wk
 * Description: 替换空格
 * Created At 2019/02/21
 */
public class Offer02 {

    public static String replaceSpace(StringBuffer str) {
        for (int i=0; i<str.length(); i++) {
            if (' ' == str.charAt(i)) {
                str.replace(i, i+1, "%20");
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(stringBuffer));
    }

}
