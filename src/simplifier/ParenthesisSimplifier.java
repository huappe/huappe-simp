// package simplifier;
//
// import utils.PtbUtils;
// import annotation.ISimpAnnotations.ParenthesisAnnotation;
// import annotation.ISimpAnnotations.ParenthesisElemAnnotation;
// import annotation.ISimpAnnotations.ParenthesisRefAnnotation;
// import edu.stanford.nlp.ling.CoreLabel;
// import edu.stanford.nlp.trees.Tree;
// import edu.stanford.nlp.trees.tregex.TregexMatcher;
//
// class ParenthesisSimplifier extends ISimpSimplifier {
//
// protected ParenthesisSimplifier() {
// super(ParenthesisAnnotation.class);
// }
//
// @Override
// protected Tree annotate(Tree tree, int index) {
//
// Tree copiedTree = t