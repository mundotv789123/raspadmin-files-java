package github.mundotv789123.raspadmin.config;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import lombok.Getter;

@Configuration
public class AppConfig {

    @Value("${application.filesmanager.path:./files}")
    private @Getter String mainPath;

    @Value("${application.filesmanager.cachepath:./_cache}")
    private @Getter String cachePath;

    private @Getter File mainPathFile;

    @PostConstruct
    public void init() {
        mainPathFile = new File(mainPath);
    }
}
