package annotation;

import java.util.List;

import edu.stanford.nlp.ling.CoreAnnotation;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.ErasureUtils;
import extractor.SimplificationConstruct;

public class ISimpAnnotations {

  public static class ISimpAnnotation implements
      CoreAnnotation<List<SimplificationConstruct>> {

    @Override
    public Class<List<SimplificationConstruct>> getType() {
      return ErasureUtils.uncheckedCast(List.class);
    }

  }

  public static class ISimpSimplifiedAnnotation implements
      CoreAnnotation<List<Tree>> {

    @Override
    p