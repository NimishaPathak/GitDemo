import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Section14_115 {
	// Count the number of names starting with alphabet A in the list
	// Run this file as RUN AS - TESTNG test
	//@Test
	public void regular()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("abc");
		names.add("bcd");
		names.add("ace");
		names.add("cde");
		names.add("adg");
		
		int count = 0;
		for(int i = 0; i<names.size();i++)
		{
			String name = names.get(i);
			if(name.startsWith("a"))
			{
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	//@Test
	public void streamFilter()
	{
		// There is no life for intermediate operations if there is no terminal operations ".count()"
		// Terminal operations will only be executed if intermediate operations "(filter(s->s.startsWith("a")))" returns true
		// We can create stream to store data as example --- Stream.of("abc", "bcd", "ace", "cde", "adg")
		// How to use Filter in stream API
		
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("abc");
		names.add("bcd");
		names.add("ace4");
		names.add("cde");
		names.add("adg@");
		
		Long c = names.stream().filter(s->s.startsWith("a")).count();
		
		System.out.println(c);
		
		// Stream.of("abc", "bcd", "ace", "cde", "adg").filter(s->s.startsWith("a"));
		
		long d = Stream.of("abc", "bcd", "ace", "cde", "adg").filter(s->
				{
					return s.startsWith("a");
					
				}).count();
		
		System.out.println(d);
		
		names.stream().filter(s->s.length()>3).forEach(s->System.out.println(s));
		
		names.stream().filter(s->s.length()>3).limit(1).forEach(s->System.out.println(s));
	}

	//@Test
	public void streamMap()
	{
	
		// print names which have last letter as 'a' with uppercase
		Stream.of("abc", "bcd", "acea", "cde", "adg").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		// print names which have first letter as 'a' and in sorting order with uppercase
		List<String> listNames = Arrays.asList("abc", "bcd", "acea", "cde", "adg");
		
		listNames.stream().filter(s->s.startsWith("a")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		// Merget 2 array list
		
		List<String> nameList1 = Arrays.asList("dishant", "pathak", "aeshaben", "mudra");
		List<String> nameList2 = Arrays.asList("nimisha", "desai", "sumanbhai", "tarlikaben", "bhargav");
		
		Stream<String> mergedStream = Stream.concat(nameList1.stream(), nameList2.stream());
		//mergedStream.sorted().forEach(s->System.out.println(s));
		
		// check whether particular name is present in merged list or not
		boolean flag = mergedStream.anyMatch(s->s.equalsIgnoreCase("NIMISHA"));
		Assert.assertTrue(flag);
	}

	@Test
	public void streamCollect()
	{
		// collect method is used to collect your result and convert back into the list
		List<String> ls = Stream.of("nimisha", "bcd", "acea", "cde", "adga").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println("first name is: "+ls.get(0));
		
		// Print Unique numbers from the array
		// Sort the array
		List<Integer> numbers = Arrays.asList(5, 2, 3, 1, 2, 1);
		List<Integer> DistinctSortedNumbers = numbers.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(DistinctSortedNumbers.get(3));
	}
}
