package org.example.devhw18.mvc.model.dto;

import lombok.Builder;
import lombok.Data;
import org.example.devhw18.mvc.model.Note;
@Data
@Builder
public class NoteDto {
    private Long id;
    private String title;
    private String content;

    public static NoteDto fromNote(Note note){
        return NoteDto.builder()
                .id(note.getId())
                .title(note.getTitle())
                .content(note.getContent())
                .build();
    }


    public static Note fromDtoParameter(String title, String content) {
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        return note;
    }

    public static Note fromDtoParameterUpdate(Long id, String title, String content) {
        Note note = new Note();
        note.setId(id);
        note.setTitle(title);
        note.setContent(content);
        return note;
    }
}
