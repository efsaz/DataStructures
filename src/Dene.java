
public class Dene {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int D[]={7,5,8,3,2,6,1,4,9};
		System.out.println(arayaSokma(D, 9));
		for(int x : D){
			System.out.println(x);
		}
	}
	public static int[] arayaSokma(int D[], int N)
	{
	     int i, k,ekle;

	     for(i=0; i<N; i++){
	            ekle=D[i];

	            for(k=i-1;k>=0 && ekle<=D[k]; k--) 
	                    D[k+1]=D[k];       /* boþalan düðümün bellek alaný serbest býrakýlýyor */
	            D[k+1]=ekle;       /* koy-ekle modu */
	    }
		return D;
	}
}
