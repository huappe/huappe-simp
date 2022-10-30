package detect;

public class ISimpBuilder {

  boolean isTokenized;
  boolean onlyParser;

  public ISimpBuilder() {
    isTokenized = false;
    onlyParser = false;
  }

  /**
   * if set , separates word