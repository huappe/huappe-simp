package extractor;

import org.apache.commons.lang3.Range;

import utils.PtbUtils;
import annotation.ISimpAnnotations.AdjpCoordinationAnnotation;
import annotation.ISimpAnnotations.AdvpCoordinationAnnotation;
import annotation.ISimpAnnotations.CoordinationAnnotation;
import annotation.ISimpAnnotations.CoordinationConjunctAnnotation;
import annotation.ISimpAnnotations.CoordinationConjunctionAnnotation;
import annotation.ISimpAnnotations.NpCoordinationAnnotation;
import annotation.ISimpAnnotations.PpCoordinationAnnotation;
import annotation.ISimpAnnotations.SenCoordinationAnnotation;
import annotation.ISimpAnnotations.VpCoordinationAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.TypesafeMap.Key;

public class CoordinationExtractor extends ISimpExtractor {

  public CoordinationExtractor() {
    super(CoordinationAnnotation.class);
  }

  protected Coordina