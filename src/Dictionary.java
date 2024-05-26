public class Dictionary {
    private String[] dictionary = {"Лето", "Весна", "Осень", "Зима",
            "Одеяло", "Подушка", "Табурет"};

    public String getWord() {
        return dictionary[(int) (Math.random() * dictionary.length)];
    }
}
