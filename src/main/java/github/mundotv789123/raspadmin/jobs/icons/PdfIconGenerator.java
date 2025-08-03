package github.mundotv789123.raspadmin.jobs.icons;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.rendering.PDFRenderer;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class PdfIconGenerator extends IconGenerator {

    public PdfIconGenerator(int width) {
        super(width);
    }

    @Override
    public boolean generateIcon(File file, File icon) throws IOException, InterruptedException {
        String input = file.getCanonicalPath();
        String output = icon.getCanonicalPath();

        log.info("Generating thumbnail File: '" + input + "' To: '" + output + "'");
        try (var document = Loader.loadPDF(file)) {
            var pdfRenderer = new PDFRenderer(document);

            var pageSize = document.getPage(0).getMediaBox();
            var originalWidth = pageSize.getWidth();
            
            float scale = width / originalWidth;

            var coverImage = pdfRenderer.renderImage(0, scale);
            ImageIO.write(coverImage, "PNG", icon);
        } catch (IOException e) {
            log.error(e);
            e.printStackTrace();
        }

        return true;
    }
}
