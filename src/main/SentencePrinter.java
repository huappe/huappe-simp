package main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.util.StringUtils;
import main.JsonAdapters.ComponentAdapter;
import main.JsonAdapters.ConstructAdapter;
import main.JsonAdapters.SentenceAdapter;

public abstract class SentencePrinter {

  boolean isPrettyPrinting;

  private SentencePrinter(boolean isPrettyPrinting) {
    this.isPrettyPrinting = isPrettyPrinting;
  }

  public abstract String get(CoreMap sentence);


  protected static class JsonPrinter extends SentencePrinter {

    JsonPrinter(boolean isPrettyPrinting) {
      super(isPrettyPrinting);
    }

    private static Gson gson = null;

    @Override
    public String get(CoreMap sentence) {
      if (gson == null) {
        GsonBuilder builder = new GsonBuilder();
        if (isPrettyPrinting) {
          builder.setPrettyPrinting();
        }
        gson = builder.create();
      }
      return gson.toJson(new SentenceAdapter(sentence));
    }

  }

  protected static class PlainPrinter extends SentencePrinter {

    PlainPrinter(boolean isPrettyPrinting) {
      super(isPrettyPrinting);
    }

    private static Plain plain = null;

    @Override
    public String get(CoreMap sentence) {
      if (plain == null) {
        PlainBuilder builder = new PlainBuilder();
        if (isPrettyPrinting) {
          builder = builder.setPrettyPrinting();
        }
        plain = builder.create();
      }
      return plain.toPlain(new SentenceAdapter(sentence));
    }

    private class PlainBuilder {

      private boolean isPrettyPrinting;

      PlainBuilder() {
        isPrett