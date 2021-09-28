package note.app.model;

import javax.persistence.*;

@Entity
@Table(name = "notatka")
public class Note {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;
    private String title;
    private String text;

    public Note() {
    }

    public Note(Long number, String text, String title) {
        this.number = number;
        this.text = text;
        this.title = title;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Note{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
