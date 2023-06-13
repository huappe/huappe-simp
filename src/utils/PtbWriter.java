package utils;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.trees.Tree;

public class PtbWriter {

  public static final LabelWriter DEFAULT = new LabelWriter() {

                                            @Override
                                            public String labelString(Tree t) {
                                              return t.label().toString();
                                            }
                                          };

  public static final LabelWriter FULL    = new DetailedLabelWriter();

  public static String print(Tree t, LabelWriter labelPrinter) {
    return printHelper(new StringBuilder(), t, labelPrinter).toString();
  }

  private static StringBuilder printHelper(StringBuilder sb, Tree t,
    