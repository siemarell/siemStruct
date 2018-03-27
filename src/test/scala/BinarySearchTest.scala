import org.scalacheck.{Gen, Properties}
import org.scalatest.{Matchers, PropSpec}
import org.scalatest.prop.{GeneratorDrivenPropertyChecks, PropertyChecks}


class BinarySearchTest extends PropSpec
  with PropertyChecks
  with GeneratorDrivenPropertyChecks
  with Matchers {

  val genInt: Gen[Int] = Gen.choose(Int.MinValue, Int.MaxValue)
  val genSortedIntArray: Gen[Array[Int]] = Gen.containerOf[Array, Int](genInt).map(_.distinct.sorted)
  val genSortedStringArray: Gen[Array[String]] = Gen.containerOf[Array, String](Gen.alphaStr).map(_.distinct.sorted)

  property("Should correctly find integers"){
    forAll(genSortedIntArray){ arr =>
      //val arr = arr1.distinct
      if (arr.length == 0) assert(BinarySearch.search(arr, 1).isEmpty)
      else {
        val randIndex = Gen.choose(0, arr.length - 1).sample.get
        val randNum = genInt.filter(!arr.contains(_)).sample.get
        assert(BinarySearch.search(arr, randNum).isEmpty)
        assert(BinarySearch.search(arr, arr(randIndex)).contains(randIndex))
      }
    }
  }

  property("Should correctly find strings"){
    forAll(genSortedStringArray){ arr =>
      if (arr.length == 0) assert(BinarySearch.search(arr, "").isEmpty)
      else {
        val randIndex = Gen.choose(0, arr.length - 1).sample.get
        val randStr = Gen.alphaStr.filter(!arr.contains(_)).sample.get
        assert(BinarySearch.search(arr,randStr).isEmpty)
        assert(BinarySearch.search(arr, arr(randIndex)).contains(randIndex))
      }
    }
  }
}
