package annotator;

import java.util.List;

import annotation.ISimpAnnotations.HypernymyAnnotation;
import annotation.ISimpAnnotations.HypernymyHypernymAnnotation;
import annotation.ISimpAnnotations.HypernymyHyponymAnnotation;
import detect.DetectionPattern;
import detect.DetectionTregexReader;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.tregex.TregexMatcher;

public class HypernymyAnnotator extends ISimpAnnotator {

  @Overri