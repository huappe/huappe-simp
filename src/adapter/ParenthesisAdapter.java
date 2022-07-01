
package adapter;

import annotator.ISimpAnnotator;
import edu.stanford.nlp.trees.LabeledScoredTreeFactory;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.tregex.TregexMatcher;
import edu.stanford.nlp.trees.tregex.TregexPattern;

public class ParenthesisAdapter extends ISimpAnnotator {

  // if LRB and RRB contains several elements
  static TregexPattern pattern1 = TregexPattern
                                    .compile("-LRB-=lrb $++ -RRB-=rrb !$+ (__ $+ =rrb)");

  // if ref contains several elements
  static TregexPattern pattern2 = TregexPattern
                                    .compile("PRN=prn !>2 __ $- NN|NNS|CD=nn");

  @Override
  protected void annotate(Tree tree) {