
// package test;
//
// import java.util.List;
//
// import org.junit.Test;
//
// import simplifier.Simplification;
// import utils.PtbUtils;
// import adapter.OtherAdapter;
// import detect.Detection;
// import edu.stanford.nlp.trees.Tree;
// import edu.stanford.nlp.trees.Treebank;
// import edu.stanford.nlp.util.Pair;
// import edu.stanford.nlp.util.Triple;
// import extractor.Extraction;
//
// public class SimplificationTest {
//
// @Test
// public void test() {
// Treebank treebank = TreebankReader.readTreebank("testcases/foo1.txt");
//
// for (Tree tree : treebank) {
// OtherAdapter.adapt(tree);
// Detection.detect(tree);
// System.out.println(tree.pennString());
//
// List<Pair<String, List<Triple<String, Integer, Integer>>>> listlist =
// Extraction
// .extract(tree);
//
// StringBuilder sb = new StringBuilder();
// for (Pair<String, List<Triple<String, Integer, Integer>>> p : listlist) {
// sb.append("[name=" + p.first);
// for (Triple<String, Integer, Integer> t : p.second) {
// sb.append(String.format(
// ",name=%s,from=%d,to=%d",
// t.first,
// t.second,
// t.third));