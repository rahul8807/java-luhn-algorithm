package ubs;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class LuhnCreditCardNumberValidator {

	private final Function<Long, List<Integer>> getCreditCardNumberInReverseOrder = (inputCreditCardNumber) -> {

		List<Integer> creditCardNumber = new ArrayList<>();

		while(inputCreditCardNumber > 0){
			int digit = (int) (inputCreditCardNumber % 10);
			inputCreditCardNumber /=  10;
			creditCardNumber.add(digit);
		}

		return creditCardNumber;
	};

	private final Consumer<List<Integer>> doubleEveryOtherDigitOfCreditCardNumber = (creditCardNumber) -> {

		IntStream.iterate(1, i -> i+2)
			.limit(creditCardNumber.size() / 2)
			.forEach((index) -> {
				creditCardNumber.set(index, creditCardNumber.get(index)*2);
			});
	};

	private final Function<Integer,Integer> sumDigitsInNumber = (number) -> {
		
		int sumOfDigits = 0;
		while(number > 0){
			sumOfDigits +=  (number % 10);
			number /= 10;
		}
		return sumOfDigits;
	};
	
	private final Function<List<Integer>,Integer> sumDigitsOfCreditCardNumber = (creditCardNumber) -> {
		
		return creditCardNumber.stream()
					.map(sumDigitsInNumber)
					.reduce((value1,value2) ->  (value1 + value2))
					.get();
	};

	private final Predicate<Integer> isThisValidCreditNumber = (value) ->  (value % 10 == 0) ? Boolean.TRUE : Boolean.FALSE;


	public final boolean isCreditCardNoValid(Long inputCreditCardNumber) {
		
		List<Integer> creditCardNumber = getCreditCardNumberInReverseOrder.apply(inputCreditCardNumber);
		doubleEveryOtherDigitOfCreditCardNumber.accept(creditCardNumber);
		int sum = sumDigitsOfCreditCardNumber.apply(creditCardNumber);
		return isThisValidCreditNumber.test(sum);
	}
	
}
