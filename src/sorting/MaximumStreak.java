package sorting;
import java.util.ArrayList;
import java.util.List;

public class MaximumStreak {

	public static int maxStreak(int m ,  List<String> data) {
		int count =0;
		boolean flag = false;
		for(int i= 0 ; i< data.size() ;i++) {
			for(int k= 0 ; k < m ; k++) {
				if(data.get(i).charAt(k) != 'Y') {
					count =0;
					break;
				}
				else flag =true;
			}
			if(i>0 && flag==true) {
				count= count+1;
			}
			
		}
		return count;
	}
	
	public static void main(String[] args) {
		List<String> a = new ArrayList<>();
		a.add("YYNN");
		a.add("YYYY");
		a.add("YYYY");
		a.add("YYYY");
		a.add("yyyn");
		System.out.println(maxStreak(4, a));
		
		
		
	}
}
