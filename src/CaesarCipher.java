
public class CaesarCipher {
	
	private String alphabet;
	private String shiftedAlphabet;
	private int mainKey;
	public CaesarCipher(){
		alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	}
	public CaesarCipher(int key){
		alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key)+
        alphabet.substring(0,key);
        mainKey=key;
	}
	
	
	public static void main(String[] args) {
//		String encrypted="Vo ijji wz di ocz xjiazmzixz mjjh rdoc tjpm cvo ji ajm v npmkmdnz kvmot. TZGG GJPY!";
//		encrypted="Can you imagine life WITHOUT the internet AND computers in your pocket?";
//		encrypted="Io iwjv jz dv bcm kjvammmikz mwju edbc twpz pvb wi awm v ncmxmqnm xvzog. TMGT TJCY!";
//		new CaesarCipher().eyeballDecrypt(encrypted);
		new CaesarCipher().testCaesar();
	}

	public void eyeballDecrypt(String encrypted) {
		CaesarCipher chipher=new CaesarCipher();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String s;
		for(int i=0;i<26;i++){
			s=chipher.encrypt(encrypted, i);
			System.out.println(s + ":" + i);
			int[] counts=countLetters(s, alphabet);
			for(int k : counts){
				System.out.print(k);
			}
			System.out.println("indexOfMax:" + new WordLengths().indexOfMax(counts));
			System.out.println(counts[4] + "-");
			System.out.println(alphabet);
		}
		
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
	
	public String encrypt(String input) {
        StringBuilder sb = new StringBuilder(input);
        for(int i = 0; i < sb.length(); i++) {
            char currChar = sb.charAt(i);
            int idx = alphabet.indexOf(currChar);
            if(idx != -1){
                char newChar = shiftedAlphabet.charAt(idx);
                sb.setCharAt(i, newChar);
            }else{
            idx = alphabet.indexOf(Character.toUpperCase(currChar));
            	if(idx != -1){
            		char newChar = shiftedAlphabet.charAt(idx);
            		sb.setCharAt(i, Character.toLowerCase(newChar));
            	}
            }
        }
        return sb.toString();
    }

	public String decrypt(String input) {
		CaesarCipher cc = new CaesarCipher(26 - mainKey);
		return cc.encrypt(input);
    }
	
	public String encrypt(String input, int key) {
        StringBuilder sb = new StringBuilder(input);
        shiftedAlphabet = alphabet.substring(key)+
        alphabet.substring(0,key);
        for(int i = 0; i < sb.length(); i++) {
            char currChar = sb.charAt(i);
            int idx = alphabet.indexOf(currChar);
            if(idx != -1){
                char newChar = shiftedAlphabet.charAt(idx);
                sb.setCharAt(i, newChar);
            }else{
            idx = alphabet.indexOf(Character.toUpperCase(currChar));
            	if(idx != -1){
            		char newChar = shiftedAlphabet.charAt(idx);
            		sb.setCharAt(i, Character.toLowerCase(newChar));
            	}
            }
        }
        return sb.toString();
    }
	
	public String encryptTwoKeys(String input, int key1, int key2) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet1 = alphabet.substring(key1)+
        alphabet.substring(0,key1);
        String shiftedAlphabet2 = alphabet.substring(key2)+
        alphabet.substring(0,key2);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            boolean islowercase=Character.isLowerCase(currChar);
            boolean keyselect=i%2==0;
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            if(islowercase){
               idx = alphabet.indexOf(Character.toUpperCase(currChar));
            }
            //If currChar is in the alphabet
            if(idx != -1){
            	//Get the idxth character of shiftedAlphabet (newChar)
            	
            	char newChar = shiftedAlphabet2.charAt(idx);
                if(keyselect){
                	newChar = shiftedAlphabet1.charAt(idx);
                }
                if(islowercase){
                   encrypted.setCharAt(i, Character.toLowerCase(newChar));
                }else{
                   encrypted.setCharAt(i, newChar);
                }
                    //Replace the ith character of encrypted with newChar
             }
            
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
		
	
    public void testCaesar() {
        //int key = 17;
        int key1 = 21;
        int key2 = 8;
        String message = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        //key1 = 15;
        String encrypted = encrypt(message, key1);
        System.out.println("encrypted:" + encrypted);
        String decrypted = encrypt(encrypted, 26-key1);
        System.out.println(decrypted);
        String encryptTwoKeys = encryptTwoKeys(message, key1, key2);
        System.out.println(encryptTwoKeys);
    }
}

