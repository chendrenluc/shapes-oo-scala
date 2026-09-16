package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*
import scale.*
import boundingBox.*
import Shape.*

class TestScale extends AnyFunSuite {
  test("Scale Rectangle") {
    val s = scale(simpleRectangle, 2)
    val Location(x, y, Rectangle(w, h)) = boundingBox(s)
    assert(w == 160)
    assert(h == 240)
  }
  test("Scale Ellipse") {
    val s = scale(simpleEllipse, 3)
    val Location(x, y, Rectangle(w, h)) = boundingBox(s)
    assert(w == 300)
    assert(h == 180)
  }
  test("Scale Location") {
    val s = scale(simpleLocation, 2)
    val Location(x, y, Rectangle(w, h)) = boundingBox(s)
    assert(x == 140)
    assert(y == 60)
    assert(w == 160)
    assert(h == 240)
  }
  test("Scale Group") {
    val s = scale(simpleGroup, 2)
    val Location(x, y, Rectangle(w, h)) = boundingBox(s)
    assert(w == 700)
    assert(h == 560)
  }
}
end TestScale