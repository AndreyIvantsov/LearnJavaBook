package ch08;
interface Nose {
    public int Method();
}

abstract class Picasso implements Nose {

    public int Method() {
        return 7;
    }
}

class Clowns extends Picasso {   
}

class Acts extends Picasso {

    public int Method() {
        return 5;
    }
}

public class Of76 extends Clowns {

    public static void main(String[] args) {
        Nose[] i = new Nose[3];
        i[0] = new Acts();
        i[1] = new Clowns();
        i[2] = new Of76();
        
        for (int x = 0; x < 3; x++) {
            System.out.println(i[x].Method() + " " + i[x].getClass());
        }
    }
}
