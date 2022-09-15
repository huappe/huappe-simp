package annotator;

import annotation.ISimpAnnotations.ParenthesisAnnotation;
import annotation.ISimpAnnotations.ParenthesisElemAnnotation;
import annotation.ISimpAnnotations.ParenthesisRefAnnotation;
import detect.DetectionPattern;
import detect.DetectionTregexReader;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.tregex.TregexMatcher;

public class Parenthesis