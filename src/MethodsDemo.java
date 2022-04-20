
public class MethodsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// if you want to create any method in class, you cannot create in PUBLIC void because it may not required to execute.
		
		// when you create any method as STATIC then that method belong to class NO NEED to create object.
		
		
		MethodsDemo m = new MethodsDemo();
		m.getData();
		
		System.out.println(m.getData1());
		
		MethodsDemo2 m2 = new MethodsDemo2();
		m2.getUserData();
		
		System.out.println(getData2());

	}
	//How to create methods (for example: getData) in class (for example: MethodsDemo)
	
	//VOID means this below method does not return anything
	public void getData()
	{
		System.out.println("Hellow world");
	}
	
	public String getData1()
	{
		return "nimisha pathak";
	}
	
	public static int getData2()
	{
		return 21121984;
	}
	
}
