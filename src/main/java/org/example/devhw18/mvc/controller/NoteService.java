package org.example.devhw18.mvc.controller;

import lombok.RequiredArgsConstructor;
import org.example.devhw18.mvc.model.Note;
import org.example.devhw18.mvc.model.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;
    public Object createNote(Note note){
        return noteRepository.save(note);
    }

    public List<Note> getNoteByTitleContent(String query){
       return noteRepository.search(query);
    }

    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    public Optional<Note> getNoteById(Long id){
        return noteRepository.findById(id);
    }

    public void deleteByQuery(String query){
        noteRepository.delete(query);
    }
    public void deleteById(Long id){
        noteRepository.deleteById(id);
    }

    public void update(Long id, String title, String content){
        noteRepository.update(id, title, content);
    }
}
