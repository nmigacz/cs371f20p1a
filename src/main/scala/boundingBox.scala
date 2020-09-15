package edu.luc.cs.laufer.cs372.shapes

object boundingBox {
  def apply(s: Shape): Location = s match {
    case Rectangle(width, height) => Location(0, 0, Rectangle(width, height))
    case Location(x, y, shape) => {
      val b = boundingBox(shape)
      Location(x + b.x, y + b.y, b.shape)
    }
    case Ellipse(width, height) => Location(-width, -height, Rectangle(2*width, 2*height))
    case Group(shapes @_*) => {
      val boundingBoxes = shapes.map(s =>boundingBox(s))
      val minX = boundingBoxes.map(b => b.x).min
      val maxX = boundingBoxes.map(b => b.x + b.shape.asInstanceOf[Rectangle].width).max
      val minY = boundingBoxes.map(b => b.y).min
      val maxY = boundingBoxes.map(b => b.y + b.shape.asInstanceOf[Rectangle].height).max

      Location(minX, minY, Rectangle(maxX - minX, maxY - minY))
    }
  }
}
