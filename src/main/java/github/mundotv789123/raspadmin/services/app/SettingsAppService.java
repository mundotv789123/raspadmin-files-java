package github.mundotv789123.raspadmin.services.app;

import java.io.IOException;

import org.springframework.stereotype.Service;

import github.mundotv789123.raspadmin.FilesHelper;
import github.mundotv789123.raspadmin.config.AppConfig;
import github.mundotv789123.raspadmin.models.messages.responses.SettingsResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SettingsAppService {

    private final AppConfig appConfig;
    private final FilesHelper filesHelper;

    public SettingsResponse getSettings() throws IOException {
        var dir = appConfig.getMainPathFile();

        var wallpaperFile = filesHelper.getIconOfDir(dir, "wallpaper");
        var wallpaperPath = wallpaperFile.isPresent() ? filesHelper.getOriginalPath(wallpaperFile.get()) : null;

        return new SettingsResponse(wallpaperPath);
    }
}
