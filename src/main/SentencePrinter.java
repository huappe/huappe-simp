package main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.util.StringUtils;
import main.JsonAdapters.ComponentAdapter;
import main.JsonAdapters.ConstructAdapter;
import main.JsonAdapters.SentenceAdapter;

public abstract class SentencePrinter {

  