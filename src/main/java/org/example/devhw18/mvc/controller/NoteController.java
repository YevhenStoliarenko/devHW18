package org.example.devhw18.mvc.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.devhw18.mvc.model.Note;
import org.example.devhw18.mvc.model.dto.NoteDto;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/note")
@RequiredArgsConstructor
@Repository

public class NoteController {
    private final NoteService noteService;
    private final ValidationService validationService;

    @PostMapping(value = "/create")
    public String createNote(@RequestParam(required = false) String title, @RequestParam(required = false) String content) {
        if(!validationService.titelValidation(title)){
            return "Note is not created";
        } else {
            Note note = NoteDto.fromDtoParameter(title, content);
            noteService.createNote(note);
            return "Note is created";
        }
    }

    @GetMapping(value = "/list")
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping(value = "/search")
    public List<NoteDto> search(@RequestParam(name = "query", required = false) String query) {
        return noteService.getNoteByTitleContent(query).stream().map(NoteDto::fromNote).toList();
    }

    @GetMapping(value = "/search/{id}")
    public Optional<Note> getNoteById(@PathVariable Long id, HttpServletResponse response){
        return noteService.getNoteById(id);
    }

    @PostMapping(value = "/delete")
    public void delete(@RequestParam(name = "query", required = false) String query) {
       noteService.deleteByQuery(query);
    }

    @PostMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable Long id){
         noteService.deleteById(id);
    }

    @PostMapping(value = "/update")
    public String update (@RequestParam Long id, @RequestParam String title, @RequestParam String content){
        if(!validationService.titelValidation(title)){
            return "Note is not update";
        }
        noteService.update(id, title, content);
        return "User is update";
    }
}
