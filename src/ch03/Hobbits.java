package ch03;
class Hobbits {

    String name;
    
    public static void main(String[] args) {
        Hobbits[] h = new Hobbits[3];
        int z = 0;
        
        // Что исключить ошибку ArrayIndexOutOfBoundsException
        // Уменьшим цикл на один шаг
        //while (z < 4) {
        while (z < 3) {
            
            // перенесем строку в конец цикла
            //z = z + 1;
            
            h[z] = new Hobbits();
            h[z].name = "Бильбо";
            
            if (z == 1) {
                h[z].name = "Фродо";
            }
            
            if (z == 2) {
                h[z].name = "Сэм";
            }
            
            System.out.print(h[z].name + " - ");
            System.out.println("имя хорошего хоббита");
            
            z = z + 1; // новое место
        }
    }
}
