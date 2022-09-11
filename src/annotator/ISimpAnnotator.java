package annotator;

import java.util.Collections;
import java.util.Set;

import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.Annotator;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations.TreeAnnotation;
import edu.stanford.nlp.util.CoreMap;

public abstract class ISimpAnnotator implements Annotator {

  public static final Requirement ISMP_TREE = new Requirement(
                                                "isimp tree annotation");

  @Override
  public Set<Requirement> requirementsSatisfied() {
 