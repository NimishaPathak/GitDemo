
public class CoreJavaBrushUp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int myNum = 5; // primitive variable - integer
		String website = "Rahul Shetty Acadamy"; //non primitive variable - strings
		char letter = 'r';
		double decimal = 5.99;
		boolean myCard = true;
		
		System.out.println(myNum + " is the value stored in myNum variable.");
		
		//Arrays
		int[] array = new int[5]; // static array
		array[0] = 2;
		array[1] = 3;
		array[2] = 4;
		array[3] = 5;
		array[4] = 6;
		
		int[] array1 = {5,6,7,8,9}; // static array
		
		System.out.println(array1[1]);
		
		//For loop
		for (int i=0; i < array.length; i++)
		{
			System.out.println(array[i]);
		}
		
		String[] names = {"nimisha", "dishant", "pathak"};
		
		for(int i=0; i<names.length; i++)
		{
			System.out.println(names[i]);
		}
		
		for(String n : names)
		{
			System.out.println(n);
		}
	}

}