package edu.luc.cs.laufer.cs371.shapes

/** data Shape = Rectangle(w, h) | Location(x, y, Shape) */
enum Shape derives CanEqual:

  case Rectangle(width: Int, height: Int)
  case Location(x: Int, y: Int, shape: Shape)
  case Ellipse(rx: Int, ry: Int)
  case Group(shapes: Shape*)

  // Constructor validation
  // ----------------------

  // Rectangle validation
  def validateRectangle(width: Int, height: Int): Unit =
    require(width >= 0, "width must be non-negative")
    require(height >= 0, "height must be non-negative")

  // Location validation
  def validateLocation(shape: Shape): Unit =
    require(shape != null, "location must wrap a non-null shape")

  // Ellipse validation
  def validateEllipse(rx: Int, ry: Int): Unit =
    require(rx >= 0, "rx must be non-negative")
    require(ry >= 0, "ry must be non-negative")

  // Group validation
  def validateGroup(shapes: Seq[Shape]): Unit =
    require(shapes.nonEmpty, "group must contain at least one shape")

  // Run validation automatically for each case
  // ------------------------------------------

  // Pattern‑match on `this` to run the correct validation
  this match
    case Rectangle(w, h)      => validateRectangle(w, h)
    case Location(_, _, s)    => validateLocation(s)
    case Ellipse(rx, ry)      => validateEllipse(rx, ry)
    case Group(shapes*)       => validateGroup(shapes)
