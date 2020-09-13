package edu.luc.cs.laufer.cs372.shapes

// TODO: implement this behavior

object boundingBox {
  def apply(s: Shape): Location = s match {
    case Rectangle(width, height) => Location(0, 0, Rectangle(width, height))
    case Location(x, y, shape) => Location(x, y, shape)
    case Ellipse(width, height) => Location(-width, -height, Rectangle(2*width, 2*height))
    case Group(shapes @_*) => {
      val boundingBoxes = shapes.map(s =>boundingBox(s))
      val minX = boundingBoxes.map(b => b.x).min
      val maxX = boundingBoxes.map(b => b.x + b.shape.asInstanceOf[Rectangle].width).max
      val minY = boundingBoxes.map(b => b.y).min
      val maxY = boundingBoxes.map(b => b.y + b.shape.asInstanceOf[Rectangle].height).max
      //val width1 = boundingBoxes.foldLeft(0)((a,b) => a.x + a.shape.asInstanceOf[Rectangle].width.max, b.x + b.shape.asInstanceOf[Rectangle].width.max)
      val width = maxX - minX
      val height = maxY-minY
      Location(minX, minY, Rectangle(width, height))
    }
    case _ => Location(0, 0, Rectangle(0, 0)) // not yet implemented
  }
}
