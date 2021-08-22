class DrumKitTestDrive {

    public static void main(String[] args) {
        DrumKit d = new DrumKit();
        
        d.snare = false;
        
        if (d.snare == true) {
            d.playSnare();
        }
        
        d.playSnare();
        d.playTopHat();   
    } 
}

class DrumKit {

    boolean topHat = true;
    boolean snare = true;
    
    void playSnare() {
        System.out.println("бах бах ба-бах");
    }
    
    void playTopHat() {
        System.out.println("динь динь ди-динь");
    }
}
