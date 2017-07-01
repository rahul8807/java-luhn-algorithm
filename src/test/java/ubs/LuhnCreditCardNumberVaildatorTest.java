package ubs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LuhnCreditCardNumberVaildatorTest {

	List<Long> validCreditCardNos;
	List<Long> invalidCreditCardNos;
	
	
	@Before
	public void setUp(){
		validCreditCardNos = new ArrayList<>();
		invalidCreditCardNos = new ArrayList<>();
		
		validCreditCardNos.add(4408041234567893l);
		validCreditCardNos.add(38520000023237l);
		validCreditCardNos.add(4222222222222l);
		
		invalidCreditCardNos.add(1234567890123456l);
	}
	
	
	@Test
	public void shouldValidateSuccessfullyForValidCreditCardNumberUsingLuhnAlgorithm(){
		LuhnCreditCardNumberValidator luhnCreditCardNumberValidator = new LuhnCreditCardNumberValidator();

		IntStream.range(0, validCreditCardNos.size()).forEach( (i) ->
				 {
					 Assert.assertTrue(validCreditCardNos.get(i)+" is Valid \n", luhnCreditCardNumberValidator.isCreditCardNoValid(validCreditCardNos.get(i)));
				 }
		);
		
	}
	
	@Test
	public void shouldFailValidationForInvalidCreditCardNumbersUsingLuhnAlgorithm(){
		LuhnCreditCardNumberValidator luhnCreditCardNumberValidator = new LuhnCreditCardNumberValidator();

		IntStream.range(0, invalidCreditCardNos.size()).forEach( (i) ->
				 {
					 Assert.assertFalse(invalidCreditCardNos.get(i)+" is Not Valid \n", luhnCreditCardNumberValidator.isCreditCardNoValid(invalidCreditCardNos.get(i)));
				 }
		);
		
	}
	
}
