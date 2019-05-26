package nl.hu.taxcalculator;

import static java.time.LocalDate.of;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class AOWQualifierTest {
	
	private AOWQualifier aowQualifier;
	
	@BeforeEach
	public void beforeEach() {
		aowQualifier = new AOWQualifier(of(2017,1,1));
	}

	@Test
	public void geborenVoor1948KrijgtAOW() {
		LocalDate dateBefore1948 = LocalDate.of(1947, Month.APRIL, 1);
		assertTrue(aowQualifier.doesDateQualify(dateBefore1948));
	}

	@Test
	@Disabled
	public void geborenNa30Juni51EnVoor1April52KrijgtAow() {
		LocalDate dateNeeded = LocalDate.of(1951, Month.AUGUST,1);
		assertTrue(aowQualifier.doesDateQualify(dateNeeded));
	}

	@Test
	public void geborenNa30SeptemberVoor1Juli51KrijgtAow() {
		LocalDate date = LocalDate.of(1950, Month.NOVEMBER,1);
		assertTrue(aowQualifier.doesDateQualify(date));
	}

	@Test
	@Disabled
	public void geborenIn1500KrijgtAOW() {
		LocalDate date = LocalDate.of(1500, Month.JANUARY, 1);
		assertTrue(aowQualifier.doesDateQualify(date));
	}
	@Test
	public void geßborenNa2001KrijgtGeenAow() {
		LocalDate date = LocalDate.of(2002, Month.JANUARY, 1);
		assertFalse(aowQualifier.doesDateQualify(date));
	}

	@Test
	public void emptyDateThrowsNullPointer() {
		assertThrows(NullPointerException.class, () ->
				aowQualifier.doesDateQualify(null));
	}
}
