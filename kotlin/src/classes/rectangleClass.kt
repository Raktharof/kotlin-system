package classes

class Rectangle(a1:Int, a2:Int, b1:Int, b2:Int){
    val x1 = a1;
    val x2 = a2;
    val y1 = b1;
    val y2 = b2;
    
    fun intersects(rec2:Rectangle):Boolean {
        var xCheck = false;
        var yCheck = false;

        if((x1 <= rec2.x1 || x1 <= rec2.x2) &&
            (x2 >= rec2.x1 || x2 >= rec2.x2)) {
            xCheck = true;
        }

        if((y1 <= rec2.y1 || y1 <= rec2.y2) &&
            (y2 >= rec2.y1 || y2 >= rec2.y2)) {
            yCheck = true;
        }

        return (xCheck && yCheck);
    }

    fun calculateIntersectArea (rec2: Rectangle):Int {
        val check = this.intersects(rec2)
        var intersectedArea = 0

        if (check) {

            var intersectedX1 = if (this.x1 > rec2.x1) { this.x1 } else { rec2.x1 }
            var intersectedX2 = if (this.x2 < rec2.x2) { this.x2 } else { rec2.x2 }
            var intersectedY1 = if (this.y1 > rec2.y1) { this.y1 } else { rec2.y1 }
            var intersectedY2 = if (this.y2 < rec2.y2) { this.y2 } else { rec2.y2 }

            intersectedArea = (intersectedX2 - intersectedX1 + 1) * (intersectedY2 - intersectedY1 + 1)
        }
        return intersectedArea
    }
}

