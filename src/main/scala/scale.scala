package edu.luc.cs.laufer.cs372.shapes

object scale {
  def apply(s: Shape): Int = s match {
    case Rectangle(width, height) => ???
    case Ellipse(width, height) => ???
    case Location(x, y, shape) => ???
    case Group(shapes @ _*) => ???
  }
}