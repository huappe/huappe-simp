package annotator;

import java.util.List;

import annotation.ISimpAnnotations.FullRelativeClauseAnnotation;
import annotation.ISimpAnnotations.RedRelativeClauseAnnotation;
import annotation.ISimpAnnotations.RelativeClauseAnnotation;
import annotation.ISimpAnnotations.RelativeClauseClauseAnnotation;
import annotation.ISimpAnnotations.RelativeClauseRefAnnotation;
import detect.DetectionPattern;
import detect.DetectionTregexReader;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.tregex.TregexMatcher;

public class RelativeClauseAnnotator extends ISimpAnnotator {

  @Override
  public void annotate(Tree root)