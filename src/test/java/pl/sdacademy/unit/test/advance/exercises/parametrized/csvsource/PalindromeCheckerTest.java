package pl.sdacademy.unit.test.advance.exercises.parametrized.csvsource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import pl.sdacademy.unit.test.advance.examples.parametrized.StringsHelper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckerTest {

    // kajak, kobyłama mały bok
    // java sda

    @ParameterizedTest
    @CsvSource({"kajak, true",
            "kobyła ma mały bok, true",
            "java, false",
            "sda, false"})
    void shouldVerififyIfInputIsPalindrome(String input, boolean expectedResult) {
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertThat(result).isEqualTo(expectedResult); //AssertJ
        assertEquals(expectedResult, result); //JUnit5
    }

    @ParameterizedTest
    @CsvFileSource(
            resources = "/palindrome.csv"
    )
    void shouldVerififyIfInputFromCsvFileIsPalindrome(String input, boolean expectedResult) {
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertThat(result).isEqualTo(expectedResult); //AssertJ
        assertEquals(expectedResult, result); //JUnit5
    }

}