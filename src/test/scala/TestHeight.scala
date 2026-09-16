package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*
import height.*

class TestHeight extends AnyFunSuite{
  test("Simple Rectangle") {
    assert(apply(simpleRectangle) == 1)
  }
  test("Simple Ellipse") {
    assert(apply(simpleEllipse) == 1)
  }
  test("Simple Location") {
    assert(apply(simpleLocation) == 2)
  }
  test("Basic Group") {
    assert(apply(basicGroup) == 2)
  }
  test("Simple Group") {
    assert(apply(simpleGroup) == 3)
  }
  test("Complex Group") {
    assert(apply(complexGroup) == 6)
  }
}
end TestHeight
