package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import Shape.*

class ConstructorValidation extends AnyFunSuite:

  test("circle rejects negative radius"):
    assertThrows[IllegalArgumentException]:
      Ellipse(-1, -1)

  test("rectangle rejects negative width"):
    assertThrows[IllegalArgumentException]:
      Rectangle(-5, 10)

  test("rectangle rejects negative height"):
    assertThrows[IllegalArgumentException]:
      Rectangle(5, -10)

  test("scale rejects negative factor"):
    assertThrows[IllegalArgumentException]:
      scale(Ellipse(1, 1), -2)

  test("group rejects null list"):
    assertThrows[IllegalArgumentException] {
      Group()
    }

end ConstructorValidation
