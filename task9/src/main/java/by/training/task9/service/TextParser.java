package by.training.task9.service;

public abstract class TextParser<T> {
    private TextParser<T> nextTextParser;

    public TextParser<T> setNext(TextParser<T> parser) {
        this.nextTextParser = parser;
        return parser;
    }

    public void writeManager(String s) {
        write(s);
        if (nextTextParser != null) {
            nextTextParser.writeManager(s);
        }
    }

    public void write(String s) {
        System.out.println(s);
    }

}
