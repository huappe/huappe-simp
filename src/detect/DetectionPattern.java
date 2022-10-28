package detect;

import edu.stanford.nlp.trees.tregex.TregexPattern;

public class DetectionPattern {

  private final TregexPattern   tregexPattern;

  public DetectionPattern(
      TregexPattern tregexPattern) {
    this.tregexPattern = tregexPattern;
  }

  public final Treg