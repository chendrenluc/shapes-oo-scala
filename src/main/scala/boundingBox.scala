package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match
    //Rectangle
    case Rectangle(w, h) => 
      Location(0, 0, Rectangle(w, h))
    //Ellipse
    case Ellipse(rx, ry) => 
      Location(-rx, -ry, Rectangle(2 * rx, 2 * ry))
    //Location
    case Location(x, y, inner) => 
      val Location(ix, iy, Rectangle(w, h)) = apply(inner)
      Location(ix + x, iy + y, Rectangle(w, h))
    //Group
    case Group(shapes*) =>
      val boxes = shapes.map(apply)
      val minX = boxes.map(_.x).min
      val minY = boxes.map(_.y).min
      val maxX = boxes.map(b => b.x + b.shape.width).max
      val maxY = boxes.map(b => b.y + b.shape.height).max
      val width = maxX - minX
      val height = maxY - minY
      Location(minX, minY, Rectangle(width, height))

end boundingBox
