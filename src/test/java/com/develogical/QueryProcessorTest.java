package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

  QueryProcessor queryProcessor = new QueryProcessor();

  @Test
  public void knowsWhoWroteRomeoAndJuliet() throws Exception {
    assertThat(queryProcessor.process("Who wrote Romeo And Juliet"), containsString("Shakespeare"));
  }

  @Test
  public void isNotCaseSensitive() throws Exception {
    assertThat(queryProcessor.process("who wrote romeo and juliet"), containsString("Shakespeare"));
  }

  @Test
  public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
    assertThat(queryProcessor.process("test"), is(""));
  }
  @Test
  public void returnsMaxNumber() throws Exception {
    assertThat(queryProcessor.process("gkjsawhich of the following numbers is the largest:12,13,14,15,16,45"), is("45"));
  }
  
  @Test
  public void returnsPrimeNumbers() throws Exception {
    assertThat(queryProcessor.process("gkjsawhich of the following numbers are primes: 526, 211, 4, 890,13"), is("211,13"));
  }
  
  @Test
  public void returnsPrimeNumbersNonPrime() throws Exception {
    assertThat(queryProcessor.process("gkjsawhich of the following numbers are primes: 10, 20, 30, 40"), is(""));
  }
  
  @Test
  public void returnsToThePowerOf() throws Exception {
    assertThat(queryProcessor.process("gkjsawhat is 3 to the power of 4"), is("81"));
  }
  
}
