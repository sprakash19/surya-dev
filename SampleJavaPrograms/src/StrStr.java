
public class StrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		strStr("aaa", "aa");

	}
	
	public static int strStr(String haystack, String needle) {
	       int i =0;
	        int j = needle.length();
	        int needleFound = 0;
	       if(j == 0 || haystack.length() == j) {
	           return 0;
	       }
	        
	        while(i<= haystack.length()-j) {
	        StringBuilder sb = new StringBuilder();
	          for(int k = i; k < i+j; k++) {
	              char ch = haystack.charAt(k);
	              sb.append(ch);
	          }
	            if(sb.toString().equals(needle)) {
	                needleFound = needleFound+1;
	               
	            }
	            i++;
	        }
	        if(needleFound > 1) {
	            return 0;
	        }
	        else if(needleFound==1){
	           return j; 
	        }
	        return -1;
	    }

}
