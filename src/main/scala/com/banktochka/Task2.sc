import scala.annotation.tailrec
import scala.collection.immutable.Queue

case class TreeNode[X](value: X, left: Option[TreeNode[X]], right: Option[TreeNode[X]])

type MaybeTreeNode[X] = Option[TreeNode[X]]

//  it works because case class and option equal methods are defined by default
//def isSameTree[X](p: Option[TreeNode[X]], q: Option[TreeNode[X]]): Boolean = p == q

//  recursion alternative but not stack safe
//def isSameTree[X](p: Option[TreeNode[X]], q: Option[TreeNode[X]]): Boolean =
//  (p, q) match {
//    case (Some(TreeNode(pv, pl, pr)), Some(TreeNode(qv, ql, qr))) =>
//      pv == qv && isSameTree(pl, ql) && isSameTree(pr, qr)
//    case (None, None) =>
//      true
//    case _ =>
//      false
//  }

// another recursion alternative with tailrec toList and comparison (inspired by rockthejvm course)
def isSameTree[X](p: Option[TreeNode[X]], q: Option[TreeNode[X]]): Boolean = {
  def toList(mb: MaybeTreeNode[X]): List[MaybeTreeNode[X]] = {
    @tailrec
    def observeTree(
      level: List[MaybeTreeNode[X]],
      finalQueue: Queue[MaybeTreeNode[X]] = Queue()
    ): List[MaybeTreeNode[X]] =
      level match {
        case Nil => finalQueue.toList
        case x :: xs =>
          x match {
            case Some(t) => observeTree(List(t.left, t.right), finalQueue.enqueue(Some(t)))
            case None    => observeTree(xs, finalQueue)
          }
      }

    observeTree(List(mb))
  }

  toList(p) == toList(q)
}

val simpleP = TreeNode(1, None, None)
val simpleQ = TreeNode(1, None, None)

assert(isSameTree(Some(simpleP), Some(simpleQ)))

val p = TreeNode(1, Some(TreeNode(2, None, None)), None)
val q = TreeNode(1, None, Some(TreeNode(2, None, None)))

assert(!isSameTree(Some(p), Some(q)))
