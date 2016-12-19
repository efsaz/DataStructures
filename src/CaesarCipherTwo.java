
public class CaesarCipherTwo {
	
	private String alphabet;
	private String shiftedAlphabet1;
	private String shiftedAlphabet2;
	private int key1opp;
	private int key2opp;
	public CaesarCipherTwo(){

	}
	public CaesarCipherTwo(int key1, int key2){
		alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1)+
        alphabet.substring(0,key1);
        shiftedAlphabet2 = alphabet.substring(key2)+
        alphabet.substring(0,key2);
        key1opp=26-key1;
        key2opp=26-key2;
	}
	
	
	public static void main(String[] args) {
	}

		
    public String decrypt(String input) {
        CaesarCipherTwo cc = new CaesarCipherTwo(key1opp, key2opp);
        return cc.encryptTwoKeys(input);
    }

	public String encryptTwoKeys(String input) {
        StringBuilder sb = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i < sb.length(); i++) {
            char currChar = sb.charAt(i);
            boolean islowercase=Character.isLowerCase(currChar);
            boolean keyselect=i%2==0;
            int idx = alphabet.indexOf(currChar);
            if(islowercase){
               idx = alphabet.indexOf(Character.toUpperCase(currChar));
            }
            if(idx != -1){
            	char newChar = shiftedAlphabet2.charAt(idx);
                if(keyselect){
                	newChar = shiftedAlphabet1.charAt(idx);
                }
                if(islowercase){
                	sb.setCharAt(i, Character.toLowerCase(newChar));
                }else{
                	sb.setCharAt(i, newChar);
                }
             }
        }
        return sb.toString();
    }
		
	
}

