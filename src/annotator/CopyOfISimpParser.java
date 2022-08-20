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
//    // creates a StanfordCoreNLP object, with POS tagging, lemmatization, NER,
//    // parsing, and coreference resolution
//    DEFAULT_PROPS.put("annotators", "tokenize, ssplit, pos, parse");
//    DEFAULT_PROPS.put("tokenize.options", "americanize=false,"
//        + "normalizeCurrency=false,"
//        + "normalizeFractions=false,"
//        // + "normalizeParentheses=false,"
//        // + "normalizeOtherBrackets=false,"
//        // + "asciiQuotes=false,"
//        // + "latexQuotes=false,"
//        + "untokenizable=allKeep,"
//        + "ptb3Dashes=false,"
//        + "escapeForwardSlashAsterisk=false,"
//        + "ssplit.eolonly=true");
//    // creates a StanfordCoreNLP object, with POS tagging, lemmatization, NER,
//    // parsing, and coreference resolution
//    // PROPS_WITHOUT_TOKENZIE.put("annotators",
//    // "tokenize, ssplit, pos, parse");
//    // PROPS_WITHOUT_TOKENZIE.put("tokenized", "true");
//  }
//
//  public CopyOfISimpPa