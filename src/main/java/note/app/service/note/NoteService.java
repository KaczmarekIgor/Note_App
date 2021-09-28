package note.app.service.note;


import note.app.model.Note;
import note.app.repository.NoteRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {

    void addNote(Note note);

    void deleteNote(Long number);

    void modificationNote(Note newNote);

    List<Note> getNotes();

    List<Note> clearPage();


}
