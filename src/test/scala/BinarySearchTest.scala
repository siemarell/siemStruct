import org.scalacheck.{Gen, Properties}
import org.scalatest.{Matchers, PropSpec}
import org.scalatest.prop.{GeneratorDrivenPropertyChecks, PropertyChecks}

class BinarySearchTest extends PropSpec
  with PropertyChecks
  with GeneratorDrivenPropertyChecks
  with Matchers {

  property("Should correctly find integers"){
    forAll(Gen.containerOf[Array, Int](Gen[Int]), Gen.Choose(1,100)){ arr =>
      val sortedArr = arr.sorted

    }
  }
}
