package adapter;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import utils.PatternEnv;
import edu.stanford.nlp.trees.tregex.TregexPattern;
import edu.stanford.nlp.trees.tregex.tsurgeon.Tsurgeon;
import edu.stanford.nlp.trees.tregex.tsurgeon.TsurgeonPattern;

public class AdapterTregexReader implements Closeable {

  private static final List<AdapterPattern> list   = new ArrayList<AdapterPattern>();

  private static boolean                    isRead = false;

  public void isRead() {
    isRead = true;
  }

  public static List<AdapterPattern> getTregex() {
    if (!isRead) {
      read();
    }
    return list;
  }

  private static void read() {
    list.clear();
    try {
      read(
          new FileInputStream(PatternEnv.DIR + PatternEnv.PAR_ADATER_TREGEX),
          new FileInputStream(PatternEnv.DIR + PatternEnv.REL_ADATER_TREGEX),
          new FileInputStream(PatternEnv.DIR + PatternEnv.COO_ADATER_TREGEX),
          new FileInputStream(PatternEnv.DIR + PatternEnv.ADATER_TREGEX));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    isRead = true;
  }

  public static void read(InputStream paradapteris, InputStream reladapteris, InputStream cooadapteris, InputStream adapteris) {
    AdapterTregexReader reader;
    try {
      reader = new AdapterTregexReader(paradapteris);
      list.addAll(reader.readTregex());
      reader.close();
      
      reader = new AdapterTregexReader(reladapteris);
      list.addAll(reader.readTregex());
      reader.close();
      
      reader = new AdapterTregexReader(cooadapteris);
      list.addAll(reader.readTregex());
      reader.close();
      
      reader = new AdapterTregexReader(adapteris);
      list.addAll(reader.readTregex());
      reader.close();
      
      isRead = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  LineNumberReader reader;

  public AdapterTregexReader(InputStream is) {
    this.reader = new LineNumberReader(new InputStreamReader(is));
  }

  public List<AdapterPatte