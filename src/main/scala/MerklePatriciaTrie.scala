sealed trait MerklePatriciaTrie extends Traversable[String] {

  def append(key : String)
  def findByPrefix(prefix: String): scala.collection.Seq[String]
  def contains(word: String): Boolean
  def remove(word : String) : Boolean

}

private class BranchNode extends MerklePatriciaTrie {


}
