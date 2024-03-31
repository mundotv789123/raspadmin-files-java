package github.mundotv789123.raspadmin;

import github.mundotv789123.raspadmin.controllers.FilesController;
import github.mundotv789123.raspadmin.models.FileModel;
import github.mundotv789123.raspadmin.services.FileIconService;
import github.mundotv789123.raspadmin.services.FileStreamService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.util.List;

@SpringBootTest(properties = {
    "application.videos.thumbnail=false",
    "spring.datasource.url=jdbc:sqlite::memory:"
})
class RaspadminApplicationTests {

    @Autowired
    private FilesController filesController;

    @Autowired
    private FileIconService fileIconService;

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

        FileModel file = response.getFiles().stream().filter(f -> f.getName().equals("teste")).findFirst().get();

        assertThat(file.isDir()).isTrue();
        assertThat(file.isOpen()).isFalse();
    }

    @Test
    @DisplayName("Test list files icon folder")
    void getFilesIconFolder() {
        var response = filesController.getFiles("/").getBody();

        assertThat(response).isNotNull();
        assertThat(response.getFiles()).isNotEmpty();

        FileModel file = response.getFiles().stream().filter(f -> f.getName().equals("icon_teste")).findFirst().get();

        assertThat(file).isNotNull();
        assertThat(file.isDir()).isTrue();
        assertThat(file.isOpen()).isFalse();
        assertThat(file.getIcon()).matches("[\\\\/]icon_teste[\\\\/]_icon\\.png");
    }

    @Test
    @DisplayName("Test list files type")
    void getFilesType() {
        var response = filesController.getFiles("/teste").getBody();

        assertThat(response).isNotNull();
        assertThat(response.getFiles()).isNotEmpty();

        FileModel file = response.getFiles().stream().filter(f -> f.getName().equals("teste.txt")).findFirst().get();

        assertThat(file).isNotNull();
        assertThat(file.isDir()).isFalse();
        assertThat(file.isOpen()).isFalse();
        assertThat(file.getType()).isNotNull();
        assertThat(file.getType()).isEqualTo("text/plain");
    }

    @Test
    @DisplayName("Test list files icons")
    void getFilesIconFolderIcons() {
        var response = filesController.getFiles("/teste").getBody();

        assertThat(response).isNotNull();
        assertThat(response.getFiles()).isNotEmpty();

        FileModel file = response.getFiles().stream().filter(f -> f.getName().equals("teste.txt")).findFirst().get();

        assertThat(file.isDir()).isFalse();
        assertThat(file.isOpen()).isFalse();
        assertThat(file.getIcon()).isNotNull();

        /* Test getting icon */
        var responseIcon = filesController.getFiles(file.getIcon()).getBody();

        assertThat(responseIcon.getFiles()).isNotEmpty();
        assertThat(responseIcon.getFiles().size()).isEqualTo(1);

        FileModel fileIcon = responseIcon.getFiles().stream().findFirst().get();

        assertThat(fileIcon.isDir()).isFalse();
        assertThat(fileIcon.isOpen()).isTrue();
    }

    @Test
    @DisplayName("Test list hidden files")
    void getHiddenFiles() {
        var response = filesController.getFiles("/teste").getBody();

        assertThat(response).isNotNull();
        assertThat(response.getFiles()).isNotEmpty();

        List<FileModel> files = response.getFiles().stream().filter(f -> f.getName().equals("_teste.txt")).toList();

        assertThat(files).isEmpty();
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
    @DisplayName("Test file hidden to open")
    void getHiddenFilesToOpen() {
        var response = filesController.getFiles("/teste/_teste.txt").getBody();

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
    @DisplayName("Test open hidden file")
    void openHiddenFile() {
        var resource = filesController.openFile("/teste/_teste.txt", null).getBody();
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

    @Test
    @DisplayName("Test file chached icon")
    void getFilesIconFileCachedIcon() {
        File fileTest = new File("./files/teste", "teste_cache_icon.txt");
        File fileTestIcon = new File("./files/_cache", "_d3b54bda-e476-11ee-8f04-d82327594a66.png");
        fileIconService.saveOnCache(fileTest, fileTestIcon);

        var response = filesController.getFiles("/teste").getBody();

        assertThat(response).isNotNull();
        assertThat(response.getFiles()).isNotEmpty();

        FileModel file = response.getFiles().stream().filter(f -> f.getName().equals("teste_cache_icon.txt")).findFirst().get();

        assertThat(file.isDir()).isFalse();
        assertThat(file.isOpen()).isFalse();
        assertThat(file.getIcon()).isNotNull();

        /* Test getting icon */
        var responseIcon = filesController.getFiles(file.getIcon()).getBody();

        assertThat(responseIcon.getFiles()).isNotEmpty();
        assertThat(responseIcon.getFiles().size()).isEqualTo(1);

        FileModel fileIcon = responseIcon.getFiles().stream().findFirst().get();

        assertThat(fileIcon.isDir()).isFalse();
        assertThat(fileIcon.isOpen()).isTrue();
    }
}
