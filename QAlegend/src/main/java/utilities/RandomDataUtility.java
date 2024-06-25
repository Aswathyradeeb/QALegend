package utilities;

import java.util.Random;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	static Faker faker;
	
	public static String getEmail() {
		faker=new Faker();
		return faker.internet().emailAddress();
	}
	public static String getPrefix() {
		faker=new Faker();
		return faker.name().prefix();
	}
	public static String getFirstName() {
		faker=new Faker();
		return faker.name().firstName();
	}
	public static String getLastName() {
		faker=new Faker();
		return faker.name().lastName();
	}

	public static int getNumber() {
		Random randomNum = new Random();
		return randomNum. nextInt(100);
	}
}
