public class WordPlay {
    
	public static void main(String[] args) {
		System.out.println("replaceVowels:" + new WordPlay().replaceVowels("Hello World", '*'));
		System.out.println("emphasize:" + new WordPlay().emphasize("dna ctgaaactga", 'a'));
		System.out.println("emphasize:" + new WordPlay().emphasize("Mary Bella Abracadabra", 'a'));
	}
	
	public boolean isVowel(char ch){
    	boolean test=false;
    	ch = Character.toLowerCase(ch);    	
    	char[] array = {'a', 'e', 'i', 'o', 'u'};
    	for(int i = 0; i < array.length; i++){ 
    		if(ch==array[i]){
    			test = true;
    			break;
    		}	
    	}
    	return test;
    }

	public String replaceVowels(String phrase, char ch){
		StringBuilder strbuild=new StringBuilder();
    	ch = Character.toLowerCase(ch);    	
    	char[] array = phrase.toCharArray();
    	for(int i = 0; i < array.length; i++){ 
    		if(isVowel(array[i])){
    			strbuild.append(ch);
    		}else{
    			strbuild.append(array[i]);
    		}
    	}
    	return strbuild.toString();
    }
	
	public String emphasize(String phrase, char ch){
		StringBuilder strbuild=new StringBuilder();
    	ch = Character.toLowerCase(ch);    	
    	char[] array = phrase.toCharArray();
    	for(int i = 0; i < array.length; i++){ 
    		if(ch==Character.toLowerCase(array[i])){
    			if(i%2==0){
        			strbuild.append("+");
    			}else{
        			strbuild.append("*");
    			}
    		}else{
    			strbuild.append(array[i]);
    		}
    	}
    	return strbuild.toString();
    }
}