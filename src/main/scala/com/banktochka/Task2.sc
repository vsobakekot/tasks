case class TreeNode[X](value: X, left: Option[TreeNode[X]], right: Option[TreeNode[X]])

def isSameTree[X](p: Option[TreeNode[X]], q: Option[TreeNode[X]]): Boolean = p == q

val simpleP = TreeNode(1, None, None)
val simpleQ = TreeNode(1, None, None)

assert(isSameTree(Some(simpleP), Some(simpleQ)))

val p = TreeNode(1, Some(TreeNode(2, None, None)), None)
val q = TreeNode(1, None, Some(TreeNode(2, None, None)))

assert(!isSameTree(Some(p), Some(q)))
