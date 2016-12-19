import edu.duke.FileResource;


public class WordLengths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new WordLengths().testCountWordLengths();
	}

	public void countWordLengths(FileResource resource, int[] counts) {
		// TODO Auto-generated method stub
		int length = 0;
		for(String s : resource.words()){
			length=s.length();
			if(length>1){
				if(!Character.isLetter(s.charAt(0))){
					length--;
				}
				if(!Character.isLetter(s.charAt(s.length()-1))){
					length--;
				}
			}else{
				if(!Character.isLetter(s.charAt(0))){
					length--;
				}
			}
			if(length>0){
				if(length>30){
					counts[30]++;
				}else{
					counts[length]++;
				}
			}
		}
	}

	public int indexOfMax(int[] values) {
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

	public void testCountWordLengths() {
		// TODO Auto-generated method stub
		int[] counts = new int[31];
		System.out.println(counts.length);
		FileResource resource = new FileResource("data/manywords.txt");
		countWordLengths(resource, counts);
		System.out.println(indexOfMax(counts));
		for(int ss : counts){
		System.out.println(ss);
		}
	}
}
