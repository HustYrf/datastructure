package hust.yrf.datastructure;

/**
 * @ClassName Kmp
 * @Descripition KMP算法的实现
 * @Author Administrator
 * @Date 2018/12/13 12:17
 **/
public class Kmp {
    public static int[] getNext(String subStr) {
        int j = -1;
        int i = 0;
        char[] chars = subStr.toCharArray();
        int []prefix =new int[subStr.length()+1];
        prefix[0]=-1;
        while(i<subStr.length()){
            if(j==-1||chars[i]==chars[j]){
                i++;
                j++;
                prefix[i]=j;
            }
            else{
                j=prefix[j];
            }
        }
        return prefix;
    }


    public static int matchStr(String mainStr,String subStr){
        int i=0,j=0;
        int[] next = getNext(subStr);
        while (i<mainStr.length()&&j<subStr.length()){
            if(mainStr.charAt(i)==subStr.charAt(j)) {
                i++;
                j++;
            }else{
                j=next[j];
                if(j==-1){
                    j=0;
                    i++;
                }
            }
        }
        if(j==subStr.length()){
            return i-subStr.length();
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(matchStr("aaaaabbbba", "bba"));
    }
}
