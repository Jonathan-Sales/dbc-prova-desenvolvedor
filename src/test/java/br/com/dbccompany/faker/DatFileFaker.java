package br.com.dbccompany.faker;

import br.com.dbccompany.model.file.DatFileDTO;

import java.util.ArrayList;
import java.util.List;

public class DatFileFaker {

    private static List<String> getDatFileLines() {
        List<String> lines = new ArrayList<>();
        lines.add("001ç1234567891234çPedroç50000");
        lines.add("001ç3245678865434çPauloç40000.99");
        lines.add("002ç2345675434544345çJose da SilvaçRural");
        lines.add("002ç2345675433444345çEduardo PereiraçRural");
        lines.add("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro");
        lines.add("003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo");
        return lines;
    }

    public static List<DatFileDTO> getValidDatFileDTOList() {
        List<DatFileDTO> datFileList = new ArrayList<>();
        datFileList.add(new DatFileDTO("file01", getDatFileLines()));

        return datFileList;
    }

}
