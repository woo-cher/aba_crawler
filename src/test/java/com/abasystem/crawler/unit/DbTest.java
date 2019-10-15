package com.abasystem.crawler.unit;

import com.abasystem.crawler.Builder.RegularPostBuilder;
import com.abasystem.crawler.Factory.RepositoryFactory;
import com.abasystem.crawler.Model.Property.IrregularProperty;
import com.abasystem.crawler.Model.Property.RegularProperty;
import com.abasystem.crawler.Repository.SchedulerRepository;
import com.abasystem.crawler.Strategy.BasicQueryStrategy;
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
    private static final IrregularProperty I_MOCK = new IrregularProperty("I_TITLE", "I_URL", "I_2020.12.12", "I_DESC", "I_PHONE");

    private BasicQueryStrategy repository;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private RepositoryFactory factory;

    @Autowired
    private SchedulerRepository schedulerRepository;

    @Test
    public void dataSource() throws SQLException {
        logger.debug("Datasource : {}", dataSource.getConnection());
        assertNotNull(dataSource.getConnection());
    }

    @Test
    @Transactional
    public void regularCrud() {
        repository = factory.getTypeRepositoryCreator(RegularProperty.class);
        // Create
        assertThat(repository.createProp(R_MOCK), is(1));
        int generateKey = R_MOCK.getId();

        // Read
        RegularProperty actual = (RegularProperty) repository.selectOneById(generateKey);
        assertNotNull(actual);
        assertThat(actual, is(R_MOCK));

        // Update
        actual.setPhone("update_phone");
        assertThat(repository.updateProp(actual), is(1));

        RegularProperty matcher = (RegularProperty) repository.selectOneById(actual.getId());
        assertThat(actual.getPhone(), is(matcher.getPhone()));

        // Delete
        assertThat(repository.deleteProp(generateKey), is(1));
    }

    @Test
    @Transactional
    public void irregularCrud() {
        repository = factory.getTypeRepositoryCreator(IrregularProperty.class);
        // Create
        assertThat(repository.createProp(I_MOCK), is(1));
        int generateKey = I_MOCK.getId();

        // Read
        IrregularProperty actual = (IrregularProperty) repository.selectOneById(generateKey);
        assertNotNull(actual);
        assertThat(actual, is(I_MOCK));

        // Update
        actual.setDescription("update_desc");
        assertThat(repository.updateProp(actual), is(1));

        IrregularProperty matcher = (IrregularProperty) repository.selectOneById(actual.getId());
        assertThat(actual.getDescription(), is(matcher.getDescription()));
        logger.debug("actual {}", actual);

        // Delete
        assertThat(repository.deleteProp(generateKey), is(1));
    }

    @Test
    public void schedulerLog() {
        logger.debug("id : " + schedulerRepository.getNextId());
    }

    @Test
    public void test() {
        BasicQueryStrategy repository = factory.getTypeRepositoryCreator(RegularProperty.class);
        logger.debug("repository {}", repository);
    }

}