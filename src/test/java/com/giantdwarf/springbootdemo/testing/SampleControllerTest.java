package com.giantdwarf.springbootdemo.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK) // default
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // random port embedded tomcat
@AutoConfigureMockMvc
class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    SampleService mockSampleService;

    @Autowired
    WebTestClient webTestClient;

    @Test
    public void hello() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello seungin"))
                .andDo(print());
    }

    @Test
    public void hello2() throws Exception {
        when(mockSampleService.getName()).thenReturn("seungin");

        webTestClient.get().uri("/hello").exchange().expectStatus().isOk()
                .expectBody(String.class).isEqualTo("hello seungin");

    }
    @Test
    public void hello3() throws Exception {
        mockMvc.perform(get("/hello3"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name("hello3"))
                .andExpect(model().attribute("name",is("seungin")))
                .andExpect(content().string(containsString("seungin")));
    }

}