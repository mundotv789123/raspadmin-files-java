package github.mundotv789123.raspadmin;

import github.mundotv789123.raspadmin.controllers.FilesController;
import github.mundotv789123.raspadmin.repositories.FilesRepository;
import github.mundotv789123.raspadmin.services.exceptions.InvalidOperateServiceException;
import github.mundotv789123.raspadmin.services.stream.FileStreamService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;


@ActiveProfiles("test")
@SpringBootTest(properties = { "application.videos.thumbnail=false" })
class RaspadminApplicationTests {

    @Autowired
    private FilesRepository fileIconsRepository;

    @AfterEach
    void after() {
        fileIconsRepository.deleteAll();
    }

    @Autowired
    private FilesController filesController;


    @Test
    @DisplayName("Load controllers")
    void contextLoads() {
        assertThat(filesController).isNotNull();
    }

    @Test
    @SuppressWarnings("null")
    @DisplayName("Test list files")
    void getFiles() throws IOException {
        var response = filesController.getFiles("/").getBody();

        assertThat(response).isNotNull();
        assertThat(response.getFiles()).isNotEmpty();

        var file = response.getFiles().stream().filter(f -> f.getName().equals("teste")).findFirst().get();

        assertThat(file.isDir()).isTrue();
        assertThat(file.isOpen()).isFalse();
    }

    @Test
    @SuppressWarnings("null")
    @DisplayName("Test list files icon folder")
    void getFilesIconFolder() throws IOException {
        var response = filesController.getFiles("/").getBody();

        assertThat(response).isNotNull();
        assertThat(response.getFiles()).isNotEmpty();

        var file = response.getFiles().stream().filter(f -> f.getName().equals("icon_teste")).findFirst().get();

        assertThat(file).isNotNull();
        assertThat(file.isDir()).isTrue();
        assertThat(file.isOpen()).isFalse();
        assertThat(file.getIcon()).matches("[\\\\/]icon_teste[\\\\/]_icon\\.png");
    }

    @Test
    @SuppressWarnings("null")
    @DisplayName("Test list files type")
    void getFilesType() throws IOException {
        var response = filesController.getFiles("/teste").getBody();

        assertThat(response).isNotNull();
        assertThat(response.getFiles()).isNotEmpty();

        var file = response.getFiles().stream().filter(f -> f.getName().equals("teste.txt")).findFirst().get();

        assertThat(file).isNotNull();
        assertThat(file.isDir()).isFalse();
        assertThat(file.isOpen()).isFalse();
        assertThat(file.getType()).isNotNull();
        assertThat(file.getType()).isEqualTo("text/plain");
    }

    @Test
    @SuppressWarnings("null")
    @DisplayName("Test list hidden files")
    void getHiddenFiles() throws IOException {
        var response = filesController.getFiles("/teste").getBody();

        assertThat(response).isNotNull();
        assertThat(response.getFiles()).isNotEmpty();

        var files = response.getFiles().stream().filter(f -> f.getName().equals("_teste.txt")).toList();

        assertThat(files).isEmpty();
    }

    @Test
    @SuppressWarnings("null")
    @DisplayName("Test get file not found")
    void getFilesNotFound() throws IOException {
        var exception = assertThrows(InvalidOperateServiceException.class, () -> {
            filesController.getFiles("/teste_not_found");
        });
        assertThat(exception.getCode()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }

    @Test
    @SuppressWarnings("null")
    @DisplayName("Test file to open")
    void getFilesToOpen() throws IOException {
        var response = filesController.getFiles("/teste/teste.txt").getBody();

        assertThat(response).isNotNull();
        assertThat(response.getFiles()).isNotEmpty();

        var file = response.getFiles().stream().findFirst().get();

        assertThat(file.isDir()).isFalse();
        assertThat(file.isOpen()).isTrue();
    }

    @Test
    @SuppressWarnings("null")
    @DisplayName("Test file hidden to open")
    void getHiddenFilesToOpen() throws IOException {
        var response = filesController.getFiles("/teste/_teste.txt").getBody();

        assertThat(response).isNotNull();
        assertThat(response.getFiles()).isNotEmpty();

        var file = response.getFiles().stream().findFirst().get();

        assertThat(file.isDir()).isFalse();
        assertThat(file.isOpen()).isTrue();
    }

    @Test
    @DisplayName("Test open file")
    void openFile() throws IOException {
        var resource = filesController.openFile("/teste/teste.txt", null).getBody();
        assertThat(resource).isNotNull().isInstanceOf(FileStreamService.class);
    }

    @Test
    @DisplayName("Test open hidden file")
    void openHiddenFile() throws IOException {
        var resource = filesController.openFile("/teste/_teste.txt", null).getBody();
        assertThat(resource).isNotNull().isInstanceOf(FileStreamService.class);
    }

    @Test
    @SuppressWarnings("null")
    @DisplayName("Test open partial file")
    void openPartialFile() throws IOException {
        var resource = filesController.openFile("/teste/teste.txt", "bytes=0-5").getBody();

        assertThat(resource).isNotNull().isInstanceOf(FileStreamService.class);

        FileStreamService fileService = (FileStreamService) resource;

        assertThat(fileService.getStart()).isZero();
        assertThat(fileService.getEnd()).isEqualTo(5);
    }

    @Test
    @SuppressWarnings("null")
    @DisplayName("Test open start partial file")
    void openStartPartialFile() throws IOException {
        var resource = filesController.openFile("/teste/teste.txt", "bytes=2-").getBody();

        assertThat(resource).isNotNull().isInstanceOf(FileStreamService.class);
        assertThat(((FileStreamService)resource).getStart()).isEqualTo(2);
    }

}
