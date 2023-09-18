package github.mundotv789123.raspadmin;

import github.mundotv789123.raspadmin.controllers.FilesController;
import github.mundotv789123.raspadmin.models.FileModel;
import github.mundotv789123.raspadmin.services.FileStreamService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RaspadminApplicationTests {

    @Autowired
    private FilesController filesController;

    @Test
    @DisplayName("Load controllers")
    void contextLoads() {
        assertThat(filesController).isNotNull();
    }

    @Test
    @DisplayName("Test list files")
    void getFiles() {
        var response = filesController.getFiles("/").getBody();

        assertThat(response).isNotNull();
        assertThat(response.getFiles()).isNotEmpty();

        FileModel file = response.getFiles().stream().findFirst().get();

        assertThat(file.isDir()).isTrue();
        assertThat(file.isOpen()).isFalse();
    }

    @Test
    @DisplayName("Test get file not found")
    void getFilesNotFound() {
        var files = filesController.getFiles("/teste_not_found");
        assertThat(files.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    @DisplayName("Test file to open")
    void getFilesToOpen() {
        var response = filesController.getFiles("/teste/teste.txt").getBody();

        assertThat(response).isNotNull();
        assertThat(response.getFiles()).isNotEmpty();

        FileModel file = response.getFiles().stream().findFirst().get();

        assertThat(file.isDir()).isFalse();
        assertThat(file.isOpen()).isTrue();
    }

    @Test
    @DisplayName("Test open file")
    void openFile() {
        var resource = filesController.openFile("/teste/teste.txt", null).getBody();
        assertThat(resource).isNotNull().isInstanceOf(FileStreamService.class);
    }

    @Test
    @DisplayName("Test open partial file")
    void openPartialFile() {
        var resource = filesController.openFile("/teste/teste.txt", "bytes=0-5").getBody();

        assertThat(resource).isNotNull().isInstanceOf(FileStreamService.class);

        FileStreamService fileService = (FileStreamService) resource;

        assertThat(fileService.getStart()).isZero();
        assertThat(fileService.getEnd()).isEqualTo(5);
    }

    @Test
    @DisplayName("Test open start partial file")
    void openStartPartialFile() {
        var resource = filesController.openFile("/teste/teste.txt", "bytes=2-").getBody();

        assertThat(resource).isNotNull().isInstanceOf(FileStreamService.class);
        assertThat(((FileStreamService)resource).getStart()).isEqualTo(2);
    }
}
