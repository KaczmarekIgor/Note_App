package note.app.service.note;

import note.app.model.Note;
import note.app.repository.NoteRepo;
import note.app.service.note.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    private List<Note> noteList;
    private NoteRepo noteRepo;

    @Autowired
    public NoteServiceImpl(NoteRepo noteRepo) {
        noteList = new ArrayList<>();
        this.noteRepo = noteRepo;
    }

    @Override
    public void addNote(Note note) {
        noteList.add(note);
        noteRepo.save(note);
    }

    @Override
    public void deleteNote(Long number) {
        Optional elementToDelete = noteList
                .stream()
                .filter(note -> note.getNumber() == number).findFirst();
        noteList.remove(elementToDelete);
    }

    @Override
    public void modificationNote(Note newNote) {
        Optional modificationNote = noteList.stream()
                .filter(note -> note.getNumber() == newNote.getNumber()).findFirst();
        if (modificationNote.isPresent()) {
            noteList.remove(modificationNote);
            noteList.add(newNote);
        }
    }

    @Override
    public List<Note> getNotes() {
        return noteList;
    }

    @Override
    public List<Note> clearPage() {
        noteList.clear();
        return noteList;
    }
}
