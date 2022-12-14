package extractor;

import org.apache.commons.lang3.Range;

import utils.PtbUtils;
import annotation.ISimpAnnotations.MemberCollectionAnnotation;
import annotation.ISimpAnnotations.MemberCollectionCollectionAnnotation;
import annotation.ISimpAnnotations.MemberCollectionMemberAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.trees.Tree;

public class MemberCollectionExtractor extends ISimpExtractor {

  public MemberCollectionExtractor() {
    super(MemberCollectionAnnotation.class);
  }

  @Override
  protected SimplificationConstruct annotate(Tree tree, int index) {

    Range<Integer> memRange = null;
    Range<Integer> clRange = null;
    SimplificationConstruct construct = new SimplificationConstruct(
        new MemberCollectionAnnotation());

    for (Tree child : tree) {
      CoreLabel label = (CoreLabel) child.label();
      // member
      Integer subindex = label.get(MemberCollectionMemberAnnotation.class);
      if (subindex != null && subindex == index) {
        memRange = PtbUtils.getR