package io.spring.friendsnet.dao;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import io.spring.friendsnet.entity.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PersonDAOIT {

    @Autowired
    private PersonDAO dao;

    @Test
    @DatabaseSetup("/db/initial-person.xml")
    public void testFindAll() {
        // Act
        List<Person> all = (List<Person>) dao.findAll();

        // Assert
        Assert.assertEquals(2, all.size());
    }

    @Test
    @DatabaseSetup("/db/initial-person.xml")
    public void testSavePerson() {
        // Arrange
        final Person person = new Person();
        person.setName("A");
        person.setSurname("B");

        // Act
        dao.save(person);

        // Assert
        List<Person> all = (List<Person>) dao.findAll();
        Assert.assertEquals(3, all.size());
    }


    @Test
    @DatabaseSetup("/db/initial-person.xml")
    @ExpectedDatabase(value = "/db/after-saving-person.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testSavePerson2() {
        // Arrange
        final Person person = new Person();
        person.setName("A");
        person.setSurname("B");

        // Act
        dao.save(person);
    }


    @Test
    @DatabaseSetup("/db/initial-person.xml")
    @ExpectedDatabase(value = "/db/after-removing-person.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testRemovePerson() {
        // Act
        dao.remove(dao.findById(1L));
    }

}
