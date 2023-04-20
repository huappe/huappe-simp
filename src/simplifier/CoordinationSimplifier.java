// package simplifier;
//
// import java.util.Iterator;
//
// import utils.PtbUtils;
// import edu.stanford.nlp.trees.Tree;
// import edu.stanford.nlp.trees.tregex.TregexMatcher;
//
// class CoordinationSimplifier extends ISimpSimplifier {
//
// protected CoordinationSimplifier() {
// super(root);
// }
//
// @Override
// public boolean find() {
// for (Tree child : root.preOrderNodeList()) {
// int index = PtbUtils.getSimpIndex(child.value(), "-COO");
// if (index != -1) {
// simplify(child, index);
// return true;
// }
// }
// return false;
// }
//
// protected void simplify(Tree par, int index) {
//
// // change value
// par.setValue(par.value() + "-###");
// // simplify
// Iterator<Tree> itr = par.iterator();
// while (itr.hasNext()) {
// Tree child = itr.next();
// int subindex = PtbUtils.getSimpIndex(child.value(), "-CONJ");
// if (subindex != -1 && subindex == index) {
// // change value
// child.setValue(child.value() + "-@@@");
// // copy
// Tree copied = root.deepCopy();
// TregexMatcher m = tregex.matcher(copied);
// boolean found = m.find();
// if (!found) {
// throw new IllegalArgumentException("no matching found:" + copied);
// }
// // restore child in copied
//