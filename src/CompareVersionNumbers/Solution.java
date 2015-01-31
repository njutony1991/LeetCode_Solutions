package CompareVersionNumbers;

/**
 * Created by tony on 15-1-29.
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");

        int i=0,j=0;
        while(i<ver1.length&&j<ver2.length){
            long tmp1 = Long.parseLong(ver1[i]);
            long tmp2 = Long.parseLong(ver2[j]);
            if(tmp1 < tmp2)
                return -1;
            if(tmp1 > tmp2)
                return 1;
            i++;
            j++;
        }
        while(i<ver1.length) {
            long tmp = Long.parseLong(ver1[i]);
            if(tmp!=0)
                return 1;
            i++;
        }
        while(j<ver2.length) {
            long tmp = Long.parseLong(ver2[j]);
            if(tmp!=0)
                return -1;
            j++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String test= "12.56";
        String[] t = test.split("\\.");
        System.out.println(t.length+" "+t[0]+" "+t[t.length-1]);
    }
}
