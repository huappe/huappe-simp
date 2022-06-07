package adapter;

import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.tregex.TregexMatcher;
import edu.stanford.nlp.trees.tregex.TregexPattern;
import edu.stanford.nlp.trees.tregex.tsurgeon.TsurgeonPattern;

public class AdapterPattern {

  private final TregexPattern   tregexPattern;
  private final TsurgeonPattern tsurgeonPattern;

  public AdapterPattern(
      TregexPattern tregexPattern,
      TsurgeonPattern tsurgeonPattern) {
    this.tregexPattern = tregexPattern;
    this.tsurgeonPattern = tsurgeonPattern;
  }

  public final boolean evaluate(Tree tree) {
    boolean matched = false;
    TregexMatcher m = tregexPattern.matcher(tree);
 