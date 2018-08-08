package io.spring.friendsnet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.spring.friendsnet.controller.domain.PersonDTO;
import io.spring.friendsnet.entity.Person;
import io.spring.friendsnet.manager.PersonManager;
import io.spring.friendsnet.utils.converter.EntityConverter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class GroupControllerTest {

    @InjectMocks
    private PersonController personController;

    @Mock
    private PersonManager personManager;

    @Mock
    private EntityConverter entityConverter;

    private MockMvc mockMvc;

    private ObjectMapper mapper;


    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
        this.mapper = new ObjectMapper();
    }

    @Test
    public void testGetAllNoContent() throws Exception {
        // Arrange
        Mockito.when(personManager.findAll()).thenReturn(null);
        Mockito.when(entityConverter.convert(null, PersonDTO.class)).thenReturn(null);

        // Act
        ResultActions perform = mockMvc.perform(get("/person"));

        // Assert
        perform.andExpect(status().isOk());
    }


    @Test
    public void testGetAllWithContent() throws Exception {
        // Arrange
        Person person_1 = new Person();
        person_1.setName("pepe");
        Person person_2 = new Person();
        person_2.setName("juan");
        List<Person> persons = new ArrayList<>();
        persons.add(person_1);
        persons.add(person_2);
        List<PersonDTO> personDTOs = new ArrayList<>();
        Mockito.when(personManager.findAll()).thenReturn(persons);
        Mockito.when(entityConverter.convert(persons, PersonDTO.class)).thenReturn(new ArrayList<>());

        // Act
        ResultActions perform = mockMvc.perform(get("/person"));

        // Assert
        perform.andExpect(status().isOk());
        perform.andExpect(content().json(mapper.writeValueAsString(personDTOs)));
    }
}
