package edu.cscc.module3.package1;

/**
 * @author Jeff Anderson
 * @since 2019-08-18
 */
public class PackageOneClass {

  public int globalScopedField;
  int packagePrivateField;

  public int returnHiddenInstanceVariable(int globalScopedField) {
    return globalScopedField;
  }

  public int returnThisInstanceVariable(int globalScopedField) {
    return this.globalScopedField;
  }

}
