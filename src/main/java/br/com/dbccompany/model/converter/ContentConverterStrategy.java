package br.com.dbccompany.model.converter;

import br.com.dbccompany.model.enums.DatFileLineTypeEnum;

public abstract class ContentConverterStrategy {

    protected final String separator = "ç";

    protected void validateContent(String content) {
        if (!content.startsWith(getLineType().getLineTypeId()) || !content.contains(separator)) {
            throw new IllegalArgumentException(String.format("Não é possível converter o cliente: %s", content));
        }
    }

    abstract DatFileLineTypeEnum getLineType();
    public abstract Object convertContentToModel(String content) throws IllegalArgumentException;

}
