package github.mundotv789123.raspadmin.controllers;

import github.mundotv789123.raspadmin.models.FileModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import github.mundotv789123.raspadmin.repositories.FilesManagerRepository;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/files")
public class FilesController {

    private final FilesManagerRepository repository;

    private static final String HIDDEN_FILES_PREFIX = "^[\\._].*$";

    @GetMapping
    public ResponseEntity<Response> getFiles(@RequestParam(name="path") String path) {
        try {
            var files = repository.getFiles(path).stream().filter(file ->
                    !file.getName().matches(HIDDEN_FILES_PREFIX)
            ).collect(Collectors.toList());

            return ResponseEntity.ok(new Response(files));
        } catch (FileNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("open")
    public ResponseEntity<Resource> openFile(@RequestParam(name="path") String path) {
        try {
            var file = repository.getFileByPath(path);
            var resource = new UrlResource(file.toURI());
            var type = MediaType.parseMediaType(Files.probeContentType(file.toPath()));

            return ResponseEntity.ok().contentType(type).body(resource);
        } catch (FileNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @AllArgsConstructor
    public static class Response {
        private final @Getter List<FileModel> files;
    }
}
