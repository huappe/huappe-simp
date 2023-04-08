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
        isPrettyPrinting = false;
      }

      PlainBuilder setPrettyPrinting() {
        isPrettyPrinting = true;
        return this;
      }

      Plain create() {
        return new Plain(this);
      }
    }

    class Plain {

      private final PlainBuilder builder;
      private final int width = 80;

      Plain(PlainBuilder builder) {
        this.builder = builder;
      }

      String toPlain(SentenceAdapter adapter) {
        StringBuilder sb = new StringBuilder();
        String line;

        sb.append("TYPE: ").append(adapter.type);
        // loc
        sb.append(loc(adapter.begin, adapter.end)).append('\n');
        // text
        line = "TEXT: " + adapter.text;
        if (builder.isPrettyPrinting) {
          line = autoformat(line, 6);
        }
        sb.append(line).append('\n');
        // pos
        line = "POS : " + adapter.pos;
        if (builder