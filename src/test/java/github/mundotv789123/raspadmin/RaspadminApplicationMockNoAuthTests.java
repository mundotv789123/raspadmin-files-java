package github.mundotv789123.raspadmin;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(properties = {
    "application.security.enable=false",
    "application.videos.thumbnail=false",
    "spring.datasource.url=jdbc:sqlite::memory:"
})
@AutoConfigureMockMvc
class RaspadminApplicationMockNoAuthTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test list files request")
    void testListFiles() throws Exception {
        this.mockMvc.perform(get("/api/files?path=/"))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test list files not found request")
    void testListFilesPathNotFound() throws Exception {
        this.mockMvc.perform(get("/api/files?path=/teste_not_found"))
            .andDo(print())
            .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Test open file request")
    void testFileOpenPath() throws Exception {
        this.mockMvc.perform(get("/api/files/open?path=/teste/teste.txt"))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
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