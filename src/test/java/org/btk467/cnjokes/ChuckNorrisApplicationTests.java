package org.btk467.cnjokes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChuckNorrisApplicationTests {

	@Test
	void contextLoads() {
	}
	
	//@Test
	void testSonarCloudRule() {
	  
	  List<String> strings = Arrays.asList("a1", "a2", "b1", "c2", "c1");
	  
	  Stream<String> pipeline = strings.stream().filter(b -> b.contains("2"));
	      long count1 = pipeline.count();
	      long count2 = pipeline.mapToLong(b -> b.length()).sum(); // Non-compliant;
	      System.out.println(String.format("Counts: %l %l",count1,count2));
	}

}
