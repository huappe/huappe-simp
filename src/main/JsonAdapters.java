package main;

import annotation.ISimpAnnotations.ISimpAnnotation;
import com.google.gson.annotations.SerializedName;
import edu.stanford.nlp.ling.CoreAnnotations.*;
import edu.stanford.nlp.trees.TreeCoreAnnotations.TreeAnnotation;
import edu.stanford.nlp.util.CoreMap;
import extractor.SimplificationConstruct;
import extractor.SimplificationConstruct.Component;

import java.util.ArrayList;
import java.util.List;

public abstract class JsonAdapters {

  public static class SentenceAdapter {

    @SerializedName("TYPE")
    final String type;
    @SerializedName("TEXT")
    final String text;
    @SerializedName("FROM")
    final int begin;
    @SerializedName("TO")
    final int end;
    @SerializedName("POS ")
    final String pos;
    @SerializedName("TREE")
    final String tree;
    @SerializedName("SIMP")
    final List<ConstructAdapter> co