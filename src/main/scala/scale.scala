package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object scale {
  def apply(s: Shape, factor: Int): Shape = s match {
    case Rectangle(w, h) =>
      Rectangle(w * factor, h * factor)
    case Ellipse(rx, ry) =>
      Ellipse(rx * factor, ry * factor)
    case Location(x, y, inner) =>
      Location(x * factor, y * factor, apply(inner, factor))
    case Group(shapes*) =>
      Group(shapes.map(apply(_, factor))*)
  }
}
