import edu.duke.FileResource;


public class TestCaesarCipher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestCaesarCipher().simpleTests();
	}
	
	public void simpleTests() {
		// TODO Auto-generated method stub
		FileResource resource = new FileResource("data/small.txt");
		CaesarCipher cc=new CaesarCipher(18);
		String encrypted=cc.encrypt(resource.asString());
		System.out.println("encrypted:" + encrypted);
		String decrypted=cc.decrypt(encrypted);
		System.out.println("decrypted:" + decrypted);
		System.out.println("breakCaesarCipher:" + breakCaesarCipher(encrypted));
		
	}
	
	public String breakCaesarCipher(String input) {
		System.out.println(getKey(input)-4);
		return new CaesarCipher(getKey(input)-4).decrypt(input);
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
