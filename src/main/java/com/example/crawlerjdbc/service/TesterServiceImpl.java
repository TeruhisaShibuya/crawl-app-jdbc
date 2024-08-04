package com.example.crawlerjdbc.service;

import com.example.crawlerjdbc.controller.dto.TesterFormDTO;
import com.example.crawlerjdbc.dao.TesterDAO;
import com.example.crawlerjdbc.model.Tester;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
@Slf4j
public class TesterServiceImpl implements TesterService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /** DAOをAutowired */
    private final TesterDAO testerDAO;

    /**
     *
     * @param dto
     */
    @Override
    @Transactional
    public void entry(TesterFormDTO dto) {

        // dtoを呼び出して登録処理を行う

        //TesterDAO testerDAO1 = new TesterDAO();
        //Tester newObj = testerDAO1.entry();
        Tester newObj = null;
        try {
            newObj = testerDAO.entry(dto);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        logger.info("Tester: 登録処理完了 お名前: `{}`, 年齢: `{}`",
                newObj.getName(), newObj.getAge());

    }
}
