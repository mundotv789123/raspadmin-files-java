package github.mundotv789123.raspadmin;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import github.mundotv789123.raspadmin.models.UserModel;
import github.mundotv789123.raspadmin.models.enums.UserRole;
import github.mundotv789123.raspadmin.repositories.UsersRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

@SpringBootTest(properties = {
    "application.security.enable=true",
    "application.security.jwt.secret=secret",
    "application.security.user.name=admin",
    "application.security.user.password=admin",
    "application.videos.thumbnail=false",
    "spring.datasource.url=jdbc:sqlite::memory:"
})
@AutoConfigureMockMvc
class RaspadminApplicationMockTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UsersRepository usersRepository;

    @BeforeEach
    public void setup() {
        this.usersRepository.deleteAll();
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
    @DisplayName("Test login request success with use saved on database")
    void loginSuccessDatabase() throws Exception {
        this.usersRepository
            .save(new UserModel("user", "password", UserRole.USER, true));
        this.mockMvc.perform(post("/api/auth/login")
            .param("username", "user")
            .param("password", "password")
        ).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test login request invalid password with use saved on database")
    void loginFailDatabase() throws Exception {
        this.usersRepository
            .save(new UserModel("user", "password", UserRole.USER, true));
        this.mockMvc.perform(post("/api/auth/login")
            .param("username", "user")
            .param("password", "password2")
        ).andDo(print()).andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser
    @DisplayName("Test list files request")
    void testListFiles() throws Exception {
        this.mockMvc.perform(get("/api/files?path=/"))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    @DisplayName("Test list files not found request")
    void testListFilesPathNotFound() throws Exception {
        this.mockMvc.perform(get("/api/files?path=/teste_not_found"))
            .andDo(print())
            .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser
    @DisplayName("Test open file request")
    void testFileOpenPath() throws Exception {
        this.mockMvc.perform(get("/api/files/open?path=/teste/teste.txt"))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    @DisplayName("Test open partial file request")
    void openPartialFileRequest() throws Exception {
        var headers = new HttpHeaders();
        headers.add("Range", "bytes=0-");
        this.mockMvc
            .perform(get("/api/files/open?path=/teste/teste.txt").headers(headers))
            .andDo(print())
            .andExpect(status().isPartialContent());
    }

    @Test
    @WithMockUser
    @DisplayName("Test open invalid partial file request")
    void openInvalidPartialFileRequest() throws Exception {
        var headers = new HttpHeaders();
        headers.add("Range", "bytes=");
        this.mockMvc
            .perform(get("/api/files/open?path=/teste/teste.txt").headers(headers))
            .andDo(print())
            .andExpect(status().isRequestedRangeNotSatisfiable());
    }
}