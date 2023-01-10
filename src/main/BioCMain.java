package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import annotation.ISimpAnnotations.ISimpAnnotation;
import bioc.BioCAnnotation;
import bioc.BioCCollection;
import bioc.BioCDocument;
import bioc.BioCLocation;
import bioc.BioCNode;
import bioc.BioCPassage;
import bioc.BioCRelation;
import bioc.BioCSentence;
import bioc.io.BioCCollectionReader;
import bioc.io.BioCCollectionWriter;
import bioc.io.BioCFactory;
import detect.ISimpBuilder;
import edu.stanford.nlp.ling.CoreAnnotations.CharacterOffsetBeginAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.Annotator;
import edu.stanford.nlp.util.CoreMap;
import extractor.SimplificationConstruct;
import extractor.SimplificationConstruct.Component;

public class BioCMain {

  /**
   * @param args
   * @throws XMLStreamException
   * @throws IOException
   */
  public static void main(String[] args)
      throws XMLStreamException, IOException {

    // args = new String[] { "testcases/PMID-8632999.xml" };

    if (args.length == 0) {
      System.err.println("Usage: BioCMain inputfiles");
      return;
    }

    // init
    Annotator isimp = new ISimpBuilder().onlyParser().create();

    for (String arg : args) {

      System.err.print("processing " + arg + "...");
      File inputfile = new File(arg);
  