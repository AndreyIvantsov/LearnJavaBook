public class PhraseOMatic {

    public static void main(String[] args) {
        String[] wordListOne = {
            "круглосуточный ", "трех-звенный", "30000-фунтовый",
            "взаимный", "обоюдный выйгрыш", "фронтэнд",
            "на основе веб-технологи", "проникющий", "умный",
            "шесть сигм", "метод критического пути", "динамический"
        };
        
        String[] wordListTwo = {
            "уполномоченный", "трудный", "чистый пруд",
            "ориентировочный", "центральный", "распределенный",
            "кластеризованный", "фирменный", "нестандартный ум",
            "позицинированный", "сетевой", "сфокусированный",
            "использованный с выгодой", "выровненный", "нацеленный на",
            "общий", "совместный", "ускоренный"
        };
        
        String[] wordListThree = {
            "процесс", "пункт", "разгрузки",
            "выход из положения", "тип структуры", "талант",
            "подход", "уровень завоеванного внимания", "портал",
            "период времени", "обзор", "пункт следования"
        };
        
        // Вычисляема сколько слов в каждом списке
        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLength = wordListThree.length;
        
        // Генерируем три случайных чивла
        int rand1 = (int) (Math.random() * oneLength);
        int rand2 = (int) (Math.random() * twoLength);
        int rand3 = (int) (Math.random() * threeLength);
        
        // Строем фразу
        String phrase = wordListOne[rand1] + " " + 
                wordListTwo[rand2] + " " + wordListThree[rand3];
                
        // Выводим фразу в консоль
        System.out.println("Все, что нам нужно, - это " + phrase);
    }

}
