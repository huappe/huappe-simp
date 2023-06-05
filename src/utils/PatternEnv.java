package utils;

public class PatternEnv {

  public static String DIR;

  static {
    String path = PatternEnv.class.getProtectionDomain().getCodeSource()
        .getLocation().getPath();
    System.out.println(PatternEnv.class.getName() + " is loaded from " + path);
    DIR = path + "../rules/";
  }

  // simplification
  public static Strin