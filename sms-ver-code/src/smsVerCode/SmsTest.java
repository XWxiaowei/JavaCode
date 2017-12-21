package smsVerCode;

public class SmsTest {

	/** 
	  * 创建指定数量的随机字符串 
	  * @param numberFlag 是否是数字 
	  * @param length 
	  * @return 
	  */  
	public static String  createRandom(boolean numberFlag,int length) {
		String retStr="";
	    String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";  
		int len=strTable.length();
		boolean bDone=true;
		do{
			int count=0;
			for (int i = 0; i < length; i++) {
				double dbLR=Math.random()*len;
				int intR=(int) Math.floor(dbLR);
				char c=strTable.charAt(i);
				if (('0'<=c)&&(c<='9')) {
					count++;
				}
				retStr+=strTable.charAt(intR);
			}
			if (count>=2) {
				bDone=false;
			}
		}while(bDone);
	    return retStr;
	}
	public static void main(String[] args) {
		createRandom(false, 4);
	}
}

