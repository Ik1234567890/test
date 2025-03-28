import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class MovieCollectionManager {
    private JFrame frame;
    private JTextField titleField;
    private JComboBox<String> genreBox;
    private JTable movieTable;
    private DefaultTableModel tableModel;
    private JLabel movieCountLabel;
    private ArrayList<Movie> movies;
    
class Movie {
    private String title;
    private String genre;

    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }
}
    public MovieCollectionManager() {
        movies = new ArrayList<>();
        frame = new JFrame("Movie Collection Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        titleField = new JTextField(15);
        genreBox = new JComboBox<>(new String[]{"Action", "Comedy", "Horror", "Drama", "Sci-Fi"});
        JButton addButton = new JButton("Add Movie");
        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Genre:"));
        inputPanel.add(genreBox);
        inputPanel.add(addButton);

        tableModel = new DefaultTableModel(new String[]{"Title", "Genre"}, 0);
        movieTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(movieTable);

        JPanel controlPanel = new JPanel();
        JButton sortTitleButton = new JButton("Sort by Title");
        JButton sortGenreButton = new JButton("Sort by Genre");
        JTextField searchField = new JTextField(10);
        JButton searchButton = new JButton("Search");
        movieCountLabel = new JLabel("Movies: 0");
        controlPanel.add(sortTitleButton);
        controlPanel.add(sortGenreButton);
        controlPanel.add(new JLabel("Search:"));
        controlPanel.add(searchField);
        controlPanel.add(searchButton);
        controlPanel.add(movieCountLabel);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addMovie());
        sortTitleButton.addActionListener(e -> sortMoviesByTitle());
        sortGenreButton.addActionListener(e -> sortMoviesByGenre());
        searchButton.addActionListener(e -> searchMovie(searchField.getText()));

        frame.setVisible(true);
    }

    private void addMovie() {
        String title = titleField.getText().trim();
        String genre = (String) genreBox.getSelectedItem();
        if (!title.isEmpty()) {
            movies.add(new Movie(title, genre));
            updateTable();
        }
    }

    private void updateTable() {
        tableModel.setRowCount(0);
        for (Movie movie : movies) {
            tableModel.addRow(new Object[]{movie.getTitle(), movie.getGenre()});
        }
        movieCountLabel.setText("Movies: " + movies.size());
    }

    private void sortMoviesByTitle() {
        movies.sort(Comparator.comparing(Movie::getTitle));
        updateTable();
    }

    private void sortMoviesByGenre() {
        movies.sort(Comparator.comparing(Movie::getGenre));
        updateTable();
    }

    private void searchMovie(String title) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getTitle().equalsIgnoreCase(title)) {
                movieTable.setRowSelectionInterval(i, i);
                return;
            }
        }
        JOptionPane.showMessageDialog(frame, "Movie not found");
    }

    public static void main(String[] args) {
        new MovieCollectionManager();
    }
}
