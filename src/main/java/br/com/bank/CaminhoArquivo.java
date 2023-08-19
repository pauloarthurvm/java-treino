package br.com.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CaminhoArquivo {

    private Path diretorio;
    private Path arquivo;

    private CaminhoArquivo(Path diretorio, Path arquivo) {
        super();
        this.diretorio = diretorio;
        this.arquivo = arquivo;
    }

    public Path getDiretorio() {
        return diretorio;
    }

    public Path getArquivo() {
//        return arquivo;
        return arquivo;
    }

    public static CaminhoArquivo getInstance(Integer id) {
        final String TMP_RAIZ = "/tmp/";
        final int PASTA = (int) Math.ceil((double)id/1000);
        final String PATH_ARQUIVO = TMP_RAIZ + PASTA + "/";
        return new CaminhoArquivo(Paths.get(PATH_ARQUIVO), Paths.get(PATH_ARQUIVO + id));
    }

}
