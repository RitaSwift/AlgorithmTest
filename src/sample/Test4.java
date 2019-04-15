package sample;

import java.util.Scanner;

/**
 * 面试题4：替换空格
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。
 * 例如输入“We are happy.”，则输出“We%20are%20happy”.
 */
public class Test4 {
    public static String function1(String input) {
        return input.replace(" ", "%20");
    }

    //不用内置函数
    private static String function(String input) {
        //如果不使用内置函数，就使用char数组
        char[] chs = input.toCharArray();
        //算出有几个空格
        int countBlankSpace = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == ' ') {
                countBlankSpace++;
            }
        }
        //声明一个char数组，长度是最终生成的数组
        char[] chars = new char[chs.length + countBlankSpace * 2];
        countBlankSpace = 0;
        int i = 0;
        while (i < chars.length) {
            if (chs[i - countBlankSpace * 2] == ' ') {
                chars[i] = '%';
                chars[++i] = '2';
                chars[++i] = '0';
                countBlankSpace++;
            } else{
                chars[i] = chs[i - countBlankSpace * 2];
            }
            i++;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(function(scanner.nextLine()));
        }
    }


}
