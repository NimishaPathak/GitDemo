import java.util.ArrayList;

public class CoreJavaBrushUp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array3 = {1,2,3,4,5,6,7,8,10}; // static array
		
		//print values multiply by 2
		
		for(int i=0; i<array3.length; i++)
		{
			if(array3[i] % 2 == 0)
			{
				System.out.println(array3[i]);
				break; // to terminate or break the loop once first result is achieved.
			}
			else
			{
				System.out.println(array3[i] + " is not multiply by 2.");
			}
		}
		
		//DYNAMIC ARRAY
		
		//below array is going to store STRING values
		ArrayList<String> a = new ArrayList<String>(); // create a object of the class then use that object to access the methods of that class
		
		a.add("nimisha");
		a.add("pathak");
		a.add("dishant");
		a.add("parramatta");
		a.remove(1);
		System.out.println(a.get(2)); // to extract array value
	}

}
