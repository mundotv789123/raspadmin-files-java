package github.mundotv789123.raspadmin.services.app;

import org.springframework.stereotype.Service;

import github.mundotv789123.raspadmin.config.AppConfig;
import github.mundotv789123.raspadmin.models.messages.responses.SettingsResponse;
import github.mundotv789123.raspadmin.services.FilesManagerService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SettingsAppService {

    private final AppConfig appConfig;
    private final FilesManagerService filesManagerService;

    public SettingsResponse getSettings() {
        var dir = appConfig.getMainPathFile();
        var wallpaperPath = filesManagerService.getDirWallpaperPath(dir);
        return new SettingsResponse(wallpaperPath);
    }
}
