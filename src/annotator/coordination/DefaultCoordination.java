package annotator.coordination;

import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.tregex.TregexMatcher;
import edu.stanford.nlp.util.Pair;

public class DefaultCoordination extends Coordination {

  public DefaultCoordination(Tree root, Tree coordination) {
    super(root, coordinatio