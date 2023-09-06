package github.mundotv789123.raspadmin;

import github.mundotv789123.raspadmin.controllers.FilesController;
import github.mundotv789123.raspadmin.models.FileModel;
import github.mundotv789123.raspadmin.services.FileStreamService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = {
        "application.security.disabled=false",
        "spring.security.user.name=admin",
        "spring.security.user.password=admin"
})
@AutoConfigureMockMvc
class RaspadminApplicationTests {

    @Autowired
    private MockMvc mockMvc;

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

    /* mocks */
    @Test
    @DisplayName("Test access protected routers")
    void accessRouters() throws Exception {
        this.mockMvc.perform(post("/api/files?path=/")).andDo(print())
            .andExpect(status().isUnauthorized());
        this.mockMvc.perform(post("/api/files/open?path=/")).andDo(print())
            .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("Test login request")
    void login() throws Exception {
        this.mockMvc.perform(post("/api/auth/login")
                .param("username", "admin")
                .param("password", "admin2")
        ).andDo(print()).andExpect(status().isUnauthorized());

        this.mockMvc.perform(post("/api/auth/login")
                .param("username", "admin")
                .param("password", "admin")
        ).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test list files request")
    @WithMockUser(username = "admin", password = "admin")
    void testListFiles() throws Exception {
        this.mockMvc.perform(get("/api/files?path=/")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test list files not found request")
    @WithMockUser(username = "admin", password = "admin")
    void testListFilesPathNotFound() throws Exception {
        this.mockMvc.perform(get("/api/files?path=/teste_not_found")).andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Test open file request")
    @WithMockUser(username = "admin", password = "admin")
    void testFileOpenPath() throws Exception {
        this.mockMvc.perform(get("/api/files/open?path=/teste/teste.txt")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test open partial file request")
    @WithMockUser(username = "admin", password = "admin")
    void openPartialFileRequest() throws Exception {
        var headers = new HttpHeaders();
        headers.add("Range", "bytes=0-");
        this.mockMvc
                .perform(get("/api/files/open?path=/teste/teste.txt").headers(headers))
                .andDo(print())
                .andExpect(status().isPartialContent());
    }

    @Test
    @DisplayName("Test open invalid partial file request")
    @WithMockUser(username = "admin", password = "admin")
    void openInvalidPartialFileRequest() throws Exception {
        var headers = new HttpHeaders();
        headers.add("Range", "bytes=");
        this.mockMvc
                .perform(get("/api/files/open?path=/teste/teste.txt").headers(headers))
                .andDo(print())
                .andExpect(status().isRequestedRangeNotSatisfiable());
    }

}
