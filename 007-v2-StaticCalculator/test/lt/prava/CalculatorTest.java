package lt.prava;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class CalculatorTest {
	@Test
	public void shouldAddInts() {
		Calculator calc = new Calculator();
		assertEquals(4, calc.add(2.0, 2.0), 0.0);
	}
}
