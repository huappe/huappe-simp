package test;

import java.util.List;

import main.SentencePrinter;
import main.SentencePrinterBuilder;

import org.junit.Before;
import org.junit.Test;

import detect.ISimpBuilder;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.Annotator;
import edu.stanford.nlp.util.CoreMap;

public class JSonTest {

  Annotator isimp;

  @Before
  public void init() {
    isimp = new ISimpBuilder().create();
  }

  @Test
  public void test() {
    Annotation docu