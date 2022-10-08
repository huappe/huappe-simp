package annotator.coordination;

import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.tregex.TregexMatcher;
import edu.stanford.nlp.util.Pair;

public class GeneralCoordination extends Coordination {

  public GeneralCoordination(Tree root, Tree coordination) {
    super(root, coordination);
  }

  @Override
  public boolean isCoordination() {
    TregexMatcher m = conjPattern.match