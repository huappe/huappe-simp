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
  public static String COORDINATION_TREGEX        = "coordination-detect.txt";
  public static String RELATIVE_TREGEX            = "relative clause-detect.txt";
  public static String PARENTHESIS_TREGEX         = "parenthesis-detect.txt";
  public static String APPOSITION_TREGEX          = "apposition-detect.txt";
  public static String MEMEMBER_COLLECTION_TREGEX = "member-collection-detect.txt";
  public static String NPPP_TREGEX                = "nppp.txt";
  public static String SEN