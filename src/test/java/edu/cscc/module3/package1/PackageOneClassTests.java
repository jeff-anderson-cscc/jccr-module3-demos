package edu.cscc.module3.package1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jeff Anderson
 * @since 2019-08-18
 */
public class PackageOneClassTests {

  TestingUtilties testingUtilties = new TestingUtilties();

  @Test
  @DisplayName("T01: PackageOneClass has public globalScopedField field")
  public void test01 () {
    Class packageOneClass = testingUtilties.helperGetClass("edu.cscc.module3.package1.PackageOneClass",
      "No class named edu.cscc.module3.package1.PackageOneClass defined");
    Field field = testingUtilties.getField(packageOneClass, "globalScopedField",
      "PackageOneClass does not have a field named globalScopedField");
    assertNotNull(field);
    assertTrue(Modifier.isPublic(field.getModifiers()), "globalScopedField in PackageOneClass is not public");
  }

  @Test
  @DisplayName("T02: PackageOneClass has public packagePrivateField field")
  public void test02 () {
    Class packageOneClass = testingUtilties.helperGetClass("edu.cscc.module3.package1.PackageOneClass",
      "No class named edu.cscc.module3.package1.PackageOneClass defined");
    Field field = testingUtilties.getField(packageOneClass, "packagePrivateField",
      "PackageOneClass does not have a field named packagePrivateField");
    assertNotNull(field);
    System.out.println(field.getModifiers());
    assertEquals(0,field.getModifiers(), "packagePrivateField in PackageOneClass is not package private");
  }

  @Test
  @DisplayName("T03: returnHiddenInstanceVariable returns globalScopedField argument value passed")
  public void test03 () {
    PackageOneClass packageOneClass = new PackageOneClass();
    packageOneClass.globalScopedField = 5;
    assertEquals(10, packageOneClass.returnHiddenInstanceVariable(10));
  }

  @Test
  @DisplayName("T04: returnThisInstanceVariable returns globalScopedField instance variable value")
  public void test04 () {
    PackageOneClass packageOneClass = new PackageOneClass();
    packageOneClass.globalScopedField = 5;
    assertEquals(5, packageOneClass.returnThisInstanceVariable(10));
  }

}
