package sample;

import java.util.Scanner;

/**
 * ������4���滻�ո�
 * ��Ŀ����ʵ��һ�����������ַ����е�ÿ���ո��滻��"%20"��
 * �������롰We are happy.�����������We%20are%20happy��.
 */
public class Test4 {
    public static String function1(String input) {
        return input.replace(" ", "%20");
    }

    //�������ú���
    private static String function(String input) {
        //�����ʹ�����ú�������ʹ��char����
        char[] chs = input.toCharArray();
        //����м����ո�
        int countBlankSpace = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == ' ') {
                countBlankSpace++;
            }
        }
        //����һ��char���飬�������������ɵ�����
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
