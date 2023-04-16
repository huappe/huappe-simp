
// package simplifier;
//
// import java.util.Collections;
//
// import annotation.ISimpAnnotations.AppositionAnnotation;
// import annotation.ISimpAnnotations.AppositionAppositiveAnnotation;
// import annotation.ISimpAnnotations.AppositionRefAnnotation;
// import edu.stanford.nlp.ling.CoreLabel;
// import edu.stanford.nlp.trees.Tree;
//
// class AppositionSimplifier extends ISimpSimplifier {
//
// protected AppositionSimplifier(Tree root) {
// super(AppositionAnnotation.class);
// }
//
// @Override
// protected Tree annotate(Tree tree, int index) {
//
// Tree copiedTree = tree.deepCopy();
// Tree t1 = retainNp(copiedTree, index);
//
// copiedTree = tree.deepCopy();
// Tree t2 = retainCl(copiedTree, index);
//
// // clean this
//
// Tree copiedPar = null;
// Tree copiedNp = null;
// Tree copiedCl = null;
// // remove ref
// Tree copiedTree = tree.deepCopy();
// for (Tree child : copiedTree) {
// CoreLabel label = (CoreLabel) child.label();
// Integer subindex = label.get(AppositionAnnotation.class);
// if (subindex != null && subindex == index) {
// label.set(AppositionAnnotation.class, null);
// copiedPar = child;
// }
// // ref
// subindex = label.get(AppositionRefAnnotation.class);
// if (subindex != null && subindex == index) {
// label.set(AppositionRefAnnotation.class, null);
// copiedNp = child;
// }
// // appositive
// subindex = label.get(AppositionAppositiveAnnotation.class);
// if (subindex != null && subindex == index) {
// label.set(AppositionAppositiveAnnotation.class, null);
// copiedCl = child;
// break;
// }
// }
// if (copiedPar == null) {
// throw new RuntimeException(String.format(
// "can not find APP: %s",
// tree.toString()));
// }
// if (copiedNp == null) {
// throw new RuntimeException(String.format(
// "can not find APPREF: %s",
// tree.toString()));
// }
// if (copiedCl == null) {
// throw new RuntimeException(String.format(
// "can not find APPOSITIVE: %s",
// tree.toString()));
// }
// copiedTree.prune(new TreeFilter(copiedNp));
//
// // remove appositive
// copiedTree = tree.deepCopy();
// for (Tree child : copiedTree) {
// CoreLabel label = (CoreLabel) child.label();
// // ref
// Integer subindex = label.get(AppositionAppositiveAnnotation.class);
// if (subindex != null && subindex == index) {
// label.set(AppositionAppositiveAnnotation.class, null);
// copiedCl = child;
// }
// }
// if (copiedCl == null) {
// throw new RuntimeException(String.format(
// "can not find APPREF: %s",
// tree.toString()));
// }
// copiedTree.prune(new TreeFilter(copiedCl));
//
// // find
// for (Tree child : copiedTree) {
// CoreLabel label = (CoreLabel) child.label();
// Integer subindex = label.get(AppositionAnnotation.class);
// if (subindex != null && subindex == index) {
// label.set(AppositionAnnotation.class, null);
// copiedPar = child;
// }
// // ref
// subindex = label.get(AppositionRefAnnotation.class);
// if (subindex != null && subindex == index) {
// label.set(AppositionRefAnnotation.class, null);
// copiedNp = child;
// }
// // appositive
// subindex = label.get(AppositionAppositiveAnnotation.class);
// if (subindex != null && subindex == index) {
// label.set(AppositionAppositiveAnnotation.class, null);
// copiedCl = child;
// break;
// }
// }
// if (copiedPar == null) {
// throw new RuntimeException(String.format(
// "can not find APP: %s",