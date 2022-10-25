package annotator.coordination;

import java.util.List;

import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.tregex.TregexMatcher;
import edu.stanford.nlp.trees.tregex.TregexPattern;

public class RightMostVp {

  private static TregexPattern p1 = TregexPattern
                                      .compile("VP=p <1 @/VB.*/ <2 (S=s <: VP=vp) <- =s");
  private static TregexPattern p2 = TregexPattern
                                      .compile("ADJP=p <1 @/JJ/ <2 (S=s <: VP=vp) <- =s");

  public sta