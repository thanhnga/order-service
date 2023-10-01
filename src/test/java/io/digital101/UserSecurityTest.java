package io.digital101;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.digital101.entity.UserRole;
import io.digital101.entity.UserStatus;
import io.digital101.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Random;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserSecurityTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void userWhenNotAuthenticated() throws Exception {
        // @formatter:off
        this.mockMvc.perform(get("/admin/create"))
                .andExpect(status().isForbidden());
        // @formatter:on
    }

    @Test
    @WithUserDetails(value = "owner", userDetailsServiceBeanName = "userDetailsService")
    void shouldCreateNewUserByOwner() throws Exception {
        // @formatter:off
        Users newUSer = intOperatorUser();
        mockMvc.perform(post("/admin/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newUSer)))
                .andExpect(status().isCreated());
        // @formatter:on
    }

    @Test
    @WithUserDetails(value = "operator", userDetailsServiceBeanName = "userDetailsService")
    void shouldForBiddenCreateNewUserByOtherUser() throws Exception {
        // @formatter:off
        Users newUSer = intOperatorUser();
        mockMvc.perform(post("/admin/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newUSer)))
                .andExpect(status().isForbidden());
        // @formatter:on
    }

    private Users intOperatorUser(){
        Users newUSer = new Users();
        newUSer.setStatus(UserStatus.ACTIVE);
        String reandomString = reandomString();
        newUSer.setUsername(reandomString);
        newUSer.setPassword(reandomString);
        newUSer.setRole(UserRole.OPERATOR);
        newUSer.setEmail(reandomString + "@gmail.com");
        return newUSer;
    }
    public String reandomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

}
