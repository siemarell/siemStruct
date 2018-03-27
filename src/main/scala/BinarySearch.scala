import scala.annotation.tailrec

object BinarySearch {
  def search[T](a: Array[T], item: T)(implicit ev$1: T => Ordered[T]): Option[Int] = {

    @tailrec
    def loop(start: Int, end: Int): Option[Int] = (start + end) >>> 1 match {
      case _ if start > end => None
      case mid if a(mid) > item => loop(start, mid - 1)
      case mid if a(mid) < item => loop(mid + 1, end)
      case mid => Some(mid)
    }
    loop(0, a.length - 1)
  }

}
