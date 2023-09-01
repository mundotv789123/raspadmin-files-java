package github.mundotv789123.raspadmin;

import github.mundotv789123.raspadmin.controllers.FilesController;
import github.mundotv789123.raspadmin.controllers.FilesController.Response;
import github.mundotv789123.raspadmin.models.FileModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

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
    void contextLoads() {
        assertThat(filesController).isNotNull();
    }

    @Test
    void getFiles() {
        var files = filesController.getFiles("/").getBody();
        assertThat(files).isNotNull();

        var filesCompare = new Response(new ArrayList<>());
        filesCompare.getFiles().add(new FileModel("teste", true, null, null, false));

        assertThat(files).isNotSameAs(filesCompare);
    }

    @Test
    void getFilesNotFound() {
        var files = filesController.getFiles("/teste_not_found");
        assertThat(files.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void getFilesToOpen() {
        var response = filesController.getFiles("/teste/teste.txt").getBody();

        assertThat(response).isNotNull();
        assertThat(response.getFiles()).isNotEmpty();
        assertThat(response.getFiles().stream().findFirst().get().isOpen()).isTrue();
    }

    @Test
    void openFile() {
        var resource = filesController.openFile("/teste/teste.txt").getBody();
        assertThat(resource).isNotNull();
        assertThat(resource.exists()).isTrue();
    }

    /* mocks */
    @Test
    void login() throws Exception {
        this.mockMvc.perform(post("/api/files?path=/")).andDo(print()).andExpect(status().isUnauthorized());
        this.mockMvc.perform(post("/api/auth/login")
                .param("username", "admin")
                .param("password", "admin")
        ).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin")
    void testListFiles() throws Exception {
        this.mockMvc.perform(get("/api/files?path=/")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin")
    void testListFilesPath() throws Exception {
        this.mockMvc.perform(get("/api/files?path=/teste")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin")
    void testListFilesPathNotFound() throws Exception {
        this.mockMvc.perform(get("/api/files?path=/teste_not_found")).andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin")
    void testFileOpenPath() throws Exception {
        this.mockMvc.perform(get("/api/files/open?path=/teste/teste.txt")).andDo(print()).andExpect(status().isOk());
    }
}
