//package annotator;
//
//import java.util.List;
//import java.util.Properties;
//
//import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
//import edu.stanford.nlp.pipeline.Annotation;
//import edu.stanford.nlp.pipeline.Annotator;
//import edu.stanford.nlp.pipeline.StanfordCoreNLP;
//import edu.stanford.nlp.trees.MemoryTreebank;
//import edu.stanford.nlp.trees.Tree;
//import edu.stanford.nlp.trees.TreeCoreAnnotations.TreeAnnotation;
//import edu.stanford.nlp.trees.Treebank;
//import edu.stanford.nlp.util.CoreMap;
//
//public class CopyOfISimpParser extends StanfordCoreNLP {
//
//  public static final Properties DEFAULT_PROPS = new Properties();
//  // public static final Properties PROPS_WITHOUT_TOKENZIE = new Properties();
//
//  static {
//    // creates a