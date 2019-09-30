package com.abasystem.crawler;

import com.abasystem.crawler.Builder.RegularPostBuilder;
import com.abasystem.crawler.Model.PeterPan.IrregularProperty;
import com.abasystem.crawler.Model.PeterPan.RegularProperty;
import com.abasystem.crawler.Repository.RegularPropertyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.SQLException;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbTest {
    private static final Logger logger = LoggerFactory.getLogger(DbTest.class);

    private static final RegularProperty R_MOCK = new RegularPostBuilder("R_TITLE", "R_URL", "R_2018.09.20", "R_DESC").build();
    private static final IrregularProperty I_MOCK = new IrregularProperty("I_TITLE", "I_URL", "I_2020.12.12", "I_DESC");

    @Autowired
    private DataSource dataSource;

    @Autowired
    private RegularPropertyRepository rRepository;

    @Test
    public void dataSource() throws SQLException {
        logger.debug("Datasource : {}", dataSource.getConnection());
        assertNotNull(dataSource.getConnection());
    }

    @Test
    @Transactional
    public void crud() {
        // Create
        assertThat(rRepository.createProp(R_MOCK), is(1));
        int generateKey = R_MOCK.getId();

        // Read
        RegularProperty actual = rRepository.selectOneById(generateKey);
        assertThat(actual, is(R_MOCK));

        // Update
        actual.setPhone("update_phone");
        assertThat(rRepository.updateProp(actual), is(1));
        assertThat(actual.getPhone(), is(rRepository.selectOneById(actual.getId()).getPhone()));
        logger.debug("actual {}", actual);

        // Delete
        assertThat(rRepository.deleteProp(generateKey), is(1));
    }
}