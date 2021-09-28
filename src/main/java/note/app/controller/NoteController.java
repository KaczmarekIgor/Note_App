package note.app.controller;

import note.app.model.Note;
import note.app.repository.NoteRepo;
import note.app.service.note.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/home")
public class NoteController {


    private NoteRepo noteRepo;
    private NoteService noteService;
    private List<Note> noteList;

    @Autowired
    public NoteController(NoteRepo noteRepo, NoteService noteService) {
        this.noteRepo = noteRepo;
        this.noteService = noteService;
        noteList = new ArrayList<>();
    }


    @GetMapping
    public String getNotes(Model model) {
        model.addAttribute("newNote", new Note());
        return "home";
    }

    @PostMapping
    public String addNote(Model model, Note note) {
        model.addAttribute("newNote", note);
        noteService.addNote(note);
        return "madeNote";
    }

    @DeleteMapping
    public String deleteNote(@RequestParam Long number) {
        noteService.deleteNote(number);
        return "home";
    }

    @PutMapping
    public void modificationNote(@RequestBody Note newNote) {
        noteService.modificationNote(newNote);

    }
    @PostMapping("/clear")
    public String clearPage(){
        noteService.clearPage();
         noteService.getNotes();
        return "madeNote";
    }
}

