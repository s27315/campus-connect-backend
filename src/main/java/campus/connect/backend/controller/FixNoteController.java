package campus.connect.backend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import campus.connect.backend.domain.FixNote;
import campus.connect.backend.service.FixNoteService;

@RestController
@RequestMapping(value = "/api/fix-notes")
public class FixNoteController {
    @Autowired
    private FixNoteService fixNoteService;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveFixNote(@RequestBody FixNote fixNote, @RequestParam("wifiReportId") UUID id) {
        String result = fixNoteService.savingFixnote(fixNote, id);
        if (result.equals("The wifi report with this id does not exist")) {
            return new ResponseEntity<>(result, HttpStatus.valueOf(404));

        } else if (result.equals("Fix notes are only for RESOLVED wifi reports")) {
            return new ResponseEntity<>(result, HttpStatus.valueOf(400));
        } else {

            return new ResponseEntity<>(result, HttpStatus.valueOf(201));

        }
    }

    @GetMapping(value = "/student/{studentNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> fix(@PathVariable int studentNumber) {
        List<FixNote> an = fixNoteService.ex(studentNumber);
        return new ResponseEntity<>(an, HttpStatus.OK);

    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteFix(@PathVariable UUID id) {
        String result = fixNoteService.deleteFixnote(id);

        if (result.equals("The fix note with that id does not exist")) {
            return new ResponseEntity<>(result, HttpStatus.valueOf(404));
        } else {

            return new ResponseEntity<>(result, HttpStatus.OK);

        }
    }
}
