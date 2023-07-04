package Base.LandingPage.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.web.servlet.function.ServerResponse.status;

@RunWith(MockitoJUnitRunner.class)
public class AllDifferentRequestTypesTest {

    @InjectMocks
    AllDifferentRequestTypes allDifferentRequestTypes;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(allDifferentRequestTypes).build();
    }

    @Test
    public void test_getMapping() throws Exception {
        // Add params in the url itself if needed
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getMapping").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn(); // Need to add status wali value
        mvcResult.getResponse().getStatus(); // We can assert the status here itself
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
