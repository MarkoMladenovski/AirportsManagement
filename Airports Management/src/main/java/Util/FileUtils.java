package Util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

public class FileUtils {

    public static MultipartFile loadFile(String filename) {
        Resource resource = new ClassPathResource(filename);
        try (InputStream input = resource.getInputStream()) {
            FileItem fileItem = new DiskFileItem("file", "multipart/form-data", false,
                    filename, (int) input.available(), null);
            fileItem.getOutputStream().write(input.readAllBytes());
            return new CommonsMultipartFileAdapter(fileItem);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load file: " + filename, e);
        }
    }

    public static byte[] readFileBytes(String filePath) throws IOException {
        Path path = Path.of(filePath);
        return Files.readAllBytes(path);
    }

    public static void saveFile(MultipartFile file, String destinationPath) {
        try {
            byte[] fileBytes = file.getBytes();

            Path destination = Path.of(destinationPath);
            if (!Files.exists(destination)) {
                Files.createDirectories(destination);
            }
            Path filePath = destination.resolve(Objects.requireNonNull(file.getOriginalFilename()));
            Files.write(filePath, fileBytes, StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save file: " + destinationPath, e);
        }
    }
}
