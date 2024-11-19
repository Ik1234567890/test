public class library {
    public static void main(String[] args) {
        Book b1 = new Book("Pod Igoto", "Ivan Vazov", "300");
        b1.print();
        Book b2 = new Book("Iron Candlestick", "Dimitur Talev", "400");
        b2.print();



    }
}

class Book {
    private String title;
    private String author;
    private String numberOfPages;

    public Book(String initTitle, String initAuthor, String initNumberOfPages) {
        title = initTitle;
        author= initAuthor;
        numberOfPages = initNumberOfPages;
    }

    public void print() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Number of pages: " + numberOfPages);

    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }

    public String getNumberOfPages() {
        return numberOfPages;
    }
}
