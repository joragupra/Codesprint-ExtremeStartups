import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
	
	private static StringReducer initialize() {
    	BufferedReader reader = 
		          new BufferedReader(new InputStreamReader(System.in));
    	int nCadenas = readInteger(reader);
    	String[] cadenas = readStrings(reader, nCadenas);
		return new StringReducer(cadenas);
    }
	
	private static String[] readStrings(BufferedReader reader, int numCadenas){
    	String[] cadenas = new String[numCadenas];
    	try {
			for(int i=0;i<numCadenas;i++){
				cadenas[i] = reader.readLine();
			}
			return cadenas;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
	
	private static int readInteger(BufferedReader reader){
    	try {
			return Integer.parseInt(reader.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
    }
	
	public static void main(String[] args){
		StringReducer sol = initialize();
		sol.solve();
	}
	
	static class StringReducer{
		private String[] strings;
		
		StringReducer(String[] inputStrings){
			this.strings = inputStrings;
		}
		
		private void solve(){
			
			for(String s : strings){
				int numAs = 0;
				int numBs = 0;
				int numCs = 0;
				for(int i=0;i<s.length();i++){
					if(s.charAt(i)=='a'){
						numAs++;
					}
					else if(s.charAt(i)=='b'){
						numBs++;
					}
					else if(s.charAt(i)=='c'){
						numCs++;
					}
				}
				if(numZeros(numAs, numBs, numCs)==2){
					System.out.println(s.length());
				}
				else if(allEven(numAs, numBs, numCs) || allOdd(numAs, numBs, numCs)){
					System.out.println(2);
				}
				else{
					System.out.println(1);
				}
			}
		}
		
		private int numZeros(int numAs, int numBs, int numCs){
			int result = 0;
			if(numAs==0){
				result++;
			}
			if(numBs==0){
				result++;
			}
			if(numCs==0){
				result++;
			}
			return result;
		}
		
		private boolean allEven(int numAs, int numBs, int numCs){
			return (numAs%2==0)&&(numBs%2==0)&&(numCs%2==0);
		}
		
		private boolean allOdd(int numAs, int numBs, int numCs){
			return (numAs%2==1)&&(numBs%2==1)&&(numCs%2==1);
		}
	}
}
