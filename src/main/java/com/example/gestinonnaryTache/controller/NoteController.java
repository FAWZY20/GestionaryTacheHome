package com.example.gestinonnaryTache.controller;

import com.example.gestinonnaryTache.model.Note;
import com.example.gestinonnaryTache.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {
    @Autowired
    private NoteRepository noteRepository;

    @PostMapping("/nouvelleNote")
    public void addNote(@RequestBody Note note)
    {
        noteRepository.save(note);
    }

    @GetMapping("/afficherNote/{id}")
    public List<Note> getNote(@PathVariable("id") String id){
        return noteRepository.findByUser(id);
    }

    @DeleteMapping("deleteNote/{id}")
    public void deleteNote(@PathVariable("id") Long id){
        noteRepository.deleteById(id);
    }
}
