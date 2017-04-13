package com.itechart.dao;

import com.itechart.entity.TecherEntity;

/**
 * Created by Aleksandr on 13.04.2017.
 */
public interface AbstractTeacherDao {
    void create(TecherEntity techerEntity);

    TecherEntity readById(Integer id);

    TecherEntity update(TecherEntity techerEntity);

    void delete(TecherEntity techerEntity);
}
