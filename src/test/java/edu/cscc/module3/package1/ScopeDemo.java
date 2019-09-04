package edu.cscc.module3.package1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ScopeDemo {

  public int variableOne = 1;     // visible globally as edu.cscc.module3.package1.ScopeDemo.variableOne
  int variableTwo = 2;            // Visible to all classes in this package as ScopeDemo.variableTwo
  private int variableThree = 3;  // Only visible inside this class as this.variableThree

  @Test
  @DisplayName("Scope Demo Test")
  public void scopeDemoTest () {
    testMethodBlockScope(10);
    assertEquals(1, this.variableOne);  // Make sure instance variables were not changed in method call
    assertEquals(2, variableTwo);
    assertEquals(3, variableThree);
  }

  private void testMethodBlockScope (int variableOne)  {
    assertEquals(10, variableOne);      // outer scope variable of same name hidden by method parameter
    assertEquals(1, this.variableOne);  // this keyword accesses instance variable scope
  }

}
