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

  public static final LabelWriter FULL    = new DetailedLabel