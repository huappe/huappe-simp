
package annotator.coordination;

import java.util.regex.Pattern;

import utils.PtbUtils;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.tregex.TregexMatcher;
import edu.stanford.nlp.util.Pair;

public class IsomorphicCoordination extends Coordination {

  private static final Pattern vbPattern = Pattern
                                             .compile("VBZ|VBG|VBN|VBD|VBP");
  private static final Pattern sPattern  = Pattern.compile("S|SBAR");

  public IsomorphicCoordination(Tree root, Tree coordination) {
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
          conjuncts.add(new Pair<Integer, Tree>(i, child));
          state = 2;
        }
        break;
      case 1:
        conjuncts.add(new Pair<Integer, Tree>(i, child));
        state = 2;
        break;
      case 2:
        if (isCC(child)) {
          conjunction = child;
          state = 4;
        } else if (isComma(child)) {
          state = 3;
        } else {
          return false;
        }
        break;
      case 3:
        if (isCC(child) && i != parent.numChildren() - 1) {
          conjunction = child;
          state = 4;
        } else {
          conjuncts.add(new Pair<Integer, Tree>(i, child));
          state = 2;
        }
        break;
      case 4:
        if (child.value().equals("ADVP")
            && !conjuncts.get(0).second.value().equals("ADVP")) {
          ;
        } else if (child.value().equals("RB")
            && !conjuncts.get(0).second.value().equals("RB")) {
          ;
        } else {
          hasCC = true;
          conjuncts.add(new Pair<Integer, Tree>(i, child));
          state = 5;
        }
        break;
      default:
        if (isComma(child)) {

        } else {
          hasCC = false;
        }
      }
    }
    if (!hasCC) {
      return false;
    }
    // isomorphic
    // only compare the first and last conjuncts
    Tree first = conjuncts.getFirst().second;
    Tree last = conjuncts.getLast().second;
    if (first.numChildren() == 1 && last.numChildren() == 1) {
      if (first.firstChild().isLeaf() && last.firstChild().isLeaf()) {
        return true;
      }
    }
    return isIsomorphic(first, last);
  }

  private boolean isIsomorphic(Tree t1, Tree t2) {
    if (t1.value().equals("NP") && t2.value().equals("NP")) {
      return isIsomorphicNp(t1, t2);
    }
    if (t1.value().equals("PP") && t2.value().equals("PP")) {
      return isIsomorphicPp(t1, t2);
    }
    if (t1.value().equals("VP") && t2.value().equals("VP")) {
      return isIsomorphicVp(t1, t2);
    }
    if (t1.value().equals("ADJP") && t2.value().equals("ADJP")) {
      return isIsomorphicAdjp(t1, t2);
    }
    if (sPattern.matcher(t1.value()).find()
        && sPattern.matcher(t2.value()).find()) {
      return isIsomorphicS(t1, t2);
    }
    return isIsomorphicGeneral(t1, t2);
  }

  private boolean isIsomorphicAdjp(Tree t1, Tree t2) {
    if (t1.numChildren() == 1 && t2.numChildren() == 1) {
      return true;
    }
    if (t1.lastChild().value().equals("JJ")
        && t2.lastChild().value().equals("JJ")) {
      return true;
    }
    if (t1.lastChild().value().equals("VBG")
        && t2.lastChild().value().equals("VBG")) {
      return true;
    }
    return isIsomorphicGeneral(t1, t2);
  }

  private boolean isIsomorphicVp(Tree t1, Tree t2) {
    t1 = RightMostVp.rightMostVp(t1);
    t2 = RightMostVp.rightMostVp(t2);

    if (t2.numChildren() == 1) {
      return true;
    }
    if (t1.numChildren() == 1 && t2.numChildren() == 1) {
      return true;
    }
    if (t1.numChildren() >= 3 && t2.numChildren() >= 3) {
      return true;
    }
    if (t1.lastChild().value().equals("NP")
        && t2.lastChild().value().equals("NP")) {
      return true;
    }
    if (t1.lastChild().value().equals("NP")
        && t2.lastChild().value().equals("S")) {
      return true;