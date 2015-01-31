package Read_N_Characters_Given_Read4;
class Reader4{
	int read4(char[] buf){
		return 4;
	}
}
public class Solution extends Reader4{

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
    	char[] temp = new char[6];
    	int round = n/4;
    	int sum = 0;
    	int flag = 1;
    	for(int i=0;i<round;i++){
    		int len = read4(temp);
    		System.arraycopy(temp, 0, buf,i*4, len);
    		sum = sum+len;
    		if(len != 4){
    			flag = 0;
    			break;
    		}
    		assert(len==4);
    	}
    	if(flag!=0&&n%4!=0){
    		int rest = n%4;
    		int left = read4(temp);
    		int last = (rest<left) ? rest: left;
    		System.arraycopy(temp, 0, buf, sum, last);
    		sum = sum+last;
    	}
    	return sum;
    }
	public static void main(String[] args) {


	}

}
