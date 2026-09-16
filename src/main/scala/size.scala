package edu.luc.cs.laufer.cs371.shapes

import java.util.logging.Logger
import Shape.*

object size {
  private val log = Logger.getLogger("shapes.size")
  def apply(s: Shape): Int = s match {
    case Rectangle(_, _) =>
      log.fine("size(Rectangle)")
      1
    case Ellipse(_, _)   =>
      log.fine("size(Ellipse)")
      1
    case Location(_, _, inner) =>
      log.fine("size(Location)")
      apply(inner)
    case Group(shapes*) =>
      log.fine(s"size(Group with ${shapes.size} shapes)")
      shapes.map(apply).sum
  }
}
