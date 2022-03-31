package br.com.dbccompany.model.file;

import java.util.List;

public class DatFileDTO {

    private String filename;
    private List<String> lines;

    public DatFileDTO(String filename, List<String> lines) {
        this.filename = filename;
        this.lines = lines;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }
}
