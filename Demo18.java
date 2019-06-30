package cyw.cn.fornote.list;

public class Demo18 {
    public static void main(String[] args) {
        long m = 102415986351L;
        long n = 82349720L;
        String sm = Long.toString(m);
        String sn = Long.toString(n);
        int lenm = sm.length();
        int lenn = sn.length();
        int min = lenm<lenn ? lenm:lenn;
        int carry = 0;
        sm = opposite(sm);
        sn = opposite(sn);
        StringBuilder buffer = new StringBuilder();
        for (int i = 0 ;i<min;i++){
            char charm = sm.charAt(i);
            char charn = sn.charAt(i);
            int m1 = charm - '0';
            int n1 = charn - '0';
            int sum = carry+m1+n1;
            if (sum>=10){
                carry = 1;
            }else {
                carry = 0;
            }
            String sumString = String.valueOf(sum);
            if (sumString.length()>1){
                buffer.append(sumString.charAt(1));
            }else {
                buffer.append(sumString.charAt(0));
            }
        }
        String max = lenm>lenn?sm:sn;
        int index = min;
        for (int i = min;i<max.length();i++){
            char charMax = max.charAt(min);
            int intMax = charMax - '0';
            int sum = charMax+carry - '0';
            index++;
            if (sum>=10){
                carry = 1;
                continue;
            }
            buffer.append(sum);
            break;
        }
        String substring = max.substring(index, max.length());
        buffer.append(substring);
        String s = buffer.toString();
        String opposite = opposite(s);
        System.out.println(opposite);
    }

    private static String opposite(String str){
        StringBuilder buffer = new StringBuilder();
        for (int i=str.length()-1 ;i>=0;i--){
            buffer.append(str.charAt(i)-'0');
        }
        return buffer.toString();
    }
}
