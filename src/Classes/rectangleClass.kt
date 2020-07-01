package Classes

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

    fun calculateInstersectArea (rec2: Rectangle):Int {
        
        return 0
    }
}

