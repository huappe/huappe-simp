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
    public Class<List<Tree>> getType() {
      return ErasureUtils.uncheckedCast(List.class);
    }

  }

  public static interface SimplificationAnnotation extends
      CoreAnnotation<Integer> {

    public String name();

    public String simpleName();
  }

  public static class ParenthesisAnnotation implements SimplificationAnnotation {

    @Override
    public Class<Integer> getType() {
      return Integer.class;
    }

    @Override
    public String name() {
      return "parenthesis";
    }

    @Override
    public String simpleName() {
      return "BRAC";
    }
  }

  public static class ParenthesisRefAnnotation implements
      SimplificationAnnotation {

    @Override
    public Class<Integer> getType() {
      return Integer.class;
    }

    @Override
    public String name() {
      return "referred noun phrase";
    }

    @Override
    public String simpleName() {
   