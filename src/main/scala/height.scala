package edu.luc.cs.laufer.cs372.shapes

object height {
  def apply(s: Shape): Int = s match {
    case Rectangle(width, height) => 1
    case Ellipse(width, height) => 1
    case Location(x, y, shape) => height(shape)
    case Group(shapes @ _*) => shapes.map(apply).max
  }
}
