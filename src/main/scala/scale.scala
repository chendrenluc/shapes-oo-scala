package edu.luc.cs.laufer.cs371.shapes

import java.util.logging.Logger
import Shape.*

object scale {
  private val log = Logger.getLogger("shapes.scale")
  def apply(s: Shape, factor: Int): Shape = s match {
    case Rectangle(w, h) =>
      log.fine(s"scale(Rectangle($w, $h), $factor)")
      Rectangle(w * factor, h * factor)
    case Ellipse(rx, ry) =>
      log.fine(s"scale(Ellipse($rx, $ry), $factor)")
      Ellipse(rx * factor, ry * factor)
    case Location(x, y, inner) =>
      log.fine(s"scale(Location($x, $y, ...), $factor)")
      Location(x * factor, y * factor, apply(inner, factor))
    case Group(shapes*) =>
      log.fine(s"scale(Group with ${shapes.size} shapes, $factor)")
      Group(shapes.map(apply(_, factor))*)
  }
}
