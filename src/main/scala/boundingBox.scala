package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

import java.util.logging.Logger
import Shape.*

object boundingBox:
  private val log = Logger.getLogger("shapes.boundingBox")
  def apply(s: Shape): Location = s match
    //Rectangle
    case Rectangle(w, h) =>
      log.fine(s"boundingBox(Rectangle($w, $h))")
      Location(0, 0, Rectangle(w, h))
    //Ellipse
    case Ellipse(rx, ry) =>
      log.fine(s"boundingBox(Ellipse($rx, $ry))")
      Location(-rx, -ry, Rectangle(2 * rx, 2 * ry))
    //Location
    case Location(x, y, inner) =>
      log.fine(s"boundingBox(Location($x, $y, ...))")
      val Location(ix, iy, Rectangle(w, h)) = apply(inner)
      Location(ix + x, iy + y, Rectangle(w, h))
    //Group
    case Group(shapes*) =>
      log.fine(s"boundingBox(Group(${shapes.size} shapes))")
      val boxes = shapes.map(apply)
      val minX = boxes.map(_.x).min
      val minY = boxes.map(_.y).min
      val maxX = boxes.map { case Location(x, y, Rectangle(w, _)) => x + w }.max
      val maxY = boxes.map { case Location(x, y, Rectangle(_, h)) => y + h }.max
      val width = maxX - minX
      val height = maxY - minY
      Location(minX, minY, Rectangle(width, height))

end boundingBox
