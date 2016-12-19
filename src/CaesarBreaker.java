import edu.duke.FileResource;


public class CaesarBreaker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String encrypted="Vo ijji wz di ocz xjiazmzixz mjjh rdoc tjpm cvo ji ajm v npmkmdnz kvmot. TZGG GJPY!";
		encrypted="Io iwjv jz dv bcm kjvammmikz mwju edbc twpz pvb wi awm v ncmxmqnm xvzog. TMGT TJCY!";
		encrypted="Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu";
		encrypted="Akag tjw Xibhr awoa aoee xakex znxag xwko";
		FileResource resource = new FileResource("data/mysteryTwoKeysPractice.txt");
		new CaesarBreaker().decryptTwoKeys(resource.asString());
//		String encrypted_1;
//		String encrypted_2;
//		int index=0;
//		StringBuilder build1=new StringBuilder();
//		StringBuilder build2=new StringBuilder();
//		for(char ch:encrypted.toCharArray()){
//			if(index%2==0){
//				build1.append(ch);
//			}else{
//				build2.append(ch);
//			}		
//			index++;
//		}
//		encrypted_1=build1.toString();
//		String decrypted1=new CaesarBreaker().testDecrypt(encrypted_1);
//		encrypted_2=build2.toString();
//		String decrypted2=new CaesarBreaker().testDecrypt(encrypted_2);
//		StringBuilder build=new StringBuilder();
//		index=0;
//		for(char ch:decrypted1.toCharArray()){
//			build.append(ch);
//			try {
//				build.append(decrypted2.toCharArray()[index]);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			index++;
//		}
//		System.out.println(build1.toString());
//		System.out.println(build2.toString());
//		System.out.println(build.toString());
		//new CaesarBreaker().decryptTwoKeys(encrypted);
	}
	
	public void decryptTwoKeys(String encrypted) {
		String encrypted_1;
		String encrypted_2;
		String decrypted_1 = null;
		String decrypted_2 = null;
		int key1=0;
		int key2=0;
		encrypted_1=halfOfString(encrypted, 0);
		encrypted_2=halfOfString(encrypted, 1);
		for(int i=0;i<26;i++){
			if(getKey(decrypt(encrypted_1, i))==4){
				key1=i;
				decrypted_1=decrypt(encrypted_1, i);
				System.out.println("key1:"+key1);
			}
			if(getKey(decrypt(encrypted_2, i))==4){
				key2=i;
				decrypted_2=decrypt(encrypted_2, i);
				System.out.println("key2:"+key2);
			}
		}
		//decrypted_1=decrypt(encrypted_1, 2);
		//decrypted_2=decrypt(encrypted_2, 20);
		
		StringBuilder build=new StringBuilder();
		int index=0;
		for(char ch:decrypted_1.toCharArray()){
			build.append(ch);
			try {
				build.append(decrypted_2.toCharArray()[index]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			index++;
		}
		testDecrypt(build.toString());
		System.out.println(new CaesarCipher().encryptTwoKeys(build.toString(), key1, key2));
	}
	
	public int getKey(String s) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] counts=countLetters(s, alphabet); 
//		for(int k : counts){
//			System.out.print(k);
//		}
		return maxIndex(counts);
	}
	public String halfOfString(String message, int start) {
		StringBuilder build=new StringBuilder();
		for(int i=start;i<message.length();i=i+2){
			char ch=message.charAt(i);
			build.append(ch);
		}
		return build.toString();
	}
	
	public String decrypt(String encrypted, int key) {
		CaesarCipher chipher=new CaesarCipher();
        String message = chipher.encrypt(encrypted, 26 - key);
		return message;
		
	}
	
	public void testDecrypt(String decrypted) {
		System.out.println(decrypted);
	}
	
	public int[] countLetters(String encrypted, String alphabet) {
		int[] counts=new int[26];
		for(char ch:encrypted.toCharArray()){
			if(alphabet.indexOf(Character.toUpperCase(ch))>0){
				counts[alphabet.indexOf(Character.toUpperCase(ch))]++;
			}
		
		}
		return counts;
	}
	
	public int maxIndex(int[] values) {
		int max=0;
		int index=0;
		int indexOfMax=0;
		for(int value : values){
			index++;
			if(value>max){
				max=value;
				indexOfMax=index;
			}
		}
		return indexOfMax-1;
	}

	public String decrypt1(String encrypted) {
		CaesarCipher chipher=new CaesarCipher();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String s;
		String decrypted = null;
		for(int i=0;i<26;i++){
			s=chipher.encrypt(encrypted, i);
			System.out.println(s + ":" + i);
			int[] counts=countLetters(s, alphabet);
			for(int k : counts){
				System.out.print(k);
			}
			System.out.println("indexOfMax:" + maxIndex(counts));
			System.out.println(alphabet);
			if(maxIndex(counts)==4){
				decrypted=s;
			}
		}
		return decrypted;
		
	}
}
