package com.myself.dao;

import com.myself.model.Log;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/6/20 0020.
 */
public interface LogDAO {

    public void save(Log l) throws SQLException;

    public void delete(Log l);

}
