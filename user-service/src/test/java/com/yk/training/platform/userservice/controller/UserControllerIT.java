package com.yk.training.platform.userservice.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yk.training.platform.BaseIntegrationTest;
import com.yk.training.platform.TestHelper;
import com.yk.training.platform.userservice.configuration.UrlConstants;
import com.yk.training.platform.userservice.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

class UserControllerIT extends BaseIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldGetUser() throws Exception {
        final String response = mockMvc.perform(get(UrlConstants.API_USER_ITEM, "1")).andReturn().getResponse()
                .getContentAsString();
        final User user = objectMapper.readValue(response, User.class);
        TestHelper.assertUserIsValid(user);
    }

    @Test
    public void shouldGetUsers() throws Exception {
        TypeReference<List<User>> resolvedType = new TypeReference<>() {
        };
        String response = mockMvc.perform(get(UrlConstants.API_USER_SERVICE_USER)).andReturn().getResponse()
                .getContentAsString();
        List<User> user = objectMapper.readValue(response, resolvedType);
        TestHelper.assertUsersAreValid(user);
    }

    @Test
    public void shouldNotFindIdNotFound() throws Exception {
        final HttpServletResponse response = mockMvc.perform(get(UrlConstants.API_USER_ITEM, "100")).andReturn().getResponse();
        assertEquals(404, response.getStatus());
    }
}