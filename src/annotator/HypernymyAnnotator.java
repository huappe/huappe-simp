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

  @Override
  public void annotate(Tree root) {
    int index = 0;

    List<DetectionPattern> list = DetectionTregexReader
        .getTregex(DetectionTregexReader.Hypernymy);

    for (DetectionPattern p : list) {
      TregexMatcher m = p.getTregexPattern().matcher(root);
      while (m.find()) {
        Tree matched = m.getMatch();

        CoreLabel label = (CoreLabel) matched.label();
        if (label.get(HypernymyAnnotation.cla