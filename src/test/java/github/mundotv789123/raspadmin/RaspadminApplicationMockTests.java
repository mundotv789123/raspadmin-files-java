package github.mundotv789123.raspadmin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import github.mundotv789123.raspadmin.repositories.FilesRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = {
    "application.security.enable=true",
    "application.security.jwt.secret=secret",
    "application.security.user.name=admin",
    "application.security.user.password=admin",
    "application.videos.thumbnail=false",
    "spring.jpa.hibernate.ddl-auto=update",
    "spring.datasource.url=jdbc:sqlite:database_test.db"
})
@AutoConfigureMockMvc
class RaspadminApplicationMockTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FilesRepository fileIconsRepository;

    @AfterEach
    void after() {
        fileIconsRepository.deleteAll();
    }

    @Test
    @DisplayName("Test access protected routers")
    void accessRouters() throws Exception {
        this.mockMvc.perform(post("/api/files?path=/")).andDo(print())
            .andExpect(status().isUnauthorized());
        this.mockMvc.perform(post("/api/files/open?path=/")).andDo(print())
            .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("Test login request fail username")
    void loginFailUsername() throws Exception {
        this.mockMvc.perform(post("/api/auth/login")
            .param("username", "admin2")
            .param("password", "admin")
        ).andDo(print()).andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("Test login request fail password")
    void loginFailPassword() throws Exception {
        this.mockMvc.perform(post("/api/auth/login")
            .param("username", "admin")
            .param("password", "admin2")
        ).andDo(print()).andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("Test login request success")
    void loginSuccess() throws Exception {
        this.mockMvc.perform(post("/api/auth/login")
            .param("username", "admin")
            .param("password", "admin")
        ).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test list files request")
    @WithMockUser(username = "admin", password = "admin")
    void testListFiles() throws Exception {
        this.mockMvc.perform(get("/api/files?path=/"))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test list files not found request")
    @WithMockUser(username = "admin", password = "admin")
    void testListFilesPathNotFound() throws Exception {
        this.mockMvc.perform(get("/api/files?path=/teste_not_found"))
            .andDo(print())
            .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Test open file request")
    @WithMockUser(username = "admin", password = "admin")
    void testFileOpenPath() throws Exception {
        this.mockMvc.perform(get("/api/files/open?path=/teste/teste.txt"))
            .andDo(print())
            .andExpect(status().isOk());
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