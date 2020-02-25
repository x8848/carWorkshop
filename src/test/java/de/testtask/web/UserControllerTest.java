package de.testtask.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.testtask.domain.User;
import de.testtask.service.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    private static final String NAME1 = "user1";
    public static final String NAME2 = "user2";

    @Autowired
    private MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private UserRepository repository;

    private void setUp() {
        User user = new User(NAME1, "a", "kiev", "1", "ukraine");
        when(repository.findAll()).thenReturn(Arrays.asList(user, createUser()));
    }

    private User createUser() {
        return new User(NAME2, "b", "munich", "1", "germany");
    }

    @Test
    public void getAllUsers() throws Exception {
        setUp();
        mvc.perform(get("/user")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is(NAME1)))
                .andExpect(jsonPath("$[1].name", is(NAME2)));

        verify(repository, times(1)).findAll();
        verifyNoMoreInteractions(repository);
    }

    @Test
    public void createNewUserWithUniqueNameAndEmail() throws Exception {
        User user = createUser();
        when(repository.findAll()).thenReturn(Collections.emptyList());
        when(repository.save(user)).thenReturn(user);
        mvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user))
                .characterEncoding(StandardCharsets.UTF_8.name()))
                .andExpect(status().isOk());

        verify(repository, times(1)).save(user);
    }

    @Test
    public void createNewUserWithSameNameAndEmail() throws Exception {
        setUp();
        User user = createUser();
        mvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user))
                .characterEncoding(StandardCharsets.UTF_8.name()))
                .andExpect(status().isOk());

        verify(repository, times(0)).save(user);
    }

    @Test
    public void deleteUserByName() throws Exception {
        setUp();
        mvc.perform(MockMvcRequestBuilders
                .get("/user/delete/{name}", NAME2)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding(StandardCharsets.UTF_8.name()))
                .andExpect(status().isOk());

        verify(repository, times(1)).deleteById(NAME2);
    }
}