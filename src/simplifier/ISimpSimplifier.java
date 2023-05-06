
package simplifier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import annotation.ISimpAnnotations.ISimpSimplifiedAnnotation;
import annotator.ISimpAnnotator;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.Annotator;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations.TreeAnnotation;
import edu.stanford.nlp.trees.tregex.TregexPattern;
import edu.stanford.nlp.trees.tregex.tsurgeon.Tsurgeon;
import edu.stanford.nlp.trees.tregex.tsurgeon.TsurgeonPattern;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.util.Filter;
import edu.stanford.nlp.util.TypesafeMap.Key;

public abstract class ISimpSimplifier implements Annotator {

  public static final Requirement         ISMP_SIMPLIFIED = new Requirement(
                                                              "isimp simplified tree");

  protected Class<? extends Key<Integer>> annotationKey;

  protected ISimpSimplifier(Class<? extends Key<Integer>> annotationKey) {
    this.annotationKey = annotationKey;
  }

  @Override
  public Set<Requirement> requirementsSatisfied() {
    return Collections.singleton(ISMP_SIMPLIFIED);
  }

  @Override
  public Set<Requirement> requires() {
    Set<Requirement> set = new TreeSet<Requirement>();
    set.addAll(TOKENIZE_SSPLIT_PARSE);
    set.add(ISimpAnnotator.ISMP_TREE);
    return set;