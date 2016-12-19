import edu.duke.FileResource;


public class TestCaesarCipherTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestCaesarCipherTwo().simpleTests();
	}
	
	public void simpleTests() {
		// TODO Auto-generated method stub
		FileResource resource = new FileResource("data/mysteryTwoKeysQuiz.txt");
		CaesarCipherTwo cc2=new CaesarCipherTwo(14, 24);
		String encrypted=cc2.encryptTwoKeys(resource.asString());
		System.out.println("encrypted:" + encrypted);
		String decrypted=cc2.decrypt(encrypted);
		System.out.println("decrypted:" + decrypted);
		System.out.println("breakCaesarCipher:" + breakCaesarCipher(encrypted));
		
	}
	
	public String breakCaesarCipher(String encrypted) {
		String encrypted_1;
		String encrypted_2;
		encrypted_1=halfOfString(encrypted, 0);
		encrypted_2=halfOfString(encrypted, 1);
		int breakedkey1=(getKey(encrypted_1)-4)>0?getKey(encrypted_1)-4:26+getKey(encrypted_1)-4;
		int breakedkey2=(getKey(encrypted_2)-4)>0?getKey(encrypted_2)-4:26+getKey(encrypted_2)-4;
		System.out.println(breakedkey1);
		System.out.println(breakedkey2);
		return new CaesarCipherTwo(breakedkey1, breakedkey2).decrypt(encrypted);
	}
	
	public String halfOfString(String message, int start) {
		StringBuilder build=new StringBuilder();
		for(int i=start;i<message.length();i=i+2){
			char ch=message.charAt(i);
			build.append(ch);
		}
		return build.toString();
	}

	public int getKey(String s) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] counts=countLetters(s, alphabet); 
//		for(int k : counts){
//			System.out.print(k);
//		}
		return maxIndex(counts);
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

}
