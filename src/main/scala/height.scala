package edu.luc.cs.laufer.cs371.shapes

import java.util.logging.Logger
import Shape.*

object height {
  private val log = Logger.getLogger("shapes.height")
  def apply(s: Shape): Int = s match {
    case Rectangle(_, _) =>
      log.fine("height(Rectangle)")
      1
    case Ellipse(_, _)   =>
      log.fine("height(Ellipse)")
      1
    case Location(_, _, inner) =>
      log.fine("height(Location)")
      1 + apply(inner)
    case Group(shapes*) =>
      log.fine(s"height(Group with ${shapes.size} shapes")
      1 + shapes.map(apply).max
  }
}
