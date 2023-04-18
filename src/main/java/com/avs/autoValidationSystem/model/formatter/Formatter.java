package com.avs.autoValidationSystem.model.formatter;

import java.util.List;

/**
 * @param <T> тип принимаемых данных для преобразования
 * @param <S> тип возвращаемых преобразованных данных
 */
public interface Formatter<T, S> {
    default List<S> getFormattedData(List<T> data) {
        return null;
    }
    S getFormattedData(T data);
}
