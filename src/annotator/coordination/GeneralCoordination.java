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
    TregexMatcher m = conjPattern.matcher(coordination);
    if (!m.find()) {
      return false;
    }

    Tree parent = m.getMatch();
    boolean hasCC = false;
    conjuncts.clear();
    int state = 0;
    for (int i = 0; i < parent.numChildren(); i++) {
      Tree child = parent.getChild(i);
      switch (state) {
      case 0:
        if (isCC(child)) {
          conjunction = child;
          state = 1;
        } else if (isComma(child)) {
          return false;
        } else {
          conjuncts.add(new 