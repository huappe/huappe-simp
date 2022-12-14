package extractor;

import org.apache.commons.lang3.Range;

import utils.PtbUtils;
import annotation.ISimpAnnotations.FullRelativeClauseAnnotation;
import annotation.ISimpAnnotations.RedRelativeClauseAnnotation;
import annotation.ISimpAnnotations.RelativeClauseAnnotation;
import annotation.ISimpAnnotations.RelativeClauseClauseAnnotation;
import annotation.ISimpAnnotations.RelativeClauseRefAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.TypesafeMap.Key;

public class RelativeClauseExtractor extends IS