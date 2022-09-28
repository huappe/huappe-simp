package annotator.coordination;

import java.util.LinkedList;

import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.tregex.TregexPattern;
import edu.stanford.nlp.util.Pair;

public abstract class Coordination {

  protected static final TregexPattern   conjPattern = TregexPattern
                                                         .compile("__ < CC|CONJP");
  public LinkedList<Pair<Integer, Tree>> conjuncts;
  public Tree                            conjunction;
  public 