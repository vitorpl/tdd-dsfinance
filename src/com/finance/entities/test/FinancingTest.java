package com.finance.entities.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.finance.entities.Financing;

public class FinancingTest {

	/**
	 * totalAmount => total de dinheiro financiado
	 * income => renda mensal do cliente
	 * months => número de parcelas do financiamento
	 * 
	 *  entry() -> recuperar valor da entrada
	 *  quota() -> recuperar valor da prestação
	 *  
	 *  Métodos a validar:
	 *  Financing() - válido
	 *  Financing() - inválido  
	 *  setTotalAmount() -v
	 *  setTotalAmount() -i  
	 *  setIncome() -v
	 *  setIncome() -i  
	 *  setMonths() -v
	 *  setMonths() -i  
	 *  setEntry() -v
	 *  setEntry() -i
	 *  
	 *  As regras para financiamento são as seguintes:
	 *  - O valor da entrada deve ser 20% do montante.
	 *  - O valor da prestação deve ser os 80% restantes do montante, divididos pelo número de 
	 *  	meses do financiamento.
	 *  - O valor da prestação não pode ser maior que metade da renda do cliente. 
	 *  	Tanto o construtor com argumentos, quando os métodos 
	 *  	setTotalAmount(double), 
	 *  	setIncome(double), e 
	 * 		setMonths(int) devem lançar uma exceção caso os valores atribuídos não 
	 *  	respeitem esta regra.
	 * 
	 */
	
	@Test
	public void financingShouldNotThrowsExceptionWhenValidParameters() {
		//cenário válido
		double totalAmount = 100_000;
		double income = 2000;
		int months = 80;
		double entry = 20000;
		
		Assertions.assertDoesNotThrow(() -> {
			new Financing(totalAmount, income, months, entry);	
		});
		
	}
	
	@Test
	public void financingShouldThrowsExceptionWhenInvalidParameters() {
		//cenário inválido
		double totalAmount = 100_000;
		double income = 2000;
		int months = 20;
		double entry = 20000;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Financing(totalAmount, income, months, entry);	
		});
	}
	
	@Test
	public void setTotalAmountShouldThrowsExceptionWhenInvalid() {
		double totalAmount = 100_000;
		double income = 2000;
		int months = 80;
		double entry = 20000;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing fin = new Financing(totalAmount, income, months, entry);
			fin.setTotalAmount(200_000);
		});
	}
	
	@Test
	public void setTotalAmountShouldNotThrowsExceptionWhenValid() {
		double totalAmount = 10_000;
		double income = 2000;
		int months = 80;
		double entry = 2000;
		
		Assertions.assertDoesNotThrow(() -> {
			Financing fin = new Financing(totalAmount, income, months, entry);
			fin.setTotalAmount(10_000);
		});
	}
	
	@Test
	public void setIncomeShouldThrowsExceptionWhenInvalid() {
		double totalAmount = 100_000;
		double income = 2000;
		int months = 80;
		double entry = 20000;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing fin = new Financing(totalAmount, income, months, entry);
			fin.setIncome(1000);
		});
	}
	
	@Test
	public void setIncomeShouldNotThrowsExceptionWhenValid() {
		double totalAmount = 100_000;
		double income = 2000;
		int months = 80;
		double entry = 20000;
		
		Assertions.assertDoesNotThrow(() -> {
			Financing fin = new Financing(totalAmount, income, months, entry);
			fin.setIncome(5000);
		});
	}
	
	
	@Test
	public void setMonthsShouldThrowsExceptionWhenInvalid() {
		double totalAmount = 100_000;
		double income = 2000;
		int months = 80;
		double entry = 20000;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing fin = new Financing(totalAmount, income, months, entry);
			fin.setMonths(20);
		});
	}
	
	@Test
	public void setMonthsShouldNotThrowsExceptionWhenValid() {
		double totalAmount = 100_000;
		double income = 2000;
		int months = 80;
		double entry = 20000;
		
		Assertions.assertDoesNotThrow(() -> {
			Financing fin = new Financing(totalAmount, income, months, entry);
			fin.setMonths(100);
		});
	}
	
	
	@Test
	public void setEntryShouldThrowsExceptionWhenInvalid() {
		double totalAmount = 100_000;
		double income = 2000;
		int months = 80;
		double entry = 20000;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing fin = new Financing(totalAmount, income, months, entry);
			fin.setEntry(10_000);
		});
	}
	
	@Test
	public void setEntryShouldNotThrowsExceptionWhenValid() {
		double totalAmount = 100_000;
		double income = 2000;
		int months = 80;
		double entry = 20000;
		
		Financing fin1 = new Financing(totalAmount, income, months, entry);
		
		Assertions.assertDoesNotThrow(() -> {
			Financing fin = new Financing(totalAmount, income, months, entry);
			fin.setEntry(20_000);
		});
	}
	
	
}
